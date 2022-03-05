// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.launcher_commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class TalonFXPercentCommand extends CommandBase {
  /** Creates a new TalonFXPercentCommand. */
  public TalonFXPercentCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.LauncherFXSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Robot.LauncherFXSubsystem.setLauncherPercent(1.0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.LauncherFXSubsystem.setLauncherPercent(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
