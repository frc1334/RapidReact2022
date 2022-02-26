// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.subsystems.ColorSensor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.PneumaticsModuleType;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class IntakeSubsystem extends SubsystemBase {
  // A new motor controller object to control the 775 motor
  VictorSPX intakeMotor;

  public IntakeSubsystem() {
    public String tryColor = m_colorSensor.colorMatch();
    intakeMotor = new VictorSPX(RobotMap.intakeMotor);
    intakeMotor.setInverted(true);
  }

  // This method makes the motor spin based on a percentage based voltage input
  public void setPercentOutput (double output) {
    intakeMotor.set(ControlMode.PercentOutput, output);
  }

  // Take in or push out the cargo depending on its color
  public void colorIntake() {    
    m_colorSensor.colorMatch();
    if (colorString == RobotMap.color) {
      setPercentOutput(0.25);
    } else {
      setPercentOutput(0.0);
      // 0 or negative? Do we need to take the ball in before sensing the color?
    }
  }
}