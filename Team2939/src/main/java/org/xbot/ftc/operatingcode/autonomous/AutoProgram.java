package org.xbot.ftc.operatingcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.xbot.ftc.robotcore.subsystems.RobotSubsystemManager;
import org.xbot.ftc.robotcore.subsystems.cube.CubeElevator;
import org.xbot.ftc.robotcore.subsystems.cube.CubeGripper;
import org.xbot.ftc.robotcore.subsystems.drive.Drive;

@Autonomous(name="Main: Auto", group="Main")
public class AutoProgram extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        RobotSubsystemManager robotSubsystemManager = RobotSubsystemManager.getInstance();
        robotSubsystemManager.init(hardwareMap);

        Drive drive = (Drive) robotSubsystemManager.getSubsystem(Drive.CLASS_NAME);
        CubeElevator cubeElevator =
                (CubeElevator) robotSubsystemManager.getSubsystem(CubeElevator.CLASS_NAME);
        CubeGripper cubeGripper =
                (CubeGripper) robotSubsystemManager.getSubsystem(CubeGripper.CLASS_NAME);

        waitForStart();

        cubeGripper.setPower(-1);
        Thread.sleep(500);
        cubeGripper.setPower(0);
        cubeElevator.setPower(1);
        Thread.sleep(500);
        cubeElevator.setPower(0);
        drive.setMotorPowers(-1);
        Thread.sleep(1500);
        drive.setMotorPowers(-1, 1);
        Thread.sleep(500);
        drive.setMotorPowers(-1);
        Thread.sleep(700);
        drive.setMotorPowers(0);
        cubeElevator.setPower(-1);
        Thread.sleep(200);
        cubeElevator.setPower(0);
        cubeGripper.setPower(1);
        Thread.sleep(1000);
        cubeGripper.setPower(-1);
        Thread.sleep(200);
        cubeGripper.setPower(0);
    }
}
