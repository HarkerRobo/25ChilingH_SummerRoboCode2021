package frc.robot.subsystems;


import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class Intake extends SubsystemBase{
    private static Intake instance;
    private CANSparkMax motor;
    public static final int CAN_ID = 1;
    public static final boolean IS_INVERTED = false;

    private DoubleSolenoid doubleS;
    public static final int DOUBLE_S_ID1 = 2;
    public static final int DOUBLE_S_ID2 = 3;

    private Intake()
    {
        motor = new CANSparkMax(CAN_ID, MotorType.kBrushless);
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
    public CANSparkMax getMotor()
    {
        return motor;
    }
    public void setMotor(double speed)
    {
        motor.set(speed);
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
