package frc.robot.commands.launcher;

import frc.robot.Robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class LauncherPIDVelocity extends CommandBase implements Command {

  double setpoint;

  public LauncherPIDVelocity (double setpoint) {
    this.setpoint = setpoint;
    addRequirements(Robot.LauncherSubsystem);
    //addRequirements(Robot.AcceleratorWheelSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Robot.LauncherSubsystem.setLauncherVelocity(setpoint);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.LauncherSubsystem.setLauncherPercent(0.0);
    //Robot.AcceleratorWheelSubsystem.setAcceleratorWheelPercent(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}