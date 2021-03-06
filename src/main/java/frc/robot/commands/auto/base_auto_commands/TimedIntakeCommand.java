// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.auto.base_auto_commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.Robot;

public class TimedIntakeCommand extends CommandBase {
  /** Creates a new TimedIndexerCommand - runs indexer for x milliseconds. */
  long endTime;
  long startTime;

  public TimedIntakeCommand(long time) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.IntakeSubsystem);
    endTime = time;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    startTime = System.currentTimeMillis();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Robot.IntakeSubsystem.setPercentOutput(0.6);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.IntakeSubsystem.setPercentOutput(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (System.currentTimeMillis() >= (startTime + endTime)) {
      return true;
    }
    return false;
  }
}
