// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.RobotMap;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMax.IdleMode;
import edu.wpi.first.wpilibj.DigitalInput;

public class SparkMaxClimberSubsystem extends SubsystemBase {
  CANSparkMax climbMotor;
  DigitalInput lowerSwitch;
  DigitalInput upperSwitch;
  boolean isClimbing;
  boolean isReleasing;

  /** Creates a new SparkMaxCLimberSubsystem. */
  public SparkMaxClimberSubsystem() {

    climbMotor = new CANSparkMax(RobotMap.climbMotor, MotorType.kBrushless);
    climbMotor.setIdleMode(IdleMode.kBrake);

    climbMotor.setSmartCurrentLimit(40);

    // Limit switch
    lowerSwitch = new DigitalInput(0);
    upperSwitch = new DigitalInput(1);
    
    isClimbing = false;
    isReleasing = false;
  }

  public void releaseClimber() {

    isReleasing = true;
    // Set the motor to coast so the bars are released
    climbMotor.setIdleMode(IdleMode.kCoast);
    climbMotor.set(-1.0);

    while (isReleasing) {

      if (upperSwitch.get()) {
        // Stop pulling up the robot and lock the motor once we reached the limit
        climbMotor.set(0.0);
        climbMotor.setIdleMode(IdleMode.kBrake);

        isReleasing = false;
      }
    }


  }

  public void pullRobot() {
    isClimbing = true;
    // Motor spins to pull up the robot
    climbMotor.set(1.0);

    while (isClimbing) {

      if (lowerSwitch.get()) {
        // Stop pulling up the robot and lock the motor once we reached the limit
        climbMotor.set(0.0);
        climbMotor.setIdleMode(IdleMode.kBrake);

        isClimbing = false;
      }
    }
  }
}
