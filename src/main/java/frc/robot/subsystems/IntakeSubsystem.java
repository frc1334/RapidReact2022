// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import frc.robot.RobotMap;
import frc.robot.subsystems.ColorSensor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DoubleSolenoid;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class IntakeSubsystem extends SubsystemBase {
  // A motor controller object to control the 775 motor
  VictorSPX motorController;
  // Double solenoid to complete the motions of getting the cargo in and out
  DoubleSolenoid doubleSolenoid;

  public IntakeSubsystem() {
    motorController.setInverted(true);
  }

  // This method makes the motor spin based on a percentage based voltage input
  public void setPercentOutput (double output) {
    motorController.set(ControlMode.PercentOutput, output);
  }

  // Take in or push out the cargo depending on its color
  public void colorIntake(String color) {
    if (color == ColorSensor.colorString) {
      // Set solenoid forwards to take in the cargo
      doubleSolenoid.set(DoubleSolenoid.Value.kForward);
    } else {
      // Set solenoid in reverse to push out the cargo
      doubleSolenoid.set(DoubleSolenoid.Value.kReverse);
    }
  }
}