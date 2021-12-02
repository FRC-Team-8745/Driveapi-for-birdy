// Driver api made for birdy.
package frc.robot;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Joystick;

public class driver {
    public static Spark elevator = new Spark(2);
    public static Solenoid beakOpen = new Solenoid(0);
    public static Solenoid beakClose = new Solenoid(1);
    public static Solenoid headFlatten = new Solenoid(2);
    public static Solenoid headExtend = new Solenoid(3);
    public static Compressor compressor = new Compressor(0);
    public static Integer compon = 0;
    public static Integer beakopen = 0;
    public static Integer headout = 0;
  
    public static void elevup(Integer speed) {
        elevator.set(speed);
    }
    public static void elevdown(Integer speed) {
        elevator.set(-speed);
    }
    public static void comptop() {
        if (compon == 1) {
            compon = 0;
            compressor.stop();
        } else {
            compon = 1;
            compressor.start();
        }
    }
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
}
