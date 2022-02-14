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
  public static final int intakeMotor = 8;

  // IntakeSubsystem: Double Solenoid
  public static final int intakeSol1 = 9;
  public static final int intakeSol2 = 10;

  // IntakeSubsystem: cargo color
  public static final String color = "Red";

}