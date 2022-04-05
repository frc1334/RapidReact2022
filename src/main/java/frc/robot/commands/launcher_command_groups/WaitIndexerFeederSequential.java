// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.launcher_command_groups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.auto.base_auto_commands.TimedIndexerCommand;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class WaitIndexerFeederSequential extends SequentialCommandGroup {
  /** Creates a new WaitIndexerFeederSequential - runs indexer for x milliseconds, wait, and then indexer and feeder parallel command*/
  public WaitIndexerFeederSequential() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(new TimedIndexerCommand(250), new WaitCommand(0.75), new IndexerFeederParallel());
  }
}
