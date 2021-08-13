package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.HatchLatcher;

public class ToggleExtenderSolenoid extends InstantCommand{
    public ToggleExtenderSolenoid()
    {
        addRequirements(HatchLatcher.getInstance());
    }
    public void initialize()
    {
        HatchLatcher.getInstance().toggleExtender();
    }
     public void execute()
    {

    }
}
