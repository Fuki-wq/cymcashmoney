package frc.robot.subsystems;

public class SwerveSubsystem {
    
}
package frc.robot.subsystems;

import java.io.File;
import java.io.IOException;
import java.util.function.DoubleSupplier;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import swervelib.SwerveDrive;
import swervelib.parser.SwerveParser;

public class SwerveSubsystem extends SubsystemBase {

    private SwerveDrive swerveDrive;

    public SwerveSubsystem() {
        try {
            File swerveJsonDir = new File(Filesystem.getDeployDirectory(), "swerve");
            swerveDrive = new SwerveParser(swerveJsonDir).createSwerveDrive(4.5);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Command driveCommand(DoubleSupplier translationX, DoubleSupplier translationY, DoubleSupplier heading) {
        return run(() -> {
            swerveDrive.drive(
                new Translation2d(translationX.getAsDouble(), translationY.getAsDouble()),
                heading.getAsDouble(),
                true,
                false
            );
        });
    }
}