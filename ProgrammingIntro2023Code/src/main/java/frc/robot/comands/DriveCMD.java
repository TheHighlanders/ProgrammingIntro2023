// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.comands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class DriveCMD extends CommandBase {
  /** Creates a new DriveCMD. */

  DoubleSupplier xAxis;
  DoubleSupplier yAxis;

  DriveSubsystem drivesub;

  public DriveCMD(DriveSubsystem drivedub, DoubleSupplier y, DoubleSupplier x) {
    // Use addRequirements() here to declare subsystem dependencies.

    drivesub = drivedub;

    yAxis = y;
    xAxis = x;

    addRequirements(drivesub);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double left = yAxis.getAsDouble() - xAxis.getAsDouble();
    double right = yAxis.getAsDouble() + xAxis.getAsDouble();
    drivesub.drive(left, right);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivesub.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
