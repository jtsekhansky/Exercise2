// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;

public class RunUntilFlat extends Command {
  private double tolerenceAngle = 1.0;
  private double finalAngle = 0.0;
  /** Creates a new RunUntilFlat. */
  public RunUntilFlat() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.motorExercise1subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.motorExercise1subsystem.moveRobot(-1.0, 0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    RobotContainer.motorExercise1subsystem.moveRobot(-1.0, 0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.motorExercise1subsystem.moveRobot(0, 0);
    System.out.println("Climb Command end");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(Math.abs(finalAngle - RobotContainer.imuSubsystem.getGyroPitch())<finalAngle){
        return true;
    }
    return false;
  }
}
