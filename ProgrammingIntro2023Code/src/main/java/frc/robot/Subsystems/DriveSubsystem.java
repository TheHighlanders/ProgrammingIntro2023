// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMax.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {
    
    CANSparkMax left;
    SparkMaxPIDController leftPID;
    CANSparkMax right;
    SparkMaxPIDController rightPID;

    public DriveSubsystem() {
        left = new CANSparkMax(1, MotorType.kBrushless);
        right = new CANSparkMax(2, MotorType.kBrushless);
        
        leftPID = left.getPIDController();
        leftPID.setP(Constants.DriveConstants.kp);
        leftPID.setI(Constants.DriveConstants.ki);
        leftPID.setD(Constants.DriveConstants.kd);

        rightPID = right.getPIDController();
        rightPID.setP(Constants.DriveConstants.kp);
        rightPID.setI(Constants.DriveConstants.ki);
        rightPID.setD(Constants.DriveConstants.kd);
    }

    public void drive(double left, double right) {
        this.left.set(left);
        this.right.set(right);
    }

    public void stop() {
        left.set(0);
        right.set(0);
    }

    public void periodic() {
        return;
    }

    public void setDestination(double destination) {
        leftPID.setReference(-destination, ControlType.kPosition);
        rightPID.setReference(destination, ControlType.kPosition);
    }

}

