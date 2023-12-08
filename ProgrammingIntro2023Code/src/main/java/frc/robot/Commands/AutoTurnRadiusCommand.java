package frc.robot.Commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.DriveSubsystem;
import frc.robot.Constants.DriveConstants;

public class AutoTurnRadiusCommand extends CommandBase {
    
    DriveSubsystem driveSubAuto;
    double destination;
    double radius;

    public AutoTurnRadiusCommand(DriveSubsystem ds, double ang, double rad) {
        driveSubAuto = ds;
        destination = Math.toRadians(ang); // Positive is forward, negative is back
        radius = rad; // Positive is to the right, negative is to the left
        addRequirements(driveSubAuto);
    }

    @Override
    public void initialize() {
        driveSubAuto.setDestination(destination * (radius + DriveConstants.turnRadius), destination * (radius - DriveConstants.turnRadius));
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
