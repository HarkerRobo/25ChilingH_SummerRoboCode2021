package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Intake;

public class ToggleSolenoid extends InstantCommand{
    public ToggleSolenoid()
    {
        addRequirements(Intake.getInstance());
    }
    public void initialize() 
    {
        Intake.getInstance().toggle();
    }
    public void execute()
    {

    }
    
}
