// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Constants.DriveConstants;
import frc.robot.Subsystems.DriveSubsystem;


public class AutoooooooTuuuuurnnn extends CommandBase {
  /** Creates a new Autoooooooooo. */
  DriveSubsystem driveAutoTurn;
  double desk;

  public AutoooooooTuuuuurnnn(DriveSubsystem dss, double x) {
    // Use addRequirements() here to declare subsystem dependencies.
    driveAutoTurn = dss;
    desk = Math.toRadians(x);
    addRequirements(driveAutoTurn);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    driveAutoTurn.setDestination(desk * DriveConstants.radius, desk);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    double pause = driveAutoTurn.rightEncoder.getPosition();
    double target = driveAutoTurn.ref;

    return (pause > target - 1 && pause < target + 1);
  }
}
