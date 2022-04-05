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

public class FeederSubsystem extends SubsystemBase{
    TalonSRX feeder;

    public FeederSubsystem() {
        feeder = new TalonSRX(RobotMap.feeder);

        feeder.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, 0, 0);
        // Config PID 
        //Launcher3.config_kP(0, P);
        //Launcher3.config_kI(0, I);
        //Launcher3.config_kD(0, D);
        //Launcher3.config_kF(0, FF); 

        feeder.configPeakOutputForward(1);
        feeder.configPeakOutputReverse(-1);

        //feeder.setInverted(true);
    } 
 
    public void setFeederVelocity (double setpoint) {
        // Set the first Talon's PID target to the setpoing (second Talon will follow)
        feeder.set(ControlMode.Velocity, setpoint);
        System.out.println("LAUNCHER: " + feeder.getSelectedSensorVelocity());
    }

    public void setFeederPercent (double percent) {
        feeder.set(ControlMode.PercentOutput, percent);
        System.out.println("LAUNCHER: " + feeder.getSelectedSensorVelocity());
    }
           
}