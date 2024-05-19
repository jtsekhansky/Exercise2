// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.DriveManuallyCommand;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.RunUntilFlat;
import frc.robot.commands.ServoTo180;
import frc.robot.commands.ServoToZero;
import frc.robot.commands.StartMotor;
import frc.robot.commands.StopMotor;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.IMUSubsystem;
import frc.robot.subsystems.MotorExercise1;
import frc.robot.subsystems.RadarSubsystem;
import frc.robot.subsystems.XRPDrivetrain;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.PrintCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  //private final XRPDrivetrain m_xrpDrivetrain = new XRPDrivetrain();

  public static MotorExercise1 motorExercise1subsystem = new MotorExercise1();
  public static ArmSubsystem armSubsystem = new ArmSubsystem();
  public static Joystick js1;
  public static RadarSubsystem radarSubsystem = new RadarSubsystem();
  public static IMUSubsystem imuSubsystem = new IMUSubsystem();

  //private final ExampleCommand m_autoCommand = new ExampleCommand(m_xrpDrivetrain);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    js1 = new Joystick(0);
    // Configure the button bindings
    configureButtonBindings();

    motorExercise1subsystem.setDefaultCommand(new DriveManuallyCommand());
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link edu.wpi.first.wpilibj.GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    //new JoystickButton(js1, 2)
      //.onTrue(new PrintCommand("Hello Jacob."))
      //.onFalse(new PrintCommand("Goodbye Jacob."));


      //new JoystickButton(js1, 2)
      //.onTrue(new StartMotor())
      //.onFalse(new StopMotor());

      //testServo();
      //testRadar();
      testClimb();
  }

  private void testServo(){
    new JoystickButton(js1, 1)
      .onTrue(new ServoToZero());
    new JoystickButton(js1, 2)
      .onTrue(new ServoTo180());
  }

  private void testRadar(){
      new Trigger( ()->  (radarSubsystem.getRange()<0.2) )
      .onTrue(new ServoTo180())
      .onFalse(new ServoToZero());
  }

  private void testClimb(){
    new JoystickButton(js1, 1)
    .onTrue(new RunUntilFlat())
    .onFalse(new InstantCommand( () -> motorExercise1subsystem.moveRobot(0, 0), motorExercise1subsystem ));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    //return m_autoCommand;
    return null;
  }
}
