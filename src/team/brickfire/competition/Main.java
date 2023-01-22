package team.brickfire.competition;

import lejos.hardware.Button;
import lejos.hardware.Sound;
import team.brickfire.competition.actions.MainAction;
import team.brickfire.template.driving.BasicCompetitionRobot;

public class Main {

    public static void main(String[] args) {
        // TODO: Adjust this to your needs
        BasicCompetitionRobot robot = new BasicCompetitionRobot(0 ,0);
        // Without this starts can be unpredictable
        robot.drive(0.01);
        Sound.beep();
        Button.waitForAnyEvent();
        MainAction.getInstance().run();
    }
}
