// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

/*-------------------------------------------------------------------------

Author: Zoey Xie                                  Date: Jan 22 2022

LauncherFXSubsystem class for motor controllers of TalonFX motors. (Big wheel on launcher)

---------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

// Talon FX is the small motor
public class LauncherSubsystem extends SubsystemBase{
      // The Launcher Talons; 1 is left and 2 is right.
  TalonFX LauncherLeft;
  TalonFX LauncherRight;

  public LauncherSubsystem() {

    LauncherLeft = new TalonFX(RobotMap.LauncherLeft);
    LauncherRight = new TalonFX(RobotMap.LauncherRight);
    
    // Configure the default Integrated Sensors for the Talons
    LauncherLeft.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, 0, 0);
    LauncherRight.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, 0, 0);

    // Set the second Talon to follow the first Talon
    LauncherRight.set(ControlMode.Follower, RobotMap.LauncherLeft);
    // Config PID 
    //LauncherLeft.config_kP(0, P);
    //LauncherLeft.config_kI(0, I);
    //LauncherLeft.config_kD(0, D);
    //LauncherLeft.config_kF(0, FF);
    
    // Invert the first Talon (Left and Right can now run the same Velocity PID RPM)
    LauncherLeft.setInverted(true);

    // Configure the peak output (max in magnitude both forwards and reverse) for the first Talon
    LauncherLeft.configPeakOutputForward(1);
    LauncherLeft.configPeakOutputReverse(-1);
    LauncherRight.configPeakOutputForward(1);
    LauncherRight.configPeakOutputReverse(-1);

  }

  // This void method sets a velocity PID setpoint on the Talons
  public void setLauncherVelocity (double setpoint) {
    // Set the first Talon's PID target to the setpoing (second Talon will follow)
    LauncherLeft.set(ControlMode.Velocity, setpoint);
    LauncherRight.set(ControlMode.Velocity, setpoint);
    System.out.println("LAUNCHER: " + LauncherLeft.getSelectedSensorVelocity());
  }

  // This void method manually sets the percent power input to the Launcher Falcons
  public void setLauncherPercent (double percent) {
    LauncherLeft.set(ControlMode.PercentOutput, percent);
    LauncherRight.set(ControlMode.PercentOutput, percent);
    System.out.println("LAUNCHER: " + LauncherLeft.getSelectedSensorVelocity());
  }


}
