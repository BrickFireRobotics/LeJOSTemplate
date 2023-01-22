package team.brickfire.template.sensor.data;

public interface DataType<T extends DataType<T>> {

    double error(T other);
}
