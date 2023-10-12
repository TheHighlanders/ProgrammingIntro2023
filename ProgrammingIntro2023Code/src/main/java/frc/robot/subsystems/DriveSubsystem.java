// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {
  CANSparkMax left;
  CANSparkMax right;
  /** Creates a new DriveSubsystem. */
  public DriveSubsystem() {
left = new CANSparkMax(1,MotorType.kBrushless);
//we have a left moror thats id is 1 and its brushless


right = new CANSparkMax(2,MotorType.kBrushless);
//we have a right moror thats id is 2 and its brushless

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void drive(double left, double right){
//what is happening?????????????????
this.left.set(left);

this.right.set(right);

  }

public void stop(){
this.left.set(0);
this.right.set(0);
}
}
