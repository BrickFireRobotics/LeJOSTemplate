package team.brickfire.template.actions;

import team.brickfire.template.driving.BasicCompetitionRobot;

public abstract class BaseAction extends BasicCompetitionRobot {

    public BaseAction() {
        super();
    }

    public abstract void run();
}
