// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Constants.DriveConstants;
import frc.robot.Subsystems.DriveSubsystem;

public class AutoDriveCommand extends CommandBase {
  /** Creates a new AutoDriveCommand. */

  DriveSubsystem driveSubAuto;
  double destination;

  public AutoDriveCommand(DriveSubsystem dss, double x) {
    driveSubAuto = dss;
    destination = -x;
    addRequirements(driveSubAuto);
    /*
    
    .　　 。　　　　　 ඞ 。 . 　　 • 　　　　•
    
    　　ﾟ　　 PID was not An Impostor.　 。　.
    
    　　'　　　     Add in your addRequirements　 　　。
    
    　　ﾟ　　　.　　　. ,　　　　.　 .
    */
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    driveSubAuto.setDestination(destination);
    DriverStation.reportWarning("CMD", false);
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
