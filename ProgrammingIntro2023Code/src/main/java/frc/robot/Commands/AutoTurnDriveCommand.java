// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj.DriverStation;
import frc.robot.Constants;
import frc.robot.Constants.DriveConstants;
import frc.robot.Subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class AutoTurnDriveCommand extends CommandBase {

  DriveSubsystem driveSubAuto;
  double angle;

  public AutoTurnDriveCommand(DriveSubsystem dss, double x) {
    driveSubAuto = dss;
    angle = Math.toRadians(x);
    addRequirements(driveSubAuto);
  }

  /** Creates a new Auto2DriveCommand. */

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //driveSubAuto.setMinMaxSpeed(0.05);
    driveSubAuto.setDestination(angle * DriveConstants.turnRadius, angle * DriveConstants.turnRadius);
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveSubAuto.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    double pos = driveSubAuto.leftEncoder.getPosition();
    double dest = driveSubAuto.ref;

    return pos > dest - DriveConstants.margin && pos < dest + DriveConstants.margin;
  }
}
