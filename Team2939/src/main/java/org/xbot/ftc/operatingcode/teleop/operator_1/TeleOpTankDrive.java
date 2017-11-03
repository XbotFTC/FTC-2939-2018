package org.xbot.ftc.operatingcode.teleop.operator_1;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.xbot.ftc.operatingcode.teleop.XbotOperatorSubHandler;
import org.xbot.ftc.robotcore.subsystems.drive.Drive;
import org.xbot.ftc.robotcore.subsystems.drive.TankDrive;

public class TeleOpTankDrive extends XbotOperatorSubHandler {

    private Drive drive;
    private TankDrive tankDrive;

    private double powerMultiplier = 1.0;

    @Override
    public void start(HardwareMap hardwareMap, Telemetry telemetry) {
        super.start(hardwareMap, telemetry);
        drive = (Drive) robotSystemsManager.getSubsystem(Drive.CLASS_NAME);
        tankDrive = drive.getTankDrive();
    }

    @Override
    public void handle(Gamepad gamepad1, Gamepad gamepad2) {
        if (gamepad1.dpad_up) {
            powerMultiplier = 1.0;
        } else if (gamepad1.dpad_left || gamepad1.dpad_right) {
            powerMultiplier = 0.5;
        } else if (gamepad1.dpad_down) {
            powerMultiplier = 0.25;
        }
        double drive = gamepad1.left_stick_y;
        double turn = gamepad1.right_stick_x;
        tankDrive.drive(Range.clip(drive - turn, -1.0, 1.0) * powerMultiplier,
                        Range.clip(drive + turn, -1.0, 1.0) * powerMultiplier);
    }

    @Override
    public void stop() {
        tankDrive.stop();
    }

    @Override
    public void updateTelemetry() {
        telemetry.addData("LeftPower: ", drive.getLeftFrontDrive().getPower());
        telemetry.addData("RightPower: ", drive.getRightFrontDrive().getPower());
        telemetry.update();
    }
}
