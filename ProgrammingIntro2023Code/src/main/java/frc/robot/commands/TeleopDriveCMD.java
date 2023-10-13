// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class TeleopDriveCMD extends CommandBase {
  DoubleSupplier left;
  DoubleSupplier right;
  DriveSubsystem driveSubsystem;
  /** Creates a new TeleopDriveCMD. */
  public TeleopDriveCMD(DoubleSupplier left, DoubleSupplier right, DriveSubsystem drive_subsystem) {
    this.left = left;
    this.right = right;
    this.driveSubsystem = drive_subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double leftStick = left.getAsDouble();
    double rightStick = right.getAsDouble();

    double leftSpeed = leftStick + rightStick;
    double rightSpeed = leftStick - rightStick;

    driveSubsystem.drive(leftSpeed, rightSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveSubsystem.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
