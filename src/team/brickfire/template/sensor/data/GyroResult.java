package team.brickfire.template.sensor.data;

import java.util.Objects;

public class GyroResult implements DataType<GyroResult> {

    private final int angle;
    private final double rate;

    public GyroResult(int angle) {
        this.angle = angle;
        this.rate = 0;
    }

    public GyroResult(int angle, double rate) {
        this.angle = angle;
        this.rate = rate;
    }

    public GyroResult create(Object ... args) {
        if (args.length == 2) {
            return new GyroResult((int) args[0], (double) args[1]);
        }
        return new GyroResult((int)args[0]);
    }

    @Override
    public double error(GyroResult other) {
        return Math.abs(angle - other.angle) / 180.0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof GyroResult) {
            GyroResult that = (GyroResult) o;
            return angle == that.angle;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(angle);
    }
}
