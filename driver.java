package controll;
// Driver api made for birdy.
// This is made to controll birdy for testing

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Compressor;

public class driver {
    private static Spark leftMotor = new Spark(1);
    private static Spark rightMotor = new Spark(0);
    private static Spark elevator = new Spark(2);
    private static Solenoid beakOpen = new Solenoid(0);
    private static Solenoid beakClose = new Solenoid(1);
    private static Solenoid headFlatten = new Solenoid(2);
    private static Solenoid headExtend = new Solenoid(3);
    private static Compressor compressor = new Compressor(0);
    private static boolean compon = true;
    private static boolean beakopen = true;
    private static boolean headout = true;
    
    //driver.elevup(<speed>) is used is used for making the elevator go up
    public static void elevup(Integer speed) {
        elevator.set(speed);
    }
    //driver.elevdown(<speed>) is used for making the elevator go down
    public static void elevdown(Integer speed) {
        elevator.set(-speed);
    }
    //driver.comptog() turns the compressor on and off (It assumes the compressor is off when the program starts.)
    public static void comptog() {
        if (compon) {
            compon = false;
            compressor.stop();
        } else {
            compon = true;
            compressor.start();
        }
    }
    //driver.beaktog() toggles the beak (It assumes beak is closed when the program starts.)
    public static void beaktog() {
        beakOpen.setPulseDuration(0.5);
        beakClose.setPulseDuration(0.5);
        if (beakopen) {
            beakopen = false;
            beakClose.startPulse();
        } else {
            beakopen = true;
            beakOpen.startPulse();
        }
    }
    //driver.headtog() toggles the head position (It assumes that the head is not extended at the start of the program.)
    public static void headtog() {
        headExtend.setPulseDuration(0.5);
        headFlatten.setPulseDuration(0.5);
        if (headout) {
            headout = false;
            headFlatten.startPulse();
        } else {
            headout = true;
            headExtend.startPulse();
        }
    }
    //driver.drive(<speed>) makes the robot go at the speed given (negative speed makes it go backwards)
    public static void drive(Integer speed) {
        leftMotor.set(speed);
        //right motor is backwards
        rightMotor.set(-speed);
    }
    //driver.motorcont() tells a speed for each motor to go at
    public static void motorcont(Integer right, Integer left) {
        leftMotor.set(left);
        //right motor is backwards
        rightMotor.set(-right);
    }
}
