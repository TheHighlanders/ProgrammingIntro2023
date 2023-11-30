// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.DriveSubsystem;

public class TeleopDriveCMD extends CommandBase {
  /** Creates a new TeleopDriveCMD. */
  DriveSubsystem driveSubsystem;
  DoubleSupplier xAxis;
  DoubleSupplier yAxis;

  public TeleopDriveCMD(DriveSubsystem ds, DoubleSupplier x, DoubleSupplier y) {
    driveSubsystem = ds;
    xAxis = x;
    yAxis = y;

    addRequirements((driveSubsystem));
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double left = yAxis.getAsDouble() - xAxis.getAsDouble();
    double right = yAxis.getAsDouble() + xAxis.getAsDouble();
    driveSubsystem.drive(left, right);
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
