// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.subsystems.ColorSensor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class IntakeSubsystem extends SubsystemBase {
  // A new motor controller object to control the 775 motor
  VictorSPX intakeMotor;
  // Double solenoid to complete the motions of getting the cargo in and out
  DoubleSolenoid intakeSol;

  public IntakeSubsystem() {

    intakeMotor = new VictorSPX(RobotMap.intakeMotor);
    intakeMotor.setInverted(true);

    intakeSol = new DoubleSolenoid(RobotMap.intakeSol1, RobotMap.intakeSol2);
  }

  // This method makes the motor spin based on a percentage based voltage input
  public void setPercentOutput (double output) {
    intakeMotor.set(ControlMode.PercentOutput, output);
  }

  // Take in or push out the cargo depending on its color
  public void colorIntake() {
    if (ColorSensor.colorString == RobotMap.color) {
      // Set solenoid forwards to take in the cargo
      intakeSol.set(DoubleSolenoid.Value.kForward);
    } else {
      // Set solenoid in reverse to push out the cargo
      intakeSol.set(DoubleSolenoid.Value.kReverse);
    }
  }
}