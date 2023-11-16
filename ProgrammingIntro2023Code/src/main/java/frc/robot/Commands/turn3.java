// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj.DriverStation;
import frc.robot.Constants;
import frc.robot.Constants.DriveConstants;
import frc.robot.subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class turn3 extends CommandBase {

  DriveSubsystem driveSubAuto;
  double angle;

  public turn3(DriveSubsystem dss, double x) {
    driveSubAuto = dss;
    angle = Math.toRadians(x);
    addRequirements(driveSubAuto);
  }

  /** Creates a new Auto2DriveCommand. */

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    driveSubAuto.setDestination(angle * DriveConstants.R, angle * DriveConstants.R);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    double pos = driveSubAuto.rightEncoder.getPosition();
    double dest = driveSubAuto.ref;

    return pos > dest - DriveConstants.margin && pos < dest + DriveConstants.margin;
  }
}
