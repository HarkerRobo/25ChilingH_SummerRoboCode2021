package frc.robot;

import harkerrobolib.wrappers.HSGamepad;
import harkerrobolib.wrappers.XboxGamepad;

public class OI {
    private static OI instance;
    private HSGamepad driver;
    public static final int DRIVER_ID = 0;
    private OI()
    {
        driver = new XboxGamepad(DRIVER_ID);
        initBindings();
    }
    public void initBindings()
    {

    }
    public static OI getInstance()
    {
        if (instance == null)
        {
            instance = new OI();
        }
        return instance;
    }
    public HSGamepad getDriver()
    {
        return driver;
    }

}
