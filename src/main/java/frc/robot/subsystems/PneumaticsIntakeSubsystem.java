// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.hal.CTREPCMJNI;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PneumaticsIntakeSubsystem extends SubsystemBase {
  /** Creates a new PneumaticsSubsystem. */
  Compressor compressor;

  public PneumaticsIntakeSubsystem() {
    compressor = new Compressor(0, PneumaticsModuleType.CTREPCM);
    compressor.setClosedLoopControl(0, true); // pump air
  }

  public void pumpAirOn() {
    compressor.setClosedLoopControl(true);
  }

  public void pumpAirOff() {
    compressor.setClosedLoopControl(false);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
