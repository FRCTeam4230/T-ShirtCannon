package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrainSubsystem;

import java.util.function.DoubleSupplier;


public class DriveCommand extends CommandBase {
    private DriveTrainSubsystem driveTrain;
    private DoubleSupplier speedSupplier, turnSupplier;

    public DriveCommand(DoubleSupplier speedSupplier, DoubleSupplier turnSupplier, DriveTrainSubsystem driveTrain) {
        this.speedSupplier = speedSupplier;
        this.turnSupplier = turnSupplier;
        this.driveTrain = driveTrain;
        addRequirements(driveTrain);

    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        double speed = speedSupplier.getAsDouble();
        double turn = turnSupplier.getAsDouble();
        speed *= Constants.Multipliers.speedMultiplier;
        turn *= Constants.Multipliers.turnMultiplier;
        driveTrain.arcadeDrive(speed, turn);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {

    }
}
