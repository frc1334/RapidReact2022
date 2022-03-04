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
public class LauncherFXSubsystem extends SubsystemBase{
      // The Launcher Talons; 1 is left and 2 is right.
  TalonFX Launcher1;
  TalonFX Launcher2;

  public LauncherFXSubsystem() {

    Launcher1 = new TalonFX(RobotMap.Launcher1);
    Launcher2 = new TalonFX(RobotMap.Launcher2);
    
    // Configure the default Integrated Sensors for the Talons
    Launcher1.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, 0, 0);
    Launcher2.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, 0, 0);

    // Set the second Talon to follow the first Talon
    Launcher2.set(ControlMode.Follower, RobotMap.Launcher1);
    
    // Invert the first Talon (Left and Right can now run the same Velocity PID RPM)
    Launcher1.setInverted(true);

    // Configure the peak output (max in magnitude both forwards and reverse) for the first Talon
    Launcher1.configPeakOutputForward(1);
    Launcher1.configPeakOutputReverse(-1);
    Launcher2.configPeakOutputForward(1);
    Launcher2.configPeakOutputReverse(-1);

  }

  // This void method sets a velocity PID setpoint on the Talons
  public void setLauncherVelocity (double setpoint) {
    // Set the first Talon's PID target to the setpoing (second Talon will follow)
    Launcher1.set(ControlMode.Velocity, setpoint);
    Launcher2.set(ControlMode.Velocity, setpoint);
    System.out.println("LAUNCHER: " + Launcher1.getSelectedSensorVelocity());
  }

  // This void method manually sets the percent power input to the Launcher Falcons
  public void setLauncherPercent (double percent) {
    Launcher1.set(ControlMode.PercentOutput, percent);
    Launcher2.set(ControlMode.PercentOutput, percent);
    System.out.println("LAUNCHER: " + Launcher1.getSelectedSensorVelocity());
  }


}
