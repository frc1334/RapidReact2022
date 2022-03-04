// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

/*-------------------------------------------------------------------------

Author: Zoey Xie                                  Date: Jan 22 2022

LauncherSRXSubsystem class for motor controller of 775 motor.

---------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

// Talon SRX is the big guy
public class LauncherSRXSubsystem extends SubsystemBase{
    TalonSRX Launcher3;

    public LauncherSRXSubsystem() {
        Launcher3 = new TalonSRX(RobotMap.Launcher3);

        Launcher3.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, 0, 0);
        // Config PID 
        //Launcher3.config_kP(0, P);
        //Launcher3.config_kI(0, I);
        //Launcher3.config_kD(0, D);
        //Launcher3.config_kF(0, FF); 

        Launcher3.configPeakOutputForward(1);
        Launcher3.configPeakOutputReverse(-1);

    } 
 
    public void setLauncherVelocity (double setpoint) {
        // Set the first Talon's PID target to the setpoing (second Talon will follow)
        Launcher3.set(ControlMode.Velocity, setpoint);
        System.out.println("LAUNCHER: " + Launcher3.getSelectedSensorVelocity());
    }

    public void setLauncherPercent (double percent) {
        Launcher3.set(ControlMode.PercentOutput, percent);
        Launcher3.set(ControlMode.PercentOutput, percent);
        System.out.println("LAUNCHER: " + Launcher3.getSelectedSensorVelocity());
    }
           
}