package frc.robot.commands.launcher_commands;

import frc.robot.Robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class TalonSRXCommands extends CommandBase {

  double setpoint;

  public TalonSRXCommands(double setpoint) {
    this.setpoint = setpoint;
    addRequirements(Robot.LauncherSRXSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Robot.LauncherSRXSubsystem.setLauncherVelocity(setpoint);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}