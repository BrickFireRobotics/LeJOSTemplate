package team.brickfire.template.sensor;

import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3ColorSensor;
import team.brickfire.template.sensor.data.Color;

public class ColorSensor<C extends Color> extends Sensor<EV3ColorSensor, C> {
    /**
     * Creates a sensor of the given Typ
     *
     * @param sensor The sensor the class will manage
     */
    protected ColorSensor(Port port) {
        super(new EV3ColorSensor(port));
        sensor.setCurrentMode(0);
    }

    public static <C extends Color> ColorSensor<C> get(int port) {
        if (portsUsed[port - 1] == null) {
            try {
                ColorSensor<C> sensor = new ColorSensor<>(ports[port - 1]);
                portsUsed[port - 1] = sensor;
                return sensor;
            } catch (Exception e) {
                throw new NoSensorFoundException(e.getClass().getName() + " at port " + port + ": " + e.getMessage());
            }
        }
        if (portsUsed[port - 1] instanceof ColorSensor) {
            return (ColorSensor<C>) portsUsed[port - 1];
        }
        throw new NoSensorFoundException("No ColorSensor connected to port " + port);
    }

    @Override
    public C getData() {
        return (C) C.create(sensor.getColorID(), getReflectedLight(), getRGB());
    }

    public C getColor() {
        return getData();
    }

    public float getReflectedLight() {
        float[] value = {0};
        sensor.getRedMode().fetchSample(value, 0);
        return value[0];
    }

    public float[] getRGB() {
        float[] value = {0, 0, 0};
        sensor.getRGBMode().fetchSample(value, 0);
        return value;
    }

    public boolean isColor(Color color) {
        return color.equals(getColor());
    }

}
