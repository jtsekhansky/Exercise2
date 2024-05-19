// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.xrp.XRPMotor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class MotorExercise1 extends SubsystemBase {

  private final XRPMotor m1 = new XRPMotor(0);
  private final XRPMotor m2 = new XRPMotor(1);


  private final Encoder leftEncoder = new Encoder(4, 5);
  private final Encoder rightEncoder = new Encoder(6, 7);

  private final DifferentialDrive d = new DifferentialDrive(m1, m2);
  /** Creates a new MotorExercise1. */
  public MotorExercise1() {
    configureMotors();
  }

  public void runMotorWithPower(double power){
    m1.set(power);
  }

  public void moveRobot (double move, double turn){
    d.arcadeDrive(move, turn);
  }

  public void resetEncoders() {
    leftEncoder.reset();
    rightEncoder.reset();
  }

  public double getLeftDistanceInch() {
    return leftEncoder.getDistance();
  }

  public double getRightDistanceInch() {
    return rightEncoder.getDistance();
  }



  public void configureMotors(){
    m1.setInverted(true);
    m2.setInverted(false);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
