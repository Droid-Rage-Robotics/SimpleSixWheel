package frc.robot.subsystems.intake;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.utility.motor.SafeCanSparkMax;
import frc.robot.utility.motor.SafeMotor.IdleMode;
import frc.robot.utility.shuffleboard.ShuffleboardValue;

public class Intake extends SubsystemBase {
    private final CANSparkMax intakeMotor;
    private final PIDController controller;
    private double positionError;
    private double target;

    public Intake() {
        intakeMotor = new CANSparkMax(5, MotorType.kBrushless);
        controller = new PIDController(0, 0, 0);
        controller.setTolerance(0);
        positionError = controller.getPositionError();
    }
    /*public Intake() {
        intakeMotor = new SafeCanSparkMax(
            5,
            MotorType.kBrushless,
            true,
            IdleMode.Coast, 
            0, 
            0, 
            ShuffleboardValue.create(true, "Intake/Is Enabled", Intake.class.getSimpleName())
                .withWidget(BuiltInWidgets.kToggleSwitch)
                .build(), 
            ShuffleboardValue.create(0.0, "OwnSixWheel/Output Writerfl", Intake.class.getSimpleName())
                .build() );
    }*/

    public void periodic() {
        intakeMotor.set(controller.calculate(positionError, target));
    }

    public void setTarget(double target) {
        controller.setSetpoint(target);
    }
}
