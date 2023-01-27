package team.brickfire.template.sensor;

import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3GyroSensor;
import team.brickfire.template.sensor.data.GyroResult;

public class GyroSensor extends Sensor<EV3GyroSensor, GyroResult> {


    protected GyroSensor(Port port) {
        super(new EV3GyroSensor(port));
        sensor.reset();
    }

    public static GyroSensor get(int port) {
        if (portsUsed[port - 1] == null) {
            try {
                GyroSensor sensor = new GyroSensor(ports[port - 1]);
                portsUsed[port - 1] = sensor;
                return sensor;
            } catch (Exception e) {
                throw new NoSensorFoundException(e.getClass().getName() + " at port " + port + ": " + e.getMessage());
            }
        }
        if (portsUsed[port - 1] instanceof ColorSensor) {
            return (GyroSensor) portsUsed[port - 1];
        }
        throw new NoSensorFoundException("No GyroSensor connected to port " + port);
    }

    @Override
    public GyroResult getData() {
        float[] data = new float[]{-1,-1};
        sensor.getAngleAndRateMode().fetchSample(data, 0);
        return new GyroResult((int)data[1], data[0]);
    }


}
