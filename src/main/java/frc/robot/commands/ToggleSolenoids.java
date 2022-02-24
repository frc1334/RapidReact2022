// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class ToggleSolenoids extends CommandBase {
  /** Creates a new ToggleSolenoids. */
  public ToggleSolenoids() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.TestingSolenoids); // this is technically supposed declare PneumaticsSubsystem, the class was renamed and now the code can't recognize it
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Robot.TestingSolenoids.toggleSolenoid();
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
