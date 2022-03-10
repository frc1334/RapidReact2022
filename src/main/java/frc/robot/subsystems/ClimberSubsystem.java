// package frc.robot.subsystems;

// import frc.robot.RobotMap;
// import com.revrobotics.CANSparkMax;
// import com.revrobotics.CANSparkMaxLowLevel.MotorType;
// import com.ctre.phoenix.motorcontrol.NeutralMode;
// import com.revrobotics.RelativeEncoder;

// //unused imports
// // import com.ctre.phoenix.motion.MotionProfileStatus;
// // import com.ctre.phoenix.motorcontrol.ControlMode;
// // import com.ctre.phoenix.motorcontrol.FeedbackDevice;


// import edu.wpi.first.wpilibj2.command.SubsystemBase;

// public class ClimberSubsystem extends SubsystemBase{
//     CANSparkMax LeftClimbMotor = new CANSparkMax(RobotMap.LeftClimbMotor, MotorType.kBrushless);
//     CANSparkMax RightClimbMotor = new CANSparkMax(RobotMap.RightClimbMotor, MotorType.kBrushless);
//     // RelativeEncoder C1encoder = LeftClimbMotor.getEncoder();
//     // RelativeEncoder C2encoder = RightClimbMotor.getEncoder();
//     RelativeEncoder m_encoder;
//         /**
//      * The RestoreFactoryDefaults method can be used to reset the configuration parameters
//      * in the SPARK MAX to their factory default state. If no argument is passed, these
//      * parameters will not persist between power cycles
//      */
//     LeftClimbMotor.restoreFactoryDefaults();

//     /**
//     * In order to read encoder values an encoder object is created using the 
//     * getEncoder() method from an existing CANSparkMax object
//     */
    
// //public void whenPressed(ClimberRelease)    
//     public void ClimberRelease(CANSparkMax leftClimbMotor, CANSparkMax rightClimbMotor) {
        
//         C1encoder.setPosition(0);
//         C2encoder.setPosition(0);
//         //RightClimbMotor.set(ControlMode.Follower, RobotMap.LeftClimbMotor);
        
//         //set motors to neutral so spring can expand (coast)
//         LeftClimbMotor.setMotorType(MotorType.kBrushed);
//         RightClimbMotor.setNeutralMode(NeutralMode.Coast);

//         boolean Latching = true;

//         while (Latching) {
        
//         //check encoder value to make sure it doesn't go too far
//         // double MotorPos = LeftClimbMotor.getSelectedSensorPosition();
//         m_encoder = LeftClimbMotor.getEncoder();
//         double MotorPos = m_encoder.getPosition();
//         //stop motors once they reach target distance (or set them to hold position)
//         //4096 encoder counts in a single revoloution of CANSpark    
//         if (m_encoder > 180) {
//                 Latching = false;
//                 // LeftClimbMotor.setNeutralMode(NeutralMode.Brake);
//                 // RightClimbMotor.setNeutralMode(NeutralMode.Brake);
//             }
//         }
        
        
//     }
// 	public ClimberSubsystem(RelativeEncoder m_encoder) {
// 		this.m_encoder = m_encoder;
// 	} 


// }
