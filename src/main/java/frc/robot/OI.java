// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

/*-------------------------------------------------------------------------
Author: Clarrie Wang                                     Date: Jan 22 2022
OI: operator interface - maps commands to controls on Xbox Controller.
CURRENTCODEONBOT
---------------------------------------------------------------------------*/

package frc.robot;

import java.sql.Driver;

import edu.wpi.first.wpilibj.XboxController;

// import edu.wpi.first.wpilibj.GenericHID.Hand;

import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.IndexerCommand;
import frc.robot.commands.ToggleSolenoids;
import frc.robot.commands.auto.base_auto_commands.AutoLaunchCommand;
import frc.robot.commands.auto.command_groups.AutoLaunchFeedParallel;

//import com.revrobotics.ColorSensorV3;

import frc.robot.commands.IntakeCommand;
//import frc.robot.commands.ToggleMirrorSolenoid;
import frc.robot.commands.launcher_commands.LauncherCommand;
import frc.robot.commands.launcher_commands.FeederCommand;
import frc.robot.commands.climber.ClimbTestingForward;
import frc.robot.commands.climber.ClimbTestingReverse;
import frc.robot.commands.climber.ReleaseClimberCommand;


//import frc.robot.commands.ClimbTestingForward;
//import frc.robot.commands.ClimbTestingReverse;

public class OI {
    // Driver, initialized with port 0
    public XboxController Driver;

    // Driver, initialized with port 1
    public XboxController Operator;
  
    // Driver Buttons
    public JoystickButton DriverAButton;
    public JoystickButton DriverBButton;
    public JoystickButton DriverXButton;
    public JoystickButton DriverYButton;

    // Driver Triggers
    public JoystickButton DriverLeftBumper;
    public JoystickButton DriverRightBumper;

    // Operator Individual Controller Devices
    public JoystickButton OperatorAButton;
    public JoystickButton OperatorBButton;
    public JoystickButton OperatorXButton;
    public JoystickButton OperatorYButton;

    public JoystickButton OperatorLeftBumper;
    public JoystickButton OperatorRightBumper;

    // Maps an initializes controls to the correct ports on the Xbox controller.
    public OI() {
        Driver = new XboxController(0);

        DriverLeftBumper = new JoystickButton(Driver, 5);
        DriverLeftBumper.whileHeld(new ClimbTestingForward());

        DriverRightBumper = new JoystickButton(Driver, 6);
        DriverRightBumper.whileHeld(new ClimbTestingReverse());

        DriverAButton = new JoystickButton(Driver, 1);
        //DriverAButton.whenPressed(new ToggleSolenoids());
        
        DriverBButton = new JoystickButton(Driver, 2);
        //DriverBButton.whileHeld(new ClimbTestingReverse());
        
        DriverXButton = new JoystickButton(Driver, 3);
        DriverXButton.whenPressed(new ReleaseClimberCommand());
        
        DriverYButton = new JoystickButton(Driver, 4);
        //DriverYButton.whenPressed(new ToggleMirrorSolenoid());
        
        Operator = new XboxController(1);

        // Inititalize the Operator Controls
        OperatorAButton = new JoystickButton(Operator, 1);
        
        OperatorBButton = new JoystickButton(Operator, 2);
        OperatorBButton.whileHeld(new IntakeCommand());
        //OperatorBButton.whileHeld(new ClimbTestingForward());

        OperatorXButton = new JoystickButton(Operator, 3);
        OperatorXButton.whenPressed(new AutoLaunchFeedParallel());
        //OperatorXButton.whileHeld(new ClimbTestingReverse());
        // we need to document our code better
        OperatorYButton = new JoystickButton(Operator, 4);
        OperatorYButton.whileHeld(new IndexerCommand());

        OperatorRightBumper = new JoystickButton(Operator, 6);
        OperatorRightBumper.whenPressed(new ToggleSolenoids());
        
        if (Math.abs(Operator.getRightTriggerAxis()) > 0) {
            new ToggleSolenoids();
        }
    }

    // method that takes speed to go forwards or backwards from bumpers of controller depending on how hard driver presses
    // This double (decimal number) method returns the difference between the left and right Driver triggers (How much to move forwards/backwards)
    public double getDriverSpeed () {

        if (Math.abs(Driver.getRightTriggerAxis() - Driver.getLeftTriggerAxis()) > 0.15) {
            return (Driver.getRightTriggerAxis() - Driver.getLeftTriggerAxis()) * 0.7;//maybe-0.5hereONLYiftested
        }

        return 0.0;

    }
    
    // This double method returns the x-axis of the Driver top/turn joystick. The value returned would determine how much to turn to the left or right
    public double getDriverTurn () {

        if (Math.abs(Driver.getRawAxis(0)) > 0.15) {
            return Driver.getRawAxis(0);
        }

        return 0.0;

    }

    public double getDriverIntake() {
        if (Math.abs(Driver.getRawAxis(0)) > 0.15) {
            return Driver.getRawAxis(0);
        }

        return 0.0;
    }

    public double getOperatorLauncher() {
        if (Math.abs(Operator.getRawAxis(0)) > 0.15) {
            return Operator.getRawAxis(0);
        }

        return 0.0;
    }

}