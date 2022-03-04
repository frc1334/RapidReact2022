// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class CompressorSubsystem extends SubsystemBase {
  /** Creates a new PneumaticsSubsystem. */
  Compressor compressor;

  public CompressorSubsystem() {
    compressor = new Compressor(PneumaticsModuleType.CTREPCM);
    compressor.enableDigital();
  }

    public void setCompressorState (boolean state) {
      if (state = true) {
        compressor.enableDigital();
      } else if (state = false) {
        compressor.disable();
      }
  }
}
