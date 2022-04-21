// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
package frc.robot.subsystems;

import frc.robot.RobotMap;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

// import edu.wpi.first.wpilibj.I2C;
// import edu.wpi.first.wpilibj.util.Color;

// import com.revrobotics.ColorSensorV3;
// import com.revrobotics.ColorMatchResult;
// import com.revrobotics.ColorMatch;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class IntakeSubsystem extends SubsystemBase {

    // A new motor controller object to control the 775 motor
    public TalonSRX intakeMotor;

    // boolean toggle = false;
    DoubleSolenoid IntakeSol;

    public IntakeSubsystem() {
        IntakeSol = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 2, 3);
        // Initialize the solenoid to start on reverse
        IntakeSol.set(Value.kReverse);
        intakeMotor = new TalonSRX(RobotMap.intakeMotor);
        intakeMotor.setInverted(true);
        // intakeMotor.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, 0, 0);

        intakeMotor.configPeakOutputForward(1.0);
        intakeMotor.configPeakOutputReverse(-1.0);
    }

    // This method makes the motor spin based on a percentage based voltage input
    public void setPercentOutput (double output) {
        intakeMotor.set(ControlMode.PercentOutput, output);
    }

    public void driverIntake() {
        // if (axis > 0) {
        //     setPercentOutput(0.25);
        // } else if (axis < 0) {
        //     setPercentOutput(-0.25);
        // }
        setPercentOutput(0.6);
           
    }

    // toggles the solenoid to get intake up and down
    public void toggleSolenoid() {
        IntakeSol.toggle();
        
    }

    public void closeSolenoid() {
        IntakeSol.close();
    }

    public void solOff() {
        IntakeSol.set(Value.kOff);
    }

    
    

    // // This is a void method for deploying the Intake via actuating the pistons. The parameter deploy indicates whether to deploy or retract the intake
    // public void deployIntake (boolean deploy) {
    //     // Check for the deployment states: deploy and retract (true or false on the deploy argument)
    //     if (deploy == true) {
    //     // Deploy, set solenoid to forwards
    //     IntakeSol.set(DoubleSolenoid.Value.kForward);
    //     } else if (deploy == false) {
    //     // Retract, set solenoid to reverse
    //     IntakeSol.set(DoubleSolenoid.Value.kReverse);
    //     }
    // }
    
    // // This void method toggles the intake deployment
    // public void toggleSolenoid () {
    //     IntakeSol.toggle();
    //     /*
    //     System.out.println(toggle);
    //     boolean toggleInside = toggle;
    //     // Deploy the current state of the intake
    //     deployIntake(toggleInside);
    //     // Toggle the toggle boolean
    //     toggle = !toggle;
    //     */
    // }
    // public void closeSol(){
    //     IntakeSol.set(Value.kReverse);
    // }

    // public void openSol(){
    //     IntakeSol.set(Value.kForward);
    // }

    // public void solStartSet() {
    //     IntakeSol.set(Value.kReverse);
    // }


    // // Color sensor
    // final I2C.Port i2cPort = I2C.Port.kOnboard;
    // final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);
    // String colorString;
  
    // // Color match
    // ColorMatch m_colorMatcher = new ColorMatch();
  
    // // Set up RGB values of the target colors
    // private final Color kBlueTarget = new Color(0.143, 0.427, 0.429);
    // private final Color kRedTarget = new Color(0.561, 0.232, 0.114);
    // public String tryColor;


    // public IntakeSubsystem() {
    //     tryColor = colorMatch();
    //     intakeMotor = new VictorSPX(RobotMap.intakeMotor);
    //     intakeMotor.setInverted(true);
    //     IntakeSol = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 2, 3);
    // }

    
    // // Take in or push out the cargo depending on its color
    // public void colorIntake() {    
    //     String colorString = colorMatch();
    //     if (colorString == RobotMap.color) {
    //     setPercentOutput(0.5);
    //     } else {
    //     setPercentOutput(0.0);
    //     // 0 or negative? Do we need to take the ball in before sensing the color?
    //     }
    // }

    // public String colorMatch() {

    //     m_colorMatcher.addColorMatch(kBlueTarget);
    //     m_colorMatcher.addColorMatch(kRedTarget);

    //     // Returns a color value from the sensor
    //     Color detectedColor = m_colorSensor.getColor();
    //     // Returns a raw IR value of the infrared detected
    //     double IR = m_colorSensor.getIR(); // proximity? if not can be deleted
    //     int proximity = m_colorSensor.getProximity();

    //      // Determine if the object is close enough to provide the accurate color values
    //     boolean validDistance = false;

    //     if (proximity > 0) {
    //         validDistance = true;
    //     }
        
    //     if (validDistance) {

    //         // Run the color match on our detected color
    //         ColorMatchResult match = m_colorMatcher.matchClosestColor(detectedColor);

    //         if (match.color == kBlueTarget) {
    //             colorString = "Blue";
    //         } else if (match.color == kRedTarget) {
    //             colorString = "Red";
    //         } else {
    //             colorString = "Unknown";
    //         }
            
    //     }

    //     return colorString;
    // }

    // For driver to manually control the bot to take in or push out a ball
    

    
}