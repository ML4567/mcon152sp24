package E_design_patterns;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

interface Publisher {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

// Concrete publisher
class WeatherStation implements Publisher {
    private double temperature;
    private double humidity;
    private double pressure;
    private Collection<Observer> observers;

    public WeatherStation() {
        observers = new ArrayList<>();
    }

    public void setMeasurements(double temperature, double humidity, double pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature, humidity, pressure);
        }
    }
}

// Observer interface
interface Observer {
    void update(double temperature, double humidity, double pressure);
}

// Concrete observer
class DisplayDevice implements Observer {
    private double temperature;
    private double humidity;
    private double pressure;

    @Override
    public void update(double temperature, double humidity, double pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }

    public void display() {
        System.out.println("Current conditions: Temperature = " + temperature + "C, Humidity = " + humidity + "%, Pressure = " + pressure + "hPa");
    }
}

public class ObserverDemo { // WeatherApp
    //  simple weather station application that notifies observers (display devices) whenever the weather conditions change
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();

        // Create display devices
        DisplayDevice display1 = new DisplayDevice();
        DisplayDevice display2 = new DisplayDevice();

        // Register display devices as observers
        // That is, subscribe them to the publisher
        weatherStation.registerObserver(display1);
        weatherStation.registerObserver(display2);

        // Simulate weather changes
        weatherStation.setMeasurements(25.0, 65.0, 1013.0);
        System.out.println();
        weatherStation.setMeasurements(28.0, 70.0, 1010.0);
    }
}
