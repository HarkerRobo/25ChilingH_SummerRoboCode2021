package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import harkerrobolib.wrappers.HSTalon;

public class Drivetrain extends SubsystemBase
{
    private static Drivetrain instance;
    private HSTalon leftMasterMotor;
    private HSTalon rightMasterMotor;
    private VictorSPX leftFollowerMotor;
    private VictorSPX rightFollowerMotor;
    public static final int MOTOR_ID_LEFT_MASTER = 4;
    public static final int MOTOR_ID_LEFT_FOLLOW = 4;
    public static final int MOTOR_ID_RIGHT_MASTER = 1;
    public static final int MOTOR_ID_RIGHT_FOLLOW = 1;
    public static final boolean IS_INVERTED_LEFT_MASTER = true;
    public static final boolean IS_INVERTED_LEFT_FOLLOWER = true;
    public static final boolean IS_INVERTED_RIGHT_MASTER = false;
    public static final boolean IS_INVERTED_RIGHT_FOLLOWER = false;
    private Drivetrain()
    {
        leftMasterMotor = new HSTalon(MOTOR_ID_LEFT_MASTER);
        leftFollowerMotor = new VictorSPX(MOTOR_ID_LEFT_FOLLOW);
        rightMasterMotor = new HSTalon(MOTOR_ID_RIGHT_MASTER);
        rightFollowerMotor = new VictorSPX(MOTOR_ID_RIGHT_FOLLOW);

    }
    public void talonInit()
    {
        rightFollowerMotor.follow(rightMasterMotor);
        leftFollowerMotor.follow(leftMasterMotor);
        rightMasterMotor.setInverted(IS_INVERTED_RIGHT_MASTER);
        rightFollowerMotor.setInverted(IS_INVERTED_RIGHT_FOLLOWER);
        leftMasterMotor.setInverted(IS_INVERTED_LEFT_MASTER);
        leftFollowerMotor.setInverted(IS_INVERTED_LEFT_FOLLOWER);
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