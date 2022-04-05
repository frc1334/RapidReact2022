// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.launcher_command_groups;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.commands.auto.base_auto_commands.TimedLaunchCommand;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class FinalLauncherParallel extends ParallelCommandGroup {
  /** Creates a new FinalLauncherParallel. Runs launcher for x seconds while running the wait indexer feeder sequence */
  public FinalLauncherParallel() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(new TimedLaunchCommand(3000), new WaitIndexerFeederSequential());
  }
}
