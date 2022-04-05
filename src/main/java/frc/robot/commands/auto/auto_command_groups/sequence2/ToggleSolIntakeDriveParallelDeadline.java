// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.auto.auto_command_groups.sequence2;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import frc.robot.commands.ToggleSolenoids;
import frc.robot.commands.auto.base_auto_commands.DriveDistanceCommand;
import frc.robot.commands.intake_commands.IntakeCommand;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class ToggleSolIntakeDriveParallelDeadline extends ParallelDeadlineGroup {
  /** Creates a new ToggleSolIntakeDriveParallelDeadline. */
  public ToggleSolIntakeDriveParallelDeadline() {
    // Add the deadline command in the super() call. Add other commands using
    // addCommands().
    super(new DriveDistanceCommand(-0.25, 10.0));
    addCommands(new ToggleSolenoids(), new IntakeCommand());
  }
}
