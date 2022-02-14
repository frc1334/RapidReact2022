// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

/*

Created by: William Kozlowski

Created 2022-02-10

Modified 2022-02-14, by William Kozlowski

Indexer Subsystem, helps to sort/push the ball to fit into the conveyer, and preps the ball to be shot

*/

//imported https://maven.ctr-electronics.com/release/com/ctre/phoenix/Phoenix-frc2022-latest.json

package frc.robot.subsystems;

import frc.robot.RobotMap;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;


public class IndexerSubsystem extends SubsystemBase {
  /** Creates a new IndexerSubsystem. */

  //replace TalonFX with whatever motor controller we're using
  TalonFX FeederMotor;

  public IndexerSubsystem() {
    //FeederMotor is set to channel ID 5 in RobotMap.java for now
    FeederMotor = new TalonFX(RobotMap.FeederMotor);
  }


  public void setIndexerVoltage (double voltage) {
    //varible ControlMode is pulled from the "com.ctre.phoenix.motorcontrol.ControlMode" import
    FeederMotor.set(ControlMode.PercentOutput, voltage);
  }

  //@Override
  //public void periodic() {
    //This method will be called once per scheduler run
  //}
}
