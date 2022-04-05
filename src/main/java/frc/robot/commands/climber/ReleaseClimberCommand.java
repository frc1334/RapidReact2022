// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.climber;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class ReleaseClimberCommand extends CommandBase {
  /** Creates a new ReleaseClimberCommand - bars go upwards and stop automatically at their full height*/
  public ReleaseClimberCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.SparkMaxClimberSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Robot.SparkMaxClimberSubsystem.releaseClimber();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.SparkMaxClimberSubsystem.stopReleasingClimber();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (Robot.SparkMaxClimberSubsystem.stopReleasingCheck()) {
      return true;
    }
    return false;
  }
}
