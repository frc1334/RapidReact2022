// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;


public class VisionSubsystem extends SubsystemBase {
  /** Creates a new Vision. */

  UsbCamera camera1;
  UsbCamera camera2;
  NetworkTableEntry cameraSelection;

  public VisionSubsystem() {
    camera1 = CameraServer.startAutomaticCapture(0);
    camera2 = CameraServer.startAutomaticCapture(1);
  }

  
  public void startCameraServer() {
    
    
    cameraSelection = NetworkTableInstance.getDefault().getTable("").getEntry("CameraSelection");
  }

  public void Labels() {
    cameraSelection.setString(camera2.getName());

    cameraSelection.setString(camera1.getName());
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
      
  }
  
}
