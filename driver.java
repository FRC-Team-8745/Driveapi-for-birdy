package control;
// Driver api made for birdy.

import frc.robot.CentralComponents.*;

// This is made to controll birdy for testing

public class driver {

    // run this in the init section of your code to set the robot the way it is
    // supposed to be
    public static void init() {
        Components.compressor.stop();
        Components.head.set(Value.kForward);
        Components.beak.set(Value.kForward);
    }

    // driver.elevup(<speed>) is used is used for making the elevator go up
    public static void elevup(Integer speed) {
        Components.elevator.set(speed);
    }

    // driver.elevdown(<speed>) is used for making the elevator go down
    public static void elevdown(Integer speed) {
        Components.elevator.set(-speed);
    }

    // driver.comptog() turns the compressor on and off
    public static void comptog() {
        if (Components.compressor.enabled()) {
            Components.compressor.stop();
        } else {
            Components.compressor.start();
        }
    }

    // driver.beaktog() toggles the beak (It assumes beak is closed when the program
    // starts.)
    public static void beaktog() {
        Components.beak.toggle();
    }

    // driver.headtog() toggles the head position (It assumes that the head is not
    // extended at the start of the program.)
    public static void headtog() {
        Components.head.toggle();
    }

    // driver.drive(<speed>) makes the robot go at the speed given (negative speed
    // makes it go backwards)
    public static void drive(Integer speed) {
        Components.leftMotor.set(speed);
        // right motor is backwards
        Components.rightMotor.set(-speed);
    }

    // driver.motorcont() tells a speed for each motor to go at
    public static void motorcont(Integer right, Integer left) {
        Components.leftMotor.set(left);
        // right motor is backwards
        Components.rightMotor.set(-right);
    }
}
