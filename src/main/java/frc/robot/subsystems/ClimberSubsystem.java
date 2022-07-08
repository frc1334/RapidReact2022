// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

/*-------------------------------------------------------------------------

                                                      Date: Jan 22 2022

ClimberSubsystem class using 1 NEO SparkMax. 
Main actions: climb arms go up --> winch down once attached to hangar bar

---------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.RobotMap;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.RelativeEncoder;

public class ClimberSubsystem extends SubsystemBase {
  CANSparkMax climbMotor;
  RelativeEncoder encoder;

  /** Creates a new SparkMaxCLimberSubsystem. */
  public ClimberSubsystem() {
    // initialize 1 SparkMax motor controller (in brake mode so bars don't fly out on their own) and its encoder
    climbMotor = new CANSparkMax(RobotMap.climbMotor, MotorType.kBrushless);
    climbMotor.setIdleMode(IdleMode.kBrake);
    climbMotor.setSmartCurrentLimit(40);

    encoder = climbMotor.getEncoder();
    encoder.setPosition(0);
  }

  // climb arms go up as motor is put to 100% power
  public void releaseClimber() {
    // Set the motor to coast so the bars are released
    climbMotor.setIdleMode(IdleMode.kCoast); // just using brake mode would've been fine
    climbMotor.set(1.0);
    System.out.println(encoder.getPosition());
  }

  // climb arms stop
  public void stopReleasingClimber() {
    climbMotor.set(0.0);
    climbMotor.setIdleMode(IdleMode.kBrake);
    System.out.println(encoder.getPosition());
  }

  // check method to automatically allow arms to go up to set height based off encoder count
  // ONLY USE ONCE PER MATCH - BOT MUST BE CYCLED OR ENCODER COUNT WILL NOT RESET
  public boolean stopReleasingCheck() {
    System.out.println(encoder.getPosition());
    if (encoder.getPosition() >= 320) { // test 320 gearbox ratio now 80:1
      return true;
    } else {
      return false;
    }
  }
  
  // climb arms stop (repeat method)
  public void stopPullingRobot() {
    climbMotor.set(0.0);
    climbMotor.setIdleMode(IdleMode.kBrake);
  }

  // climb arms go up as motor is put to 100% power (repeat method)
  public void testingForward() {
    climbMotor.setIdleMode(IdleMode.kCoast);
    climbMotor.set(1.0);
  }

  // climb arms go down as motor is put to 100% power
  public void testingReverse() {

    climbMotor.setIdleMode(IdleMode.kCoast);
    climbMotor.set(-1.0); //change it to -1DONE
  }
}