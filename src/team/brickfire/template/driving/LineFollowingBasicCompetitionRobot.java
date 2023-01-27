package team.brickfire.template.driving;

public class LineFollowingBasicCompetitionRobot extends BasicCompetitionRobot implements LineFollower {

    private LineFollowingBasicCompetitionRobot(double wheelDiameter, double wheelOffset, double kP, double kI, double kD) {
        super();
    }

    public static LineFollowingBasicCompetitionRobot create(double wheelDiameter, double wheelOffset, double kP, double kI, double kD) {
        return new LineFollowingBasicCompetitionRobot(wheelDiameter, wheelOffset, kP, kI, kD);
    }

    @Override
    public void followLine(int speed, int distance) {
        // TODO: Implement this method
    }
}
