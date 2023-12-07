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
    SparkMaxPIDController leftPID;
    public RelativeEncoder leftEncoder;

    CANSparkMax right;
    SparkMaxPIDController rightPID;
    public RelativeEncoder rightEncoder;

    public double ref = 0;

    public DriveSubsystem() {
        left = new CANSparkMax(1, MotorType.kBrushless);

        leftPID = left.getPIDController();
        leftPID.setP(Constants.DriveConstants.kp);
        leftPID.setI(Constants.DriveConstants.ki);
        leftPID.setD(Constants.DriveConstants.kd);
        leftPID.setOutputRange(-0.25, 0.25);

        leftEncoder = left.getEncoder();
        leftEncoder.setPositionConversionFactor(DriveConstants.kTotalDriveRatio);
        leftEncoder.setPosition(0);

        right = new CANSparkMax(2, MotorType.kBrushless);
        
        rightPID = right.getPIDController();
        rightPID.setP(Constants.DriveConstants.kp);
        rightPID.setI(Constants.DriveConstants.ki);
        rightPID.setD(Constants.DriveConstants.kd);
        rightPID.setOutputRange(-0.25, 0.25);
        
        rightEncoder = right.getEncoder();
        rightEncoder.setPositionConversionFactor(DriveConstants.kTotalDriveRatio);
        rightEncoder.setPosition(0);
    }

    public void setSpeed(double speed) {
        leftPID.setOutputRange(-speed, speed);
        rightPID.setOutputRange(-speed, speed);
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
        DriverStation.reportWarning(leftEncoder.getPosition() + " " + ref, false);
    }

    public void zeroSensors() {
        leftEncoder.setPosition(0);
        rightEncoder.setPosition(0);
    }

    public void setDestination(double left, double right) {
        leftPID.setReference(left + leftEncoder.getPosition(), ControlType.kPosition);
        rightPID.setReference(-right + rightEncoder.getPosition(), ControlType.kPosition);
        
        ref = left + leftEncoder.getPosition();
        // I believe this is error? Or amount to go?
    }

}

