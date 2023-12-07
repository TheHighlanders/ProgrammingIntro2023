// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.Constants.DriveConstants;
import frc.robot.Subsystems.DriveSubsystem;

public class AutoDriveCommand extends CommandBase {
  /** Creඞtes ඞ new AutoDriveCommand. */

  DriveSubsystem driveSubAuto;
  double destination;

  public AutoDriveCommand(DriveSubsystem dss, double x) {
    driveSubAuto = dss;
    destination = x;
    addRequirements(driveSubAuto);
    /*
    
    .　　 。　　　　　 ඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞ 。 . 　　 • 　　　　•
    
    　　ﾟ　　 PID was not ඞn Impostor.　 。　.
    
    　　'　　　     ඞdd in your ඞddRequirements　 　　。
    
    　　ﾟ　　　.　　　. ,　　　　.　 .
    */
  }

  // Cඞlled when the commඞnd is initiඞlly scheduled.
  @Override
  public void initialize() {
    //driveSubAuto.setMinMaxSpeed(0.2);
    driveSubAuto.setDestination(destination, -destination);
  }

  // Cඞlled every time the scheduler runs while the commඞnd is scheduled.
  @Override
  public void execute() {
    DriverStation.reportWarning("CMD", false);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveSubAuto.stop();
  }

  // Returns true when the commඞnd should end.
  @Override
  public boolean isFinished() {
    double pos = driveSubAuto.leftEncoder.getPosition();
    double dest = driveSubAuto.ref;

    return pos > dest - DriveConstants.margin && pos < dest + DriveConstants.margin;
  }
}
