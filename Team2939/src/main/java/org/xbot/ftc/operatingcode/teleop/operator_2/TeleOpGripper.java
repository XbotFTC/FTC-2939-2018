package org.xbot.ftc.operatingcode.teleop.operator_2;


import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.xbot.ftc.operatingcode.teleop.XbotOperatorSubHandler;
import org.xbot.ftc.robotcore.subsystems.cube.CubeGripper;

public class TeleOpGripper extends XbotOperatorSubHandler {

    private CubeGripper cubeGripper;

    @Override
    public void start(HardwareMap hardwareMap, Telemetry telemetry) {
        super.start(hardwareMap, telemetry);
        cubeGripper = (CubeGripper) robotSystemsManager.getSubsystem(CubeGripper.CLASS_NAME);
    }

    @Override
    public void handle(Gamepad gamepad1, Gamepad gamepad2) {
        if (gamepad2.right_bumper || gamepad1.right_bumper) {
            cubeGripper.setPower(-1);
        } else if (gamepad2.right_trigger > 0.1 || gamepad1.right_trigger > 0.1) {
            cubeGripper.setPower(1);
        } else {
            cubeGripper.setPower(0);
        }
    }

    @Override
    public void stop() {
        cubeGripper.setPower(0);
    }

    @Override
    public void updateTelemetry() {

    }
}
