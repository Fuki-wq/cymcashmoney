package frc.robot;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.util.Units;

public final class Constants {

    public static class OperatorConstants {
        public static final int kDriverControllerPort = 0;
    }

    // Swerve Modül ve CAN Bus Ayarları
    public static class SwerveConstants {
        // Gyro & Swerve Ayarları (YAGSL için)
        public static final int kPigeonCanId = 13;
        
        // Şasi Boyutları (Tekerlekler arası mesafe - Metre cinsinden)
        public static final double kTrackWidth = Units.inchesToMeters(24.0); // Sağ-Sol teker arası
        public static final double kWheelBase = Units.inchesToMeters(24.0);  // Ön-Arka teker arası
    }

    // Kraken X60 Motorlu Asansör (Elevator) Sabitleri
    public static class ElevatorConstants {
        // Asansör Motor CAN ID'leri (Kraken X60)
        public static final int kLeftElevatorMotorId = 14;
        public static final int kRightElevatorMotorId = 15;

        // Limitleyiciler ve Oranlar
        public static final double kElevatorGearRatio = 10.0; // 10:1 Redüktör oranı
        public static final double kMinHeightMeters = 0.0;
        public static final double kMaxHeightMeters = 1.5; // Maksimum 1.5 metre yükseklik

        // Asansör PID Ayarları
        public static final double kP = 0.1;
        public static final double kI = 0.0;
        public static final double kD = 0.0;
    }
}