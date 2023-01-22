package team.brickfire.template.sensor.data;

public enum EV3Color {

    NONE_MATCHING(-2),
    NO_COLOR(lejos.robotics.Color.NONE),
    BLACK(lejos.robotics.Color.BLACK),
    WHITE(lejos.robotics.Color.WHITE),
    RED(lejos.robotics.Color.RED),
    GREEN(lejos.robotics.Color.GREEN),
    BLUE(lejos.robotics.Color.BLUE),
    YELLOW(lejos.robotics.Color.YELLOW),
    BROWN(lejos.robotics.Color.BROWN);

    private final int lejosColorID;

    EV3Color(int lejosColorID) {
        this.lejosColorID = lejosColorID;
    }

    /**
     * <p>Returns the custom Color for a given id from {@link lejos.robotics.Color}</p>
     *
     * @param id LeJOS color id
     * @return The corresponding color
     */
    public static EV3Color fromLeJOSID(int id) {
        for (EV3Color v : EV3Color.values()) {
            if (v.lejosColorID == id) {
                return v;
            }
        }
        return EV3Color.NO_COLOR;
    }

}
