// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.xrp.XRPGyro;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IMUSubsystem extends SubsystemBase {

  private XRPGyro gyro;

  /** Creates a new IMUSubsystem. */
  public IMUSubsystem() {
    gyro = new XRPGyro();
  }

  public double getGyroYaw(){
    return gyro.getAngleZ();
  }
  public double getGyroPitch(){
    return gyro.getAngleX();
  }
  public double getGyroRoll(){
    return gyro.getAngleY();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    //SmartDashboard.putNumber("yaw", getGyroYaw());
  }
}
