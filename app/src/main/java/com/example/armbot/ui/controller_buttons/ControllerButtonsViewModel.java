package com.example.armbot.ui.controller_buttons;

import androidx.lifecycle.ViewModel;

public class ControllerButtonsViewModel extends ViewModel {
    /*
    There are 6 motors going from 1 to 6.
    The first motor (Motor 1), is the one from the base of the robotic arm.
    The last one (Motor 6), is the one used to control the robot's claw.
     */
    private static int degreesMotor1 = -1, degreesMotor2 = -1, degreesMotor3 = -1, degreesMotor4 = -1, degreesMotor5 = -1, degreesMotor6 = -1;

    public static int getDegreesMotor1() {
        return degreesMotor1;
    }

    public static void setDegreesMotor1(int degreesMotor1) {
        ControllerButtonsViewModel.degreesMotor1 = degreesMotor1;
    }

    public static int getDegreesMotor2() {
        return degreesMotor2;
    }

    public static void setDegreesMotor2(int degreesMotor2) {
        ControllerButtonsViewModel.degreesMotor2 = degreesMotor2;
    }

    public static int getDegreesMotor3() {
        return degreesMotor3;
    }

    public static void setDegreesMotor3(int degreesMotor3) {
        ControllerButtonsViewModel.degreesMotor3 = degreesMotor3;
    }

    public static int getDegreesMotor4() {
        return degreesMotor4;
    }

    public static void setDegreesMotor4(int degreesMotor4) {
        ControllerButtonsViewModel.degreesMotor4 = degreesMotor4;
    }

    public static int getDegreesMotor5() {
        return degreesMotor5;
    }

    public static void setDegreesMotor5(int degreesMotor5) {
        ControllerButtonsViewModel.degreesMotor5 = degreesMotor5;
    }

    public static int getDegreesMotor6() {
        return degreesMotor6;
    }

    public static void setDegreesMotor6(int degreesMotor6) {
        ControllerButtonsViewModel.degreesMotor6 = degreesMotor6;
    }
}