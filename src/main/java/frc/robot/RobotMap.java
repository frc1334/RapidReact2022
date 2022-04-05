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
  public static final int L1motor = 1;
  public static final int L2motor = 2;
  public static final int R1motor = 3;
  public static final int R2motor = 4;

  // IntakeSubsystem: 1 TalonFRX Motor Controller
  public static final int intakeMotor = 10;

  // // IntakeSubsystem: cargo color (may be changed depending on the real situation)
  // public static final String color = "Red";

  // //ColorSensor: 1 Color Sensor V3
  // public static final int ColorSensor = 9;


  // Launcher: 2 Falcons
  // Launcher1: left; Launcher2: right; Launcher3: feeder wheel 
  public static final int LauncherLeft = 7;
  public static final int LauncherRight = 8;
  public static final int feeder = 5;

  //added by William Kozlowski for the IndexerSubsystem.java
  // Indexer1: higher indexer
  // Indexer2: lower indexer
  public static final int HigherIndexer = 9;
  public static final int LowerIndexer = 6;

  //Climber: 2 Falcons
  public static final int climbMotor = 11;
}  
