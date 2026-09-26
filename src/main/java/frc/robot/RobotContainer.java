package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.SwerveSubsystem;

public class RobotContainer {

    // Alt sistemlerin (Subsystems) tanımlanması
    private final ElevatorSubsystem m_elevator = new ElevatorSubsystem();
    private final SwerveSubsystem m_swerve = new SwerveSubsystem();

    // Sürücü Kumandası (Xbox Controller - Port 0)
    private final CommandXboxController m_driverController =
        new CommandXboxController(OperatorConstants.kDriverControllerPort);

    public RobotContainer() {
        configureBindings();
    }

    private void configureBindings() {
        // Swerve Sürüş Kontrolü (Sol Analok: İleri/Geri & Sağ/Sol, Sağ Analog: Dönüş)
        m_swerve.setDefaultCommand(
            m_swerve.driveCommand(
                () -> -m_driverController.getLeftY(),
                () -> -m_driverController.getLeftX(),
                () -> -m_driverController.getRightX()
            )
        );

        // Asansör Kontrolleri
        // Y Tuşuna basılı tutulduğunda asansör yukarı (%50 güç)
        m_driverController.y()
            .whileTrue(Commands.run(() -> m_elevator.setSpeed(0.5), m_elevator))
            .onFalse(Commands.runOnce(() -> m_elevator.stop(), m_elevator));

        // A Tuşuna basılı tutulduğunda asansör aşağı (%50 güç)
        m_driverController.a()
            .whileTrue(Commands.run(() -> m_elevator.setSpeed(-0.5), m_elevator))
            .onFalse(Commands.runOnce(() -> m_elevator.stop(), m_elevator));
    }

    public Command getAutonomousCommand() {
        return Commands.none();
    }
}