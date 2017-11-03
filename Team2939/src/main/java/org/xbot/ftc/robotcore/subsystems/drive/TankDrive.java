package org.xbot.ftc.robotcore.subsystems.drive;

import com.qualcomm.robotcore.util.Range;

public class TankDrive {

    private Drive drive;

    protected TankDrive(Drive drive) {
        this.drive = drive;
    }

    public void drive(double leftPower, double rightPower) {
        drive.setMotorPowers(leftPower, rightPower);
    }

    public void stop() {
        drive.setMotorPowers(0);
    }
}
