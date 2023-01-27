package team.brickfire.template.sensor.data;

import java.util.Arrays;

public class AdvancedColor extends Color {

    private final float reflectance;
    private final float[] rgb;

    public AdvancedColor(EV3Color color) {
        super(color);
        this.reflectance = -1;
        this.rgb = new float[]{-1, -1, -1 };
    }

    public AdvancedColor(int id) {
        super(id);
        this.reflectance = -1;
        this.rgb = new float[]{-1, -1, -1 };
    }

    public AdvancedColor(EV3Color color, float reflectance, float[] rgb) {
        super(color);
        this.reflectance = reflectance;
        this.rgb = rgb;
    }

    @Override
    public double error(Color other) {
        if (!(other instanceof AdvancedColor)) {
            return super.error(other);
        }
        AdvancedColor otherColor = (AdvancedColor) other;
        double colorError = super.error(other);
        double reflectanceError = 0;
        if (reflectance != -1 && otherColor.reflectance != -1 && !Float.isNaN(reflectance) && !Float.isNaN(otherColor.reflectance)) {
            reflectanceError = Math.abs(reflectance - otherColor.reflectance);
        }
        double rgbError = 0;
        for (int i = 0; i < 3; i++) {
            if (rgb[i] == -1 || Float.isNaN(rgb[i]) || otherColor.rgb[i] == -1 || Float.isNaN(otherColor.rgb[i])) {
                rgbError = 0;
                break;
            }
            rgbError += Math.abs(rgb[i] - otherColor.rgb[i]);
        }
        rgbError /= 3;
        return (colorError + reflectanceError + rgbError) / 3;
    }

    public static AdvancedColor create(Object... args) {
        if (args.length == 3) {
            return new AdvancedColor((EV3Color) args[0], (float) args[1], (float[]) args[2]);
        }
        return new AdvancedColor((int) args[0]);

    }

    @Override
    public String toString() {
        return "AdvancedColor{ color=" + color + ", reflectance=" + reflectance + ", rgb=" + Arrays.toString(rgb) + " }";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof AdvancedColor) {
            AdvancedColor c = (AdvancedColor) o;
            return color == c.color && this.reflectance == c.reflectance && Arrays.equals(this.rgb, c.rgb);
        } else if (o instanceof Color) {
            Color color = (Color) o;
            return super.equals(color);
        } else if (o instanceof EV3Color) {
            EV3Color color = (EV3Color) o;
            return super.equals(color);
        }
        return false;
    }
}
