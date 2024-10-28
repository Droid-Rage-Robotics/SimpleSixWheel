// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class Robot extends TimedRobot {
  private final CANSparkMax m_frontLeftMotor = new CANSparkMax(3, MotorType.kBrushed);
  private final CANSparkMax m_frontRightMotor = new CANSparkMax(1, MotorType.kBrushed);
  private final CANSparkMax m_backLeftMotor = new CANSparkMax(4, MotorType.kBrushed);
  private final CANSparkMax m_backRightMotor = new CANSparkMax(2, MotorType.kBrushed);
  private final DifferentialDrive m_robotDrive = new DifferentialDrive(m_frontLeftMotor, m_frontRightMotor);
  private final CommandXboxController driverController = new CommandXboxController(0);

  public Robot() {
    m_backLeftMotor.follow(m_frontLeftMotor);
    m_backRightMotor.follow(m_frontRightMotor);
  }

  @Override
  public void robotInit() {
    m_frontRightMotor.setInverted(true);
    m_backRightMotor.setInverted(true);
  }

  @Override
  public void teleopPeriodic() {
    double multiplier = 0.5;
    if (driverController.y().getAsBoolean()) {
      m_robotDrive.arcadeDrive(multiplier * driverController.getLeftY(), multiplier * driverController.getRightX());
    } else {
      m_robotDrive.arcadeDrive(driverController.getLeftY(), driverController.getRightX());
    }
   
    
  }

  @Override
  public void disabledPeriodic(){

  }

  @Override
  public void robotPeriodic(){
    
  }
}
