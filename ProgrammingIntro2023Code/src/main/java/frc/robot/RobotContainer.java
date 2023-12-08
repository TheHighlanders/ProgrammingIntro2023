// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Commands.AutoDriveCommand;
import frc.robot.Commands.AutoTurnCommand;
import frc.robot.Commands.AutoTurnRadiusCommand;
import frc.robot.Commands.TeleopDriveCMD;
import frc.robot.Subsystems.DriveSubsystem;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here
  DriveSubsystem driveSubsystem = new DriveSubsystem();
  XboxController xbox = new XboxController(0);
  TeleopDriveCMD driveCMD = new TeleopDriveCMD(driveSubsystem, ()->xbox.getLeftX(), ()->xbox.getLeftY()); 
  AutoDriveCommand autoDrive10ft = new AutoDriveCommand(driveSubsystem, 120);
  //AutoTurnWhatever

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    driveSubsystem.setDefaultCommand(driveCMD);
    // Configure the trigger bindings
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return new SequentialCommandGroup(
      new AutoDriveCommand(driveSubsystem, 60), 
      new AutoTurnCommand(driveSubsystem, 90),
      new AutoTurnRadiusCommand(driveSubsystem, 90, 30),
      new AutoDriveCommand(driveSubsystem, 19),
      new AutoTurnRadiusCommand(driveSubsystem, 90, 11),
      new AutoDriveCommand(driveSubsystem, 30),
      new AutoTurnCommand(driveSubsystem, 90)
      //Makes a filleted square to the forward and left
    );
  }
}
