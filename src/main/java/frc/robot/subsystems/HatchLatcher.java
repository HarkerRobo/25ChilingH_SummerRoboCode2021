package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class HatchLatcher extends SubsystemBase{
    private static HatchLatcher instance;
    private DoubleSolenoid extender;
    private DoubleSolenoid flower;

    public static final int EXTENDER_ID1 = 4;
    public static final int EXTENDER_ID2 = 5;
    public static final int FLOWER_ID1 = 6;
    public static final int FLOWER_ID2 = 7;
    private HatchLatcher()
    {
        extender = new DoubleSolenoid(EXTENDER_ID1, EXTENDER_ID2);
        flower = new DoubleSolenoid(FLOWER_ID1, FLOWER_ID2);
    }
    public static HatchLatcher getInstance()
    {
        if (instance == null)
        {
            instance = new HatchLatcher ();
        }
        return instance;
    }
    public DoubleSolenoid getExtender()
    {
        return extender;
    }
    public DoubleSolenoid getFlower()
    {
        return flower;
    }
    public void toggleFlower()
    {
        if (flower.get() == DoubleSolenoid.Value.kForward)
        {
            flower.set(DoubleSolenoid.Value.kReverse);
        }
        else if (flower.get() == DoubleSolenoid.Value.kReverse)
        {
            flower.set(DoubleSolenoid.Value.kForward);
        }
        else{
            flower.set(DoubleSolenoid.Value.kReverse); 
        }
    }
    public void toggleExtender()
    {
        if (extender.get() == DoubleSolenoid.Value.kForward)
        {
            extender.set(DoubleSolenoid.Value.kReverse);;
        }
        else if (extender.get() == DoubleSolenoid.Value.kReverse)
        {
            extender.set(DoubleSolenoid.Value.kForward);;
        }
        else
        {
            extender.set(DoubleSolenoid.Value.kReverse);
        }
    }
    
}
