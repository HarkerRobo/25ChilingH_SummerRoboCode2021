package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.HatchLatcher;

public class ToggleFlowerSolenoid extends InstantCommand{
    public ToggleFlowerSolenoid()
    {
        addRequirements(HatchLatcher.getInstance());
    }
    public void initialize()
    {
        HatchLatcher.getInstance().toggleFlower();
    }
     public void execute()
    {

    }
    
}
