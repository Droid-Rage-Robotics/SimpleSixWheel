package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class Robot extends TimedRobot {
  //create motors
  private final CANSparkMax m_frontLeftMotor = new CANSparkMax(3, MotorType.kBrushed);
  private final CANSparkMax m_frontRightMotor = new CANSparkMax(1, MotorType.kBrushed);
  private final CANSparkMax m_backLeftMotor = new CANSparkMax(4, MotorType.kBrushed);
  private final CANSparkMax m_backRightMotor = new CANSparkMax(2, MotorType.kBrushed);
  
  //create diff drive with front motors as parent
  private final DifferentialDrive m_robotDrive = new DifferentialDrive(m_frontLeftMotor, m_frontRightMotor);
  
  //create controller
  private final CommandXboxController driverController = new CommandXboxController(0);

  public Robot() {
    //set back motors to follow front motors
    m_backLeftMotor.follow(m_frontLeftMotor);
    m_backRightMotor.follow(m_frontRightMotor);
  }

  @Override
  public void robotInit() {
    //set motor inverted status
    m_frontRightMotor.setInverted(true);
    m_backRightMotor.setInverted(true);
  }

  @Override
  public void teleopPeriodic() {
    //slowmode
    double multiplier = 0.5;
    
    //set slowmode status with "y" button
    if (driverController.y().getAsBoolean()) {
      //slowmode drive
      m_robotDrive.arcadeDrive(multiplier * driverController.getLeftY(), multiplier * driverController.getRightX());
    } else {
      //normal drive
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
