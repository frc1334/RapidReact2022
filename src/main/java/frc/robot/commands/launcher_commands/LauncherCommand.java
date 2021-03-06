// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.launcher_commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class LauncherCommand extends CommandBase {

  double setpoint;

  /** Creates a new TalonFXPercentCommand. */
  public LauncherCommand(double setpoint) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.setpoint = setpoint;
    addRequirements(Robot.LauncherSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Robot.LauncherSubsystem.setLauncherVelocity(setpoint);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.LauncherSubsystem.setLauncherVelocity(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
