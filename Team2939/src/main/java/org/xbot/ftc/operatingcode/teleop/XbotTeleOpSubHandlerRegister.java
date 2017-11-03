package org.xbot.ftc.operatingcode.teleop;

import org.xbot.ftc.operatingcode.teleop.operator_1.TeleOpDrive;
import org.xbot.ftc.operatingcode.teleop.operator_2.TeleOpElevator;
import org.xbot.ftc.operatingcode.teleop.operator_2.TeleOpGripper;

import java.util.ArrayList;
import java.util.List;

public class XbotTeleOpSubHandlerRegister {

    private static List<XbotTeleOpHandler> listeners = new ArrayList<>();

    public static void registerListeners() {
        listeners.add(new TeleOpElevator());
        listeners.add(new TeleOpGripper());
        listeners.add(new TeleOpDrive());

        for (XbotTeleOpHandler listener : listeners) {
            XbotTeleOp.registerListener(listener);
        }
    }

    public static List<XbotTeleOpHandler> getListeners() {
        return listeners;
    }
}
