// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.auto.base_auto_commands.AutoDriveCommand;
import frc.robot.commands.auto.command_groups.AutoFeederSequence;
import frc.robot.commands.auto.command_groups.AutoLaunchFeedParallel;
// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class FinalAutoSequence extends SequentialCommandGroup {
  /** Creates a new AutoSequence. */
  public FinalAutoSequence() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(new WaitCommand(1.0), new AutoLaunchFeedParallel(), new WaitCommand(1.0), new AutoDriveCommand(3500));
  }
}
