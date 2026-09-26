package frc.robot.subsystems;

import com.ctre.phoenix6.controls.DutyCycleOut;
import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ElevatorConstants;

public class ElevatorSubsystem extends SubsystemBase {

    private final TalonFX leftMotor;
    private final TalonFX rightMotor;
    private final DutyCycleOut m_dutyCycle = new DutyCycleOut(0);

    public ElevatorSubsystem() {
        leftMotor = new TalonFX(ElevatorConstants.kLeftElevatorMotorId);
        rightMotor = new TalonFX(ElevatorConstants.kRightElevatorMotorId);

        // Sağ motor sol motoru ters yönde takip eder
        rightMotor.setControl(new Follower(leftMotor.getDeviceID(), true));
    }

    public void setSpeed(double speed) {
        leftMotor.setControl(m_dutyCycle.withOutput(speed));
    }

    public void stop() {
        leftMotor.stopMotor();
    }

    @Override
    public void periodic() {
        // Telemetri verileri
    }
}