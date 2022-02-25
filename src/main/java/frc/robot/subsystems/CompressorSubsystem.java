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

  public void pumpAir() {
    compressor.enableDigital();
  }

  public void stopAir() {
    compressor.disable();
  }

  public boolean isEnabled() {
    return compressor.enabled();
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
