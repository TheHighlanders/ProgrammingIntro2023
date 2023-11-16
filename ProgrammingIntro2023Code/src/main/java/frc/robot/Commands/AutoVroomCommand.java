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

<<<<<<< Updated upstream:ProgrammingIntro2023Code/src/main/java/frc/robot/Commands/AutoVroomCommand.java
  public AutoVroomCommand(DriveSubsystem lightning, double mcqueen) {
    // Use addRequirements() here to declare subsystem dependencies.
    vroom = lightning;
    zoom = mcqueen;
=======
  public AutoDriveCommand(DriveSubsystem dss, double x) {
    driveSubAuto = dss;
    destination = x;
>>>>>>> Stashed changes:ProgrammingIntro2023Code/src/main/java/frc/robot/Commands/AutoDriveCommand.java
  }

  // Called when the command is initially scheduled.
  @Override
<<<<<<< Updated upstream:ProgrammingIntro2023Code/src/main/java/frc/robot/Commands/AutoVroomCommand.java
  public void initialize() {
    vroom.sEtSeTwHERe(zoom);
  }
=======
  public void initialize() {}
>>>>>>> Stashed changes:ProgrammingIntro2023Code/src/main/java/frc/robot/Commands/AutoDriveCommand.java

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
<<<<<<< Updated upstream:ProgrammingIntro2023Code/src/main/java/frc/robot/Commands/AutoVroomCommand.java
=======
    driveSubAuto.setDestination(destination, -destination);
    DriverStation.reportWarning("CMD", false);
>>>>>>> Stashed changes:ProgrammingIntro2023Code/src/main/java/frc/robot/Commands/AutoDriveCommand.java
  }

  // Called once the command ends or is interrupted.
  @Override
<<<<<<< Updated upstream:ProgrammingIntro2023Code/src/main/java/frc/robot/Commands/AutoVroomCommand.java
  public void end(boolean interrupted) {

  }
=======
  public void end(boolean interrupted) {}
>>>>>>> Stashed changes:ProgrammingIntro2023Code/src/main/java/frc/robot/Commands/AutoDriveCommand.java

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
<<<<<<< Updated upstream:ProgrammingIntro2023Code/src/main/java/frc/robot/Commands/AutoVroomCommand.java
    return true;
=======
    double pause = driveSubAuto.rightEncoder.getPosition();
    double target = driveSubAuto.ref;

    return (pause > target - 1 && pause < target + 1);
>>>>>>> Stashed changes:ProgrammingIntro2023Code/src/main/java/frc/robot/Commands/AutoDriveCommand.java
  }
}
