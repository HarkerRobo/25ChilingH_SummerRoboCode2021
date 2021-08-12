package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class IntakeManual extends CommandBase{
    private double speed;
    public IntakeManual(double speed)
    {
        addRequirements(Intake.getInstance());
        this.speed = speed;
        
    }
    public void initialize()
    {

    }
    public void execute()
    {
        Intake.getInstance().setMotor(speed);
    }
    public boolean isFinished()
    {
        return false;
    }
    public void end(boolean interrupted)
    {
        Intake.getInstance().setMotor(0);
    }

}
