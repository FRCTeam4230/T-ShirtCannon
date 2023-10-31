package frc.robot.subsystems;


import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrainSubsystem extends SubsystemBase {
    private Spark frontLeft = new Spark(Constants.MotorPorts.FRONT_LEFT_MOTOR_PORT);
    private Spark frontRight = new Spark(Constants.MotorPorts.FRONT_RIGHT_MOTOR_PORT);
    private Spark backLeft = new Spark(Constants.MotorPorts.BACK_LEFT_MOTOR_PORT);
    private Spark backRight = new Spark(Constants.MotorPorts.BACK_RIGHT_MOTOR_PORT);
    private MotorControllerGroup leftGroup = new MotorControllerGroup(frontLeft, backLeft);
    private MotorControllerGroup rightGroup = new MotorControllerGroup(frontRight, backRight);
    private DifferentialDrive differentialDrive = new DifferentialDrive(leftGroup, rightGroup);

    public DriveTrainSubsystem() {
        leftGroup.setInverted(true);
        rightGroup.setInverted(false);
    }
    public void arcadeDrive(double speed, double turn) {
        differentialDrive.arcadeDrive(
                MathUtil.clamp(speed, -0.99, 0.99),
                MathUtil.clamp(turn, -0.99, 0.99 )
        );
    }
}

