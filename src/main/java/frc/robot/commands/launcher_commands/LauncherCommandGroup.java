// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.launcher_commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class LauncherCommandGroup extends SequentialCommandGroup {
  /** Creates a new LauncherCommandGroup. */
  public double setpointFX = 0.25;
  public double setpointSRX = 0.5;
  public double waitTime = 1.5;

  public LauncherCommandGroup() {
    addCommands(new TalonFXCommands(setpointFX), new WaitCommand(waitTime), new TalonSRXCommands(setpointSRX));
  }
}
