package frc.robot.commands.drive;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.drive.SixWheel;

public class ManualSixWheel extends Command {
    private SixWheel drivetrain;
    private CommandXboxController driverController;

    public ManualSixWheel(SixWheel drivetrain, CommandXboxController driverController) {
        this.drivetrain = drivetrain;
        this.driverController = driverController;

        addRequirements(drivetrain);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        drivetrain.drive(driverController.getLeftX(), driverController.getRightY());
    }
}