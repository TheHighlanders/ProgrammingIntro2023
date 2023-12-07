package frc.robot.Commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.DriveSubsystem;
import frc.robot.Constants;

public class AutoDriveCommand extends CommandBase {
    
    DriveSubsystem driveSubAuto;
    double destination;

    public AutoDriveCommand(DriveSubsystem ds, double x) {
        driveSubAuto = ds;
        destination = x;
        addRequirements(driveSubAuto);
    }

    @Override
    public void initialize() {
        driveSubAuto.setDestination(destination);
    }

    @Override
    public void execute() {
        
        DriverStation.reportWarning("CMD", false);
    }

    @Override
    public void end(boolean interrupted) {
        driveSubAuto.stop();
    }

    @Override
    public boolean isFinished() {
        double pos = driveSubAuto.leftEncoder.getPosition();
        double dest = driveSubAuto.ref;

        return Math.abs(pos - dest) > DriveConstants.margin;
        // pos > dest - DriveConstants.margin && pos < dest + DriveConstants.margin;
    }
}
