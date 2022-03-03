// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

/*-------------------------------------------------------------------------
Author: Clarrie Wang                                     Date: Jan 22 2022
OI: operator interface - maps commands to controls on Xbox Controller.
---------------------------------------------------------------------------*/

package frc.robot;

import java.sql.Driver;

import edu.wpi.first.wpilibj.XboxController;

// import edu.wpi.first.wpilibj.GenericHID.Hand;

import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.DriverIntakeCommand;
import frc.robot.commands.IndexerCommand;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import frc.robot.commands.ToggleSolenoids;
import frc.robot.commands.DriveCommand;

import frc.robot.commands.IntakeCommand;
import frc.robot.commands.ToggleSolenoids;
import frc.robot.commands.launcher_commands.LauncherCommandGroup;
import frc.robot.subsystems.IntakeSubsystem;

public class OI {

    public XboxController driver;
    public JoystickButton AButton;
    // public JoystickButton XButton;
    public JoystickButton BButton;

    // Driver, initialized with port 0
    public XboxController Driver = new XboxController(0);

    // Driver, initialized with port 1
    public XboxController Operator = new XboxController(1);
  
    // Driver Buttons
    public JoystickButton DriverAButton;
    public JoystickButton DriverBButton;
    public JoystickButton DriverXButton;
    public JoystickButton DriverYButton;

    // Driver Triggers
    public JoystickButton DriverLeftTrigger;
   // public JoystickButton DriverRightTrigger;

    // Operator Individual Controller Devices
    public JoystickButton OperatorAButton;
    public JoystickButton OperatorBButton;
    public JoystickButton OperatorXButton;
    public JoystickButton OperatorYButton;

    public JoystickButton OperatorLeftTrigger;
    public JoystickButton OperatorRightTrigger;

    // Maps an initializes controls to the correct ports on the Xbox controller.
    public OI() {

        driver = new XboxController(1);
        BButton = new JoystickButton(driver, 3);
        BButton.whenPressed(new IndexerCommand());

        AButton = new JoystickButton(driver, 1);
        AButton.whenPressed(new ToggleSolenoids());
        
        BButton = new JoystickButton(driver, 2);
        BButton.whenPressed(new IntakeCommand());
    }

    // method that takes speed to go forwards or backwards from bumpers of controller depending on how hard driver presses
    public double getSpeed() {
        return driver.getLeftTriggerAxis() - driver.getRightTriggerAxis();

        // Inititalize the Driver Controls
        DriverAButton = new JoystickButton(Driver, 1);
        DriverBButton = new JoystickButton(Driver, 2);
        DriverXButton = new JoystickButton(Driver, 3);
        DriverYButton = new JoystickButton(Driver, 4);

        // Inititalize the Operator Controls
        OperatorAButton = new JoystickButton(Operator, 1);
        OperatorBButton = new JoystickButton(Operator, 2);
        OperatorXButton = new JoystickButton(Operator, 3);
        OperatorYButton = new JoystickButton(Operator, 4);

        DriverLeftTrigger = new JoystickButton(Driver, 5);
     //  DriverRightTrigger = new JoystickButton(Driver, 6);

        OperatorLeftTrigger = new JoystickButton(Operator, 5);
        OperatorRightTrigger = new JoystickButton(Operator, 6);

        // Driver Intake
        DriverLeftTrigger.whileHeld(new DriverIntakeCommand());
        
        // Intake
        DriverBButton.whenPressed(new IntakeCommand());

        //Indexer
        DriverXButton.whenPressed(new IndexerCommand());

        //Launcher
        DriverYButton.whenPressed(new LauncherCommandGroup());

        //Toggle Solenoids
        DriverAButton.whenPressed(new ToggleSolenoids());
    }

    // This double (decimal number) method returns the difference between the left and right Driver triggers (How much to move forwards/backwards)
    public double getDriverSpeed () {

        if (Math.abs(Driver.getRightTriggerAxis() - Driver.getLeftTriggerAxis()) > 0.15) {
            return Driver.getRightTriggerAxis() - Driver.getLeftTriggerAxis();
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

    public double getDriverIntake () {
        return Driver.getRawAxis(5);
    }
}