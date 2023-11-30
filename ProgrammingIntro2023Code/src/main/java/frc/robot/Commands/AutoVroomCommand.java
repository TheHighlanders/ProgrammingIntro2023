// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.DriveSubsystem;

public class AutoVroomCommand extends CommandBase {
  /** Creates a new AutoVroomCommand. */

  DriveSubsystem driveSubAuto;
  double destination;

  public AutoVroomCommand(DriveSubsystem dss, double x) {
    driveSubAuto = dss;
    destination = x;
    addRequirements(driveSubAuto);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    driveSubAuto.setDestination(destination, -destination);
    DriverStation.reportWarning("CMD", false);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    double pause = driveSubAuto.rightEncoder.getPosition();
    double target = driveSubAuto.ref;

    return (pause > target - 1 && pause < target + 1);
  }
}
