// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

/*-------------------------------------------------------------------------

Author: Zoey Xie                                  Date: Jan 22 2022

LauncherFXSubsystem class for motor controller of 775 motor.

---------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

// Talon SRX is the big guy
public class LauncherSRXSubsystem extends SubsystemBase{
    TalonSRX Launcher3 = new TalonSRX(RobotMap.Launcher3);

    public LauncherSRXSubsystem(double P, double I, double D, double FF) {

        // Config PID 
        Launcher3.config_kP(0, P);
        Launcher3.config_kI(0, I);
        Launcher3.config_kD(0, D);
        // Launcher1.config_kF(0, FF); 

    } 
 
    public void setLauncherVelocity (double setpoint) {
        // Set the first Talon's PID target to the setpoing (second Talon will follow)
        Launcher3.set(ControlMode.Velocity, setpoint);
        System.out.println("LAUNCHER: " + Launcher3.getSelectedSensorVelocity());
    }


}