// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.climber;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.Robot;

public class ClimbTestingForward extends CommandBase {
  /** Creates a new ClimbTestingForward - bars go upwards*/
  public ClimbTestingForward() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.SparkMaxClimberSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Robot.SparkMaxClimberSubsystem.testingForward();

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.SparkMaxClimberSubsystem.stopPullingRobot();

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
