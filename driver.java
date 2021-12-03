package controll;
// Driver api made for birdy.
// This is made to controll birdy for testing

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Compressor;

public class driver {
    public static Spark leftMotor = new Spark(1);
    public static Spark rightMotor = new Spark(0);
    public static Spark elevator = new Spark(2);
    public static Solenoid beakOpen = new Solenoid(0);
    public static Solenoid beakClose = new Solenoid(1);
    public static Solenoid headFlatten = new Solenoid(2);
    public static Solenoid headExtend = new Solenoid(3);
    public static Compressor compressor = new Compressor(0);
    public static Integer compon = 0;
    public static Integer beakopen = 0;
    public static Integer headout = 0;
    
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
        if (compon == 1) {
            compon = 0;
            compressor.stop();
        } else {
            compon = 1;
            compressor.start();
        }
    }
    //driver.beaktog() toggles the beak (It assumes beak is closed when the program starts.)
    public static void beaktog() {
        beakOpen.setPulseDuration(0.5);
        beakClose.setPulseDuration(0.5);
        if (beakopen == 1) {
            beakopen = 0;
            beakClose.startPulse();
        } else {
            beakopen = 1;
            beakOpen.startPulse();
        }
    }
    //driver.headtog() toggles the head position (It assumes that the head is not extended at the start of the program.)
    public static void headtog() {
        headExtend.setPulseDuration(0.5);
        headFlatten.setPulseDuration(0.5);
        if (headout == 1) {
            headout = 0;
            headFlatten.startPulse();
        } else {
            headout = 1;
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
