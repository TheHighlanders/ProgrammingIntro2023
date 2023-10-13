// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
// but probably without this cool comment
package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class DriveSubsystem extends SubsystemBase {
  CANSparkMax left;
  CANSparkMax right;
  /** Creates a new DriveSubsystem. */
  public DriveSubsystem() {
    left = new CANSparkMax(DriveConstants.leftDriveID,MotorType.kBrushless);
    right = new CANSparkMax(DriveConstants.rightDriveID,MotorType.kBrushless);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void drive(double left, double right){
    this.left.set(left);
    this.right.set(right);
  }
  public void stop(){
    this.left.set(0);
    this.right.set(0);
  }
}
