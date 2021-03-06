package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.OI;
import frc.robot.subsystems.Drivetrain;

public class ArcadeDrive extends CommandBase{
    private double turn;
    private double drive; // instance variables

    // public static final boolean STOP = false;

    public ArcadeDrive()
    {
        addRequirements(Drivetrain.getInstance());
    }
    public void initialize()
    {

    }
    public void execute()
    {
        turn = OI.getInstance().getDriver().getLeftX();
        drive = OI.getInstance().getDriver().getLeftY();
        Drivetrain.getInstance().setArcadeDrive(turn, drive);
    }
    public boolean isFinished()
    {
        return false;
    }
    public void end(boolean interrupted)
    {
        turn = 0;
        drive = 0;
        Drivetrain.getInstance().setArcadeDrive(turn, drive);
    }
}