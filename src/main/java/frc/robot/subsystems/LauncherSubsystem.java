package frc.robot.subsystems;

import frc.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

public class LauncherSubsystem {
    TalonFX Launcher1 = new TalonFX(RobotMap.Launcher1);
    TalonFX Launcher2 = new TalonFX(RobotMap.Launcher2);
}
