// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.DriveSubsystem;

public class AutoVroomCommand extends CommandBase {
  /** Creates a new AutoVroomCommand. */

  DriveSubsystem vroom;
  double zoom;

  public AutoVroomCommand(DriveSubsystem lightning, double mcqueen) {
    // Use addRequirements() here to declare subsystem dependencies.
    vroom = lightning;
    zoom = mcqueen;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    vroom.sEtSeTwHERe(zoom);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
