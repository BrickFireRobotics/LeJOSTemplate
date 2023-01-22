package team.brickfire.template.sensor;

import lejos.hardware.port.Port;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.UARTSensor;

public abstract class Sensor<S extends UARTSensor, T> {

    protected static Sensor[] portsUsed = new Sensor[]{null, null, null, null};
    protected static Port[] ports = new Port[]{SensorPort.S1, SensorPort.S2, SensorPort.S3, SensorPort.S4};

    protected final S sensor;

    /**
     * Creates a sensor of the given Typ
     * @param sensor The sensor the class will manage
     */
    public Sensor(S sensor) {
        this.sensor = sensor;
    }

    /**
     * Returns the wanted sensor in the given port
     *
     * @param port Port the sensor is plugged into (1-4)
     * @return The sensor object
     */

    public abstract T getData();
}
