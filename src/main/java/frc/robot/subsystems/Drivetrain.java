package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import harkerrobolib.wrappers.HSTalon;

public class Drivetrain extends SubsystemBase
{
    public static Drivetrain instance;
    private HSTalon leftMasterMotor;
    private HSTalon rightMasterMotor;
    private HSTalon leftFollowerMotor;
    private HSTalon rightFollowerMotor;
    public static final int MOTOR_ID_LEFT_MASTER = 0;
    public static final int MOTOR_ID_LEFT_FOLLOW = 0;
    public static final int MOTOR_ID_RIGHT_MASTER = 0;
    public static final int MOTOR_ID_RIGHT_FOLLOW = 0;
    private Drivetrain()
    {
        leftMasterMotor = new HSTalon(MOTOR_ID_LEFT_MASTER);
        leftFollowerMotor = new HSTalon(MOTOR_ID_LEFT_FOLLOW);
        rightMasterMotor = new HSTalon(MOTOR_ID_RIGHT_MASTER);
        rightFollowerMotor = new HSTalon(MOTOR_ID_RIGHT_FOLLOW);
    }
    public void setArcadeDrive(double turn, double drive)
    {
        leftMasterMotor.set(ControlMode.PercentOutput, drive+turn);
        rightMasterMotor.set(ControlMode.PercentOutput, drive-turn);
    }
    public static Drivetrain getInstance()
    {
        if (instance == null)
        {
            instance = new Drivetrain();
        }
        return instance;
    }
}