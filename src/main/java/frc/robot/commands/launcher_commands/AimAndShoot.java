// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.launcher_commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class AimAndShoot extends CommandBase {
  double target = 0.0;
  /** Creates a new AimAndShoot. */
  public AimAndShoot() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.LimelightSubsystem);
    addRequirements(Robot.LauncherSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    if (Robot.LimelightSubsystem.getTargetArea() > 0) {
      target = Robot.LimelightSubsystem.getTargetArea() * 10000;
      target = 10000 - target;
    } else {
      target = 0;
    }

    Robot.LauncherSubsystem.setLauncherVelocity(target);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
