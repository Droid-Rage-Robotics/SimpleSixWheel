package frc.robot.subsystems.drive;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SixWheel extends SubsystemBase {
    private final CANSparkMax frontLeftMotor = new CANSparkMax(3, MotorType.kBrushed);
    private final CANSparkMax frontRightMotor = new CANSparkMax(1, MotorType.kBrushed);
    private final CANSparkMax backLeftMotor = new CANSparkMax(4, MotorType.kBrushed);
    private final CANSparkMax backRightMotor = new CANSparkMax(2, MotorType.kBrushed);
    public final DifferentialDrive drivetrain = new DifferentialDrive(frontLeftMotor, frontRightMotor);

    public SixWheel() {
        backLeftMotor.follow(frontLeftMotor);
        backRightMotor.follow(frontRightMotor);
    }

    public void drive(double setPowerSpeed, double setPowerRotation) {
        drivetrain.arcadeDrive(setPowerSpeed, setPowerRotation);
    }
}
