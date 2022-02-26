// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

/*-------------------------------------------------------------------------

Author: Clarrie Wang                                     Date: Jan 22 2022

RobotMap: states all the device channel port IDs used by components in each
subsystem.

---------------------------------------------------------------------------*/
package frc.robot;

public class RobotMap {
  /* --- MOTORS --- */
  // DriveSubsystem: 3 Spark Maxes
  public static final int L1motor = 0;
  public static final int L2motor = 1;
  public static final int R1motor = 15;
  public static final int R2motor = 14;

  // IntakeSubsystem: 1 TalonFRX Motor Controller
  public static final int intakeMotor = 8;

  // IntakeSubsystem: cargo color (may be changed depending on the real situation)
  public static final String color = "Red";

  //ColorSensor: 1 Color Sensor V3
  public static final int ColorSensor = 9;


  // Launcher: 2 Falcons
  public static final int Launcher1 = 6;
  public static final int Launcher2 = 7;

  //added by William Kozlowski for the IndexerSubsystem.java
  public static final int FeederMotor1 = 5;
  public static final int FeederMotor2 = 11;

  public static final int FeederMotor = 5;
  
   // Climber: 2 Falcons
  public static final int LeftClimbMotor = 9;
  public static final int RightClimbMotor = 10;
}
