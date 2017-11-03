package org.xbot.ftc.robotcore.subsystems.cube;


import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.xbot.ftc.robotcore.XbotRobotConstants;
import org.xbot.ftc.robotcore.subsystems.XbotSubsystem;

public class CubeGripper extends XbotSubsystem {

    public static final String CLASS_NAME = CubeGripper.class.getName();
    private static CubeGripper instance = null;
    private static boolean initialized = false;

    private DcMotor gripperMotor;

    private CubeGripper() {
    }

    @Override
    public void init(HardwareMap hardwareMap) {
        if (initialized) return;
        gripperMotor = hardwareMap.get(DcMotor.class, XbotRobotConstants.GRIPPER_MOTOR);

        initialized = true;
    }

    public void setPower(double power) {
        gripperMotor.setPower(power);
    }

    @Override
    public String getClassName() {
        return CLASS_NAME;
    }

    public static XbotSubsystem getInstance() {
        if (instance == null) {
            instance = new CubeGripper();
        }
        return instance;
    }
}
