package team.brickfire.competition.actions;

import team.brickfire.template.actions.BaseAction;

public class MainAction extends BaseAction {

    private static final MainAction INSTANCE = new MainAction();

    public static MainAction getInstance() {
        return INSTANCE;
    }

    @Override
    public void run() {
        // TODO: call your other actions here
    }
}
