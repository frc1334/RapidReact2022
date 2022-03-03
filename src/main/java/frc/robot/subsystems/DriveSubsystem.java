// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

/*-------------------------------------------------------------------------

Author: Clarrie Wang                                     Date: Jan 22 2022

DriveSubsystem class for differential drivetrain using 4 NEO brushless motors.

---------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

import com.revrobotics.CANSparkMax;
// import com.revrobotics.CANSparkMax.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;

// import edu.wpi.first.wpilibj.drive.DifferentialDrive;
// import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

public class DriveSubsystem extends SubsystemBase {
  // using 3 Spark Max motor controllers, 1s for front motors, 2 for back
  CANSparkMax L1motor;
  RelativeEncoder L1encoder;
  SparkMaxPIDController L1controller;

  CANSparkMax L2motor;
  RelativeEncoder L2encoder;
  SparkMaxPIDController L2controller;

  CANSparkMax R1motor;
  RelativeEncoder R1encoder;
  SparkMaxPIDController R1controller;

  CANSparkMax R2motor;
  RelativeEncoder R2encoder;
  SparkMaxPIDController R2controller;

  // Grouping together the motor controllers on the left side
   MotorControllerGroup LeftControllerGroup;
   MotorControllerGroup RightControllerGroup;

  // Differential drivetrain object (aka West Coast/Tank drive)
   DifferentialDrive DifferentialDriveTrain;

  public DriveSubsystem() {
    L1motor = new CANSparkMax(RobotMap.L1motor, MotorType.kBrushless);
    L1encoder = L1motor.getEncoder();
    L1controller = L1motor.getPIDController();
  
    L2motor = new CANSparkMax(RobotMap.L2motor, MotorType.kBrushless);
    L2encoder = L2motor.getEncoder();
    L2controller = L2motor.getPIDController();
  
    R1motor = new CANSparkMax(RobotMap.R1motor, MotorType.kBrushless);
    R1encoder = R1motor.getEncoder();
    R1controller = R1motor.getPIDController();
  
    R2motor = new CANSparkMax(RobotMap.R2motor, MotorType.kBrushless);
    R2encoder = R2motor.getEncoder();
    R2controller = R2motor.getPIDController();

    // Grouping together the motor controllers on the left side
   LeftControllerGroup = new MotorControllerGroup(L1motor, L2motor);
     RightControllerGroup = new MotorControllerGroup(R1motor, R2motor);

    // Differential drivetrain object (aka West Coast/Tank drive)
    // only used for drive pid
    // DifferentialDriveTrain = new DifferentialDrive(LeftControllerGroup, RightControllerGroup);

    // make the back motor on left side the follower of the L1motor, not needed
     //L2motor.follow(L1motor); // doesn't work
    // R2motor.follow(R1motor);
    
    // reset encoders to start at 0
    L1encoder.setPosition(0);
    L2encoder.setPosition(0);    
    R1encoder.setPosition(0);
    R2encoder.setPosition(0);
  }

  // feed percent voltage power into both sides of drive train
  // mapping individual motors to voltage 
  public void TankDrive(double Left, double Right) {
    L1motor.set(-Left);
    L2motor.set(-Left);
    R1motor.set(Right);
    R2motor.set(Right);
  }

  // wrapper function that allows for turning in tank drive
  public void ArcadeDrive(double speed, double turn) {
    TankDrive(speed - turn, speed + turn);
  }
}
