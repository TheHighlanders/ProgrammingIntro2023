// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystems extends SubsystemBase {
    
    CANSparkMax left;
    CANSparkMax right;

    public void DriveSubsystems() {
        left = new CANSparkMax(0, MotorType.kBrushless);
        right = new CANSparkMax(0, MotorType.kBrushless);
    }

    public void drive(int left, int right) {
        this.left.set(left);
        this.right.set(right);
    }

    public void stop(){
        left.set(0);
        right.set(0);
    }

    public void periodic {

    }

}
