// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.auto.base_auto_commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class DriveDistanceCommand extends CommandBase {
  double speed;
  double rotations;

  /** Creates a new DriveOffDistanceCommand with parameters speed (voltage) and distance in inches. */
  public DriveDistanceCommand(double speed, double rotations) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.DriveSubsystem);
    this.speed = speed;
    this.rotations = rotations;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Robot.DriveSubsystem.ArcadeDrive(speed, 0.0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.DriveSubsystem.ArcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (Robot.DriveSubsystem.driveDistance(rotations)) {
      return true;
    } else {
      return false;
    }
  }
}
