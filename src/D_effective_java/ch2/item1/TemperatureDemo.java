package D_effective_java.ch2.item1;

enum TemperatureUnit {
    CELSIUS, FAHRENHEIT
}

class Temperature {
    private double temperature;
    private TemperatureUnit temperatureUnit;

    private Temperature(double temperature, TemperatureUnit temperatureUnit) {
        this.temperature = temperature;
        this.temperatureUnit = temperatureUnit;
    }

    public static Temperature ofCelsius(double temperature) {
        return new Temperature(temperature, TemperatureUnit.CELSIUS);
    }

    public static Temperature ofFahrenheit(double temperature) {
        return new Temperature(temperature, TemperatureUnit.FAHRENHEIT);
    }

    // these could not have both been constructors with a single double parameter each
}

public class TemperatureDemo {
}
