package frc.robot.subsystems;

import frc.robot.RobotMap;
// import com.revrobotics.CANSparkMax;
// import com.revrobotics.CANSparkMaxLowLevel.MotorType;
// import com.revrobotics.RelativeEncoder;
// import com.revrobotics.CANSparkMax.IdleMode;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motion.MotionProfileStatus;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import edu.wpi.first.wpilibj.DigitalInput;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SRXClimberSubsystem extends SubsystemBase{
//     CANSparkMax ClimbMotor = new CANSparkMax(RobotMap.ClimbMotor, MotorType.kBrushless);
// //    CANSparkMax RightClimbMotor = new CANSparkMax(RobotMap.RightClimbMotor, MotorType.kBrushless);
//     // RelativeEncoder C1encoder = LeftClimbMotor.getEncoder();
//     // RelativeEncoder C2encoder = RightClimbMotor.getEncoder();
//     RelativeEncoder Climb_encoder;
    //RelativeEncoder Right_encoder;
        /**
     * The RestoreFactoryDefaults method can be used to reset the configuration parameters
     * in the SPARK MAX to their factory default state. If no argument is passed, these
     * parameters will not persist between power cycles
     */
    // LeftClimbMotor.restoreFactoryDefaults();

    /**
    * In order to read encoder values an encoder object is created using the 
    * getEncoder() method from an existing CANSparkMax object
    */
    TalonSRX climbMotor;
    DigitalInput lowerSwitch;
    //DigitalInput upperSwitch;
    boolean isClimbing;

    public SRXClimberSubsystem() {
        //CANSparkMax ClimbMotor = new CANSparkMax(RobotMap.LeftClimbMotor, MotorType.kBrushless);
        //RelativeEncoder Climb_encoder;
        //ClimbMotor.setIdleMode(IdleMode.kCoast);
        //Climb_encoder = ClimbMotor.getEncoder();
        climbMotor = new TalonSRX(RobotMap.climbMotor);
        climbMotor.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
    
        climbMotor.configPeakOutputForward(0.0);
        climbMotor.configPeakOutputReverse(-1.0);

        lowerSwitch = new DigitalInput(0);
        //upperSwitch = new DigitalInput(1);

        climbMotor.setNeutralMode(NeutralMode.Brake);

        isClimbing = false;
    }    
    
//public void whenPressed(ClimberRelease)    
    public void climberRelease() {
        // C1encoder.setPosition(0);
        // C2encoder.setPosition(0);
        //RightClimbMotor.set(ControlMode.Follower, RobotMap.LeftClimbMotor);
        
        //set motors to neutral so spring can expand (coast)
        // RightClimbMotor.setNeutralMode(NeutralMode.Coast);
        //RightClimbMotor.setIdleMode(IdleMode.kCoast);
        //ClimbMotor.setIdleMode(IdleMode.kCoast);
        //Climb_encoder = ClimbMotor.getEncoder();
        //Right_encoder = RightClimbMotor.getEncoder();

        //boolean Latching = true;

        // while (Latching) {
        
        // //check encoder value to make sure it doesn't go too far
        // // double MotorPos = LeftClimbMotor.getSelectedSensorPosition();
        // // double MotorPos = m_encoder.getPosition();

        // //stop motors once they reach target distance (or set them to hold position)
        // //4096 encoder counts in a single revoloution of CANSpark    
        // if (Left_encoder.getPosition() >= 2048) {
        //         Latching = false;
        //         // LeftClimbMotor.setNeutralMode(NeutralMode.Brake);
        //         // RightClimbMotor.setNeutralMode(NeutralMode.Brake);
        //         //RightClimbMotor.setIdleMode(IdleMode.kBrake);
        //         ClimbMotor.setIdleMode(IdleMode.kBrake);
        //     }
        // }
        
        climbMotor.setNeutralMode(NeutralMode.Coast);
    }

    public void pullUpRobot() {
        isClimbing = true;
        climbMotor.set(ControlMode.PercentOutput, 1.0);
        
        while (isClimbing) {
        if (lowerSwitch.get()) {
                isClimbing = false;
                // LeftClimbMotor.setNeutralMode(NeutralMode.Brake);
                // RightClimbMotor.setNeutralMode(NeutralMode.Brake);
                //RightClimbMotor.setIdleMode(IdleMode.kBrake);
                climbMotor.set(ControlMode.PercentOutput, 0.0);
                climbMotor.setNeutralMode(NeutralMode.Brake);
            }
        }
    }

}
