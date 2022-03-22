// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.RobotMap;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.RelativeEncoder;

public class SparkMaxClimberSubsystem extends SubsystemBase {
  CANSparkMax climbMotor;
  // DigitalInput lowerSwitch;
  RelativeEncoder encoder;

  /** Creates a new SparkMaxCLimberSubsystem. */
  public SparkMaxClimberSubsystem() {
    climbMotor = new CANSparkMax(RobotMap.climbMotor, MotorType.kBrushless);
    climbMotor.setIdleMode(IdleMode.kBrake);
    climbMotor.setSmartCurrentLimit(40);

    encoder = climbMotor.getEncoder();
    encoder.setPosition(0);
  }

  public void releaseClimber() {
    // Set the motor to coast so the bars are released
    climbMotor.setIdleMode(IdleMode.kCoast);
    climbMotor.set(0.2);
  }

  public void stopReleasingClimber() {
    climbMotor.set(0.0);
    climbMotor.setIdleMode(IdleMode.kBrake);
  }

  public boolean stopReleasingCheck() {
    if (encoder.getPosition() >= 2) {
      return true;
    } else {
      return false;
    }
  }

    // while (isClimbing) {
    //   if (encoder.getPosition() >= 2) {
    //     // Stop pulling up the robot and lock the motor once we reached the limit
    //     climbMotor.set(0.0);
    //     climbMotor.setIdleMode(IdleMode.kBrake);

    //     isClimbing = false;
    //   }
    // }
  
  public void pullRobot() {
    encoder.setPosition(0);
    // Motor spins to pull up the robot
    climbMotor.set(-0.2);//do we need coast?
  }
  
  public void stopPullingRobot() {
    climbMotor.set(0.0);
    climbMotor.setIdleMode(IdleMode.kBrake);
  }

  public boolean stopPullingCheck() {
    if (encoder.getPosition() >= 2) {
      return true;
    } else {
      return false;
    }
  }





  public void testingForward() {
    climbMotor.setIdleMode(IdleMode.kCoast);
    climbMotor.set(0.2);
  }

  public void testingReverse() {
    climbMotor.setIdleMode(IdleMode.kCoast);
    climbMotor.set(-1.0);
  }

}