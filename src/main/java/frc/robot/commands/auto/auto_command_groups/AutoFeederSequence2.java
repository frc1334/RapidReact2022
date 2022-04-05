// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.auto.auto_command_groups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.auto.base_auto_commands.TimedFeederCommand;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AutoFeederSequence2 extends SequentialCommandGroup {
  /** Creates a new AutoFeederSequence - runs feeder for x milliseconds, wati command for y seconds and feeder for z milliseconds in sequence*/
  public AutoFeederSequence2() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(new TimedFeederCommand(1000), new WaitCommand(2), new TimedFeederCommand(1000));
  }
}

//create sequential program
    //calls feedercommand.java (1 second)
    //waits 1.5 seconds
    //calls feedercommand.java again (1000)

//create sequential program
    //calls indexercommand.java to run for length of shooting

  //make both programs parrallel to each other

  //and make the parrallel programs into an instant command
