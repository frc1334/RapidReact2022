// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
package frc.robot.subsystems;

import frc.robot.RobotMap;
import frc.robot.OI;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.util.Color;

import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorMatch;

public class IntakeSubsystem extends SubsystemBase {
    // Color sensor
    final I2C.Port i2cPort = I2C.Port.kOnboard;
    final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);
    String colorString;
  
    // Color match
    ColorMatch m_colorMatcher = new ColorMatch();
  
    // Set up RGB values of the target colors
    private final Color kBlueTarget = new Color(0.143, 0.427, 0.429);
    private final Color kRedTarget = new Color(0.561, 0.232, 0.114);
    public String tryColor;

    // A new motor controller object to control the 775 motor
    VictorSPX intakeMotor;

    public IntakeSubsystem() {
        tryColor = colorMatch();
        intakeMotor = new VictorSPX(RobotMap.intakeMotor);
        intakeMotor.setInverted(true);
    }

    // This method makes the motor spin based on a percentage based voltage input
    public void setPercentOutput (double output) {
        intakeMotor.set(ControlMode.PercentOutput, output);
    }

    // Take in or push out the cargo depending on its color
    public void colorIntake() {    
        String colorString = colorMatch();
        if (colorString == RobotMap.color) {
        setPercentOutput(0.25);
        } else {
        setPercentOutput(0.0);
        // 0 or negative? Do we need to take the ball in before sensing the color?
        }
    }

    public String colorMatch() {

        m_colorMatcher.addColorMatch(kBlueTarget);
        m_colorMatcher.addColorMatch(kRedTarget);

        // Returns a color value from the sensor
        Color detectedColor = m_colorSensor.getColor();
        // Returns a raw IR value of the infrared detected
        double IR = m_colorSensor.getIR(); // proximity? if not can be deleted
        int proximity = m_colorSensor.getProximity();

         // Determine if the object is close enough to provide the accurate color values
        boolean validDistance = false;

        if (proximity > 0) {
            validDistance = true;
        }
        
        if (validDistance) {

            // Run the color match on our detected color
            ColorMatchResult match = m_colorMatcher.matchClosestColor(detectedColor);

            if (match.color == kBlueTarget) {
                colorString = "Blue";
            } else if (match.color == kRedTarget) {
                colorString = "Red";
            } else {
                colorString = "Unknown";
            }
            
        }

        return colorString;
    }

    // For driver to manually control the bot to take in or push out a ball
    public void driverIntake(double axis) {
        if (axis > 0) {
            setPercentOutput(0.25);
        } else if (axis < 0) {
            setPercentOutput(-0.25);
        }         
           
    }

}