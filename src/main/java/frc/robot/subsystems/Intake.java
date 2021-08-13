package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import harkerrobolib.wrappers.HSFalcon;


public class Intake extends SubsystemBase{
    private static Intake instance;
    private HSFalcon motor;
    public static final int CAN_ID = 1;
    public static final boolean IS_INVERTED = false;

    private DoubleSolenoid doubleS;
    public static final int DOUBLE_S_ID1 = 2;
    public static final int DOUBLE_S_ID2 = 3;

    private Intake()
    {
        motor = new HSFalcon(CAN_ID);
        doubleS = new DoubleSolenoid(DOUBLE_S_ID1, DOUBLE_S_ID2);
    }
    public static Intake getInstance()
    {
        if (instance == null)
        {
            instance = new Intake();
        }
        return instance;
    }
    public HSFalcon getMotor()
    {
        return motor;
    }
    public void setMotor(double speed)
    {
        motor.set(ControlMode.PercentOutput, speed);
    }
    public void toggle()
    {
        if (doubleS.get() == DoubleSolenoid.Value.kForward)
        {
            doubleS.set(DoubleSolenoid.Value.kReverse);
        }
        else if (doubleS.get() == DoubleSolenoid.Value.kReverse)
        {
            doubleS.set(DoubleSolenoid.Value.kForward);
        }
        else{
            doubleS.set(DoubleSolenoid.Value.kReverse); // change if default state = kReverse
        }
    }
    
}
