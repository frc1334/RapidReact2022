// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

/*-------------------------------------------------------------------------

Author: Clarrie Wang                                     Date: Feb 18 2022

PneumaticsSubsystem class. Cylinders attached to Intake to allow it to be lowered and retracted. 
Controlled by double solenoids: https://dylan-frc-docs.readthedocs.io/en/latest/docs/software/actuators/solenoids.html

---------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class PneumaticsSubsystem extends SubsystemBase {
  boolean toggle = false;
  DoubleSolenoid IntakeSol;
  
  /** Creates a new PneumaticsSubsystem. */
  public PneumaticsSubsystem() {
    IntakeSol = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 1, 2);
  }

  // This is a void method for deploying the Intake via actuating the pistons. The parameter deploy indicates whether to deploy or retract the intake
  public void deployIntake (boolean deploy) {
    // Check for the deployment states: deploy and retract (true or false on the deploy argument)
    if (deploy) {
      // Deploy, set solenoid to forwards
      IntakeSol.set(DoubleSolenoid.Value.kForward);
    } else if (!deploy) {
      // Retract, set solenoid to reverse
      IntakeSol.set(DoubleSolenoid.Value.kReverse);
    }

  }

  // This void method toggles the intake deployment
  public void toggleSolenoid () {
    // Deploy the current state of the intake
    deployIntake(toggle);
    // Toggle the toggle boolean
    toggle = !toggle;
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
