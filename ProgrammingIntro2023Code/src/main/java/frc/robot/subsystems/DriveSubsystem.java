// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import javax.security.auth.RefreshFailedException;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class DriveSubsystem extends SubsystemBase {

  PIDController drivController; 
  //potatopotatopotatopotatopotatopotatopotatopotatopotatopotatopotatopotatopotatopotatopotatopotatopotatopoatatopotatopotatopotatopotatopotatopotatopotatopotatopotatopotatopotatopotatopotatopotatopotatopotatopotatopotatopotatopotatopotatopotatopotatopotatopotatopotato



  CANSparkMax left;
  RelativeEncoder leftEncoder;
  CANSparkMax right;
  RelativeEncoder rightEncoder;


  /** Creates a new DriveSubsystem. */
  public DriveSubsystem() {

drivController = new PIDController(p, i, d)


    left = new CANSparkMax(6, MotorType.kBrushless);
    //we have a left moror thats id is 1 and its brushless
    leftEncoder = left.getEncoder();
    leftEncoder.setPositionConversionFactor(DriveConstants.kd); 
    leftEncoder.setPosition(0);

    right = new CANSparkMax(3, MotorType.kBrushless);
    //we have a right moror thats id is 2 and its brushless
    rightEncoder = right.getEncoder();
    rightEncoder.setPositionConversionFactor(DriveConstants.kd); 
    rightEncoder.setPosition(0);



  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void drive(double left, double right) {
    //what is happening?????????????????
    this.left.set(left);

    this.right.set(right);

  }

  public void stop() {
    this.left.set(0);
    this.right.set(0);
  }
}
