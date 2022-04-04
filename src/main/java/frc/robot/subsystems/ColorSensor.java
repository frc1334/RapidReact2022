// // Copyright (c) FIRST and other WPILib contributors.
// // Open Source Software; you can modify and/or share it under the terms of
// // the WPILib BSD license file in the root directory of this project.

// package frc.robot.subsystems;

// import edu.wpi.first.wpilibj2.command.SubsystemBase;

// import edu.wpi.first.wpilibj.I2C;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
// import edu.wpi.first.wpilibj.util.Color;

// import com.revrobotics.ColorSensorV3;
// import com.revrobotics.ColorMatchResult;
// import com.revrobotics.ColorMatch;

// public class ColorSensor extends SubsystemBase {
//   String colorString;
//   // Construct a color sensor object
//   final I2C.Port i2cPort = I2C.Port.kOnboard;
//   final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);

//   // Color match
//   ColorMatch m_colorMatcher = new ColorMatch();

//   // Set up RGB values of the target colors
//   private final Color kBlueTarget = new Color(0.143, 0.427, 0.429);
//   private final Color kRedTarget = new Color(0.561, 0.232, 0.114);

//   String whatColor;

//   public String colorMatch() {
//     m_colorMatcher.addColorMatch(kBlueTarget);
//     m_colorMatcher.addColorMatch(kRedTarget);

//     // Returns a color value from the sensor
//     Color detectedColor = m_colorSensor.getColor();
//     // Returns a raw IR value of the infrared detected
//     double IR = m_colorSensor.getIR();

//     // Display the color detected by the sensor on Smart Dashboard
//     SmartDashboard.putNumber("Red", detectedColor.red);
//     SmartDashboard.putNumber("Blue", detectedColor.blue);
//     SmartDashboard.putNumber("IR", IR);

//     // Get the approximate distance of the object
//     int proximity = m_colorSensor.getProximity();

//     SmartDashboard.putNumber("Proximity", proximity);

//     // Determine if the object is close enough to provide the accurate color values
//     boolean validDistance = false;

//     if (proximity > 0) {
//       validDistance = true;
//     }
    
//     while (validDistance) {
//       // Run the color match on our detected color
      
//       ColorMatchResult match = m_colorMatcher.matchClosestColor(detectedColor);

//       if (match.color == kBlueTarget) {
//         colorString = "Blue";
//       } else if (match.color == kRedTarget) {
//         colorString = "Red";
//       } else {
//         colorString = "Unknown";
//       }
      
//     }
//     return colorString;
//   }
  
// }

