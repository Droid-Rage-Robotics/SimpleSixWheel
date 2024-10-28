package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.intake.Intake;

public class ManualIntake extends Command {
    private Intake setTarget;
    private CommandXboxController driverController;

    public ManualIntake(Intake setTarget, CommandXboxController driverController) {
        this.setTarget = setTarget;
        this.driverController = driverController;

        addRequirements(setTarget);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        setTarget.setTarget(driverController.getRightTriggerAxis());
    }
}
