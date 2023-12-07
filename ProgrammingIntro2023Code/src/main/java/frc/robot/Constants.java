// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    
  }

  public static class DriveConstants {
    //Telling code about physicak properties of robot
    public static final double kDriveGBRatio = 1 / 10.71;
    public static final double kWheelCircumfrence = 6 * Math.PI;
    public static final double kTotalDriveRatio = kDriveGBRatio * kWheelCircumfrence;
    //Magic!
    public static double kp = 1;
    public static double ki = 0;
    public static double kd = 0;

    public static double margin = 0.5;
    public static double turnRadius = 11;
  }
}
