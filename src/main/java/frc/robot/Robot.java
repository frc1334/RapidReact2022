// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
<<<<<<< HEAD
import frc.robot.subsystems.TestingSolenoids;
import frc.robot.subsystems.ColorSensor;
=======
import frc.robot.subsystems.PneumaticsSubsystem;
>>>>>>> 24490dc7e9e0f7f7b7376270e6972a6a4fc43ec6
//import frc.robot.commands.AutoDriveCommand;
import frc.robot.commands.DriveCommand;
<<<<<<< HEAD
import frc.robot.subsystems.IndexerSubsystem;
=======
import frc.robot.commands.IntakeCommand;

import com.revrobotics.ColorSensorV3;
>>>>>>> 63f040449d8492d38e8653d71a50b978d91c4b8e

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();

  // Initializing subsystems:
  public static DriveSubsystem DriveSubsystem = new DriveSubsystem();
<<<<<<< HEAD
  public static IndexerSubsystem IndexerSubsystem = new IndexerSubsystem(); //added by will
=======
  public static IntakeSubsystem IntakeSubsystem = new IntakeSubsystem();
<<<<<<< HEAD
  public static TestingSolenoids TestingSolenoids = new TestingSolenoids();
  public static ColorSensor ColorSensor = new ColorSensor(); 
=======

  public static PneumaticsSubsystem TestingSolenoids = new PneumaticsSubsystem();
>>>>>>> 24490dc7e9e0f7f7b7376270e6972a6a4fc43ec6
>>>>>>> 63f040449d8492d38e8653d71a50b978d91c4b8e

  // Initializing OI object
  public static OI OI = new OI();

  // Initializing commands
  DriveCommand DriveCommand = new DriveCommand();
  CommandScheduler commandScheduler = CommandScheduler.getInstance();
  IntakeCommand IntakeCommand = new IntakeCommand();

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {}

  /**
   * This autonomous (along with the chooser code above) shows how to select between different
   * autonomous modes using the dashboard. The sendable chooser code works with the Java
   * SmartDashboard. If you prefer the LabVIEW Dashboard, remove all of the chooser code and
   * uncomment the getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to the switch structure
   * below with additional strings. If using the SendableChooser make sure to add them to the
   * chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    m_autoSelected = m_chooser.getSelected();
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    System.out.println("Auto selected: " + m_autoSelected);
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    switch (m_autoSelected) {
      case kCustomAuto:
        //commandScheduler.schedule(new AutoDriveCommand(15000));
        break;
      case kDefaultAuto:
      default:
        // Put default auto code here
        break;
    }
  }

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {}

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    // Start the CommandScheduler to schedule commands for each cycle
    commandScheduler.run();
    DriveCommand.schedule();
    System.out.println("Speed: " + Robot.OI.getSpeed());
    System.out.println("Left: " + Robot.OI.checkLeftTrigger());
    System.out.println("Right: " + Robot.OI.checkRightTrigger());
  }

  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {}

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {}

  /** This function is called once when test mode is enabled. */
  @Override
  public void testInit() {}

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}
}
