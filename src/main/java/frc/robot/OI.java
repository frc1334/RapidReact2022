// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

/*-------------------------------------------------------------------------

Author: Clarrie Wang                                     Date: Jan 22 2022

OI: operator interface - maps commands to controls on Xbox Controller.

---------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import frc.robot.commands.ToggleSolenoids;

public class OI {
    public XboxController driver;
    public JoystickButton AButton;
    // public JoystickButton BButton;
    // public JoystickButton XButton;
    
    // constructor intializing the Xbox Controller objects for driver and operator in ports 0 and 1 respectively
    public OI() {
        driver = new XboxController(1);
        AButton = new JoystickButton(driver, 1);
        AButton.whenPressed(new ToggleSolenoids());
    }

    // method that takes speed to go forwards or backwards from bumpers of controller depending on how hard driver presses
    public double getSpeed() {
        return driver.getLeftTriggerAxis() - driver.getRightTriggerAxis();
    }

    public double checkLeftTrigger() {
        return driver.getLeftTriggerAxis();
    }

    public double checkRightTrigger() {
        return driver.getRightTriggerAxis();
    }

    // method that allows for joystick control to determine turns to left/right
    public double getTurn() {
       return driver.getRawAxis(0);
    }
}
