package team.brickfire.template.sensor.data;

import java.util.Objects;

public class Color implements DataType<Color> {

    protected final EV3Color color;

    public Color(EV3Color color) {
        this.color = color;
    }

    public Color(int id) {
        this.color = EV3Color.fromLeJOSID(id);
    }

    public static Color create(Object... args) {
        return new Color((int) args[0]);
    }

    @Override
    public double error(Color other) {
        return color.equals(other.color) ? 0 : 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof Color) {
            Color color = (Color) o;
            return Objects.equals(this.color, color.color);
        } else if (o instanceof EV3Color) {
            EV3Color color = (EV3Color) o;
            return Objects.equals(this.color, color);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color);
    }

    @Override
    public String toString() {
        return "Color{ lejosColor=" + color + " }";
    }
}
