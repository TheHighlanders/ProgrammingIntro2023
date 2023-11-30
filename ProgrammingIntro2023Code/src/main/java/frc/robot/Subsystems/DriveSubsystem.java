// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMax.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.DriveConstants;

public class DriveSubsystem extends SubsystemBase {

  CANSparkMax left;
  CANSparkMax right;
  SparkMaxPIDController leftPID;
  SparkMaxPIDController rightPID;

public double ref = 0;

public RelativeEncoder leftEncoder;
public RelativeEncoder rightEncoder;


 
  /** Creates a new DriveSubsystem. */
  public DriveSubsystem() {

    left = new CANSparkMax(6, MotorType.kBrushless);
    right = new CANSparkMax(3, MotorType.kBrushless);
    leftPID = left.getPIDController();
    rightPID = right.getPIDController();

    leftPID.setP(Constants.DriveConstants.kp);
    rightPID.setP(Constants.DriveConstants.kp);

    leftPID.setP(Constants.DriveConstants.ki);
    rightPID.setP(Constants.DriveConstants.ki);

    leftPID.setP(Constants.DriveConstants.kd);
    rightPID.setP(Constants.DriveConstants.kd);

    leftEncoder= left.getEncoder();
    rightEncoder= right.getEncoder();

    leftEncoder.setPositionConversionFactor(DriveConstants.kTotalDriveRatio);
    rightEncoder.setPositionConversionFactor(DriveConstants.kTotalDriveRatio);

    leftPID.setOutputRange(-.1, .1);
    rightPID.setOutputRange(-.1,.1);
  }

  public void sEtSeTwHERe(double x) {
    leftPID.setReference(x + leftEncoder.getPosition(), ControlType.kPosition);
    rightPID.setReference(-x + rightEncoder.getPosition(), ControlType.kPosition);
  }

  public void drive(double left, double right) {

    this.left.set(left);
    this.right.set(right);
  }

  public void stop() {

    left.set(0);
    right.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    DriverStation.reportWarning(leftEncoder.getPosition() + " " + ref, false);

  }

  public void setDestination(double x, double y){
    leftPID.setReference(x, ControlType.kPosition);
    rightPID.setReference(y, ControlType.kPosition);
    ref = x;
  }
}
