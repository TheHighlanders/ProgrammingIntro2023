// copyright open source whatever see the other docs idc

package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.DriveSubsystem;
import java.util.function.DoubleSupplier;

public class TeleopDriveCMD extends CommandBase {
    
    DriveSubsystem driveSubsystem;
    DoubleSupplier xAxis;
    DoubleSupplier yAxis;

    public TeleopDriveCMD(DriveSubsystem ds, DoubleSupplier x, DoubleSupplier y) {
        driveSubsystem = ds;
        xAxis = x;
        yAxis = y;
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {
        double left = yAxis.getAsDouble() - xAxis.getAsDouble();
        double right =  yAxis.getAsDouble() + xAxis.getAsDouble();
        driveSubsystem.drive(left, right);
    }

    @Override
    public void end(boolean interrupted) {
        driveSubsystem.stop();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
