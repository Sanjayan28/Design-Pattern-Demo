/*
* Behavior pattern
Behavioral patterns concentrate on how objects interact and communicate with each other.
* Examples include: Observer Pattern:
*
* */


import java.util.ArrayList;
import java.util.List;

// Subject interface
interface WeatherStation {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
    void setTemperature(double temperature);
}

// Concrete Subject class
class WeatherData implements WeatherStation {
    private double temperature;
    private List<Observer> observers;

    // Constructor initializes the list of observers
    public WeatherData() {
        observers = new ArrayList<>();
    }

    // Adds an observer to the list
    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    // Removes an observer from the list
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    // Notifies all observers about the temperature change
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }

    // Sets the temperature and notifies observers
    @Override
    public void setTemperature(double temperature) {
        this.temperature = temperature;
        notifyObservers();
    }
}

// Observer interface
interface Observer {
    void update(double temperature);
}

// Concrete Observer class
class Display implements Observer {
    private String name;

    // Constructor initializes the display name
    public Display(String name) {
        this.name = name;
    }

    // Updates the display with the new temperature
    @Override
    public void update(double temperature) {
        System.out.println(name + " Display: Temperature is " + temperature);
    }
}

// Client class to test the observer pattern implementation
public class observerMain {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        Display display1 = new Display("Display 1");
        Display display2 = new Display("Display 2");

        // Adding observers
        weatherData.addObserver(display1);
        weatherData.addObserver(display2);

        // Changing the temperature
        weatherData.setTemperature(25.5);
        weatherData.setTemperature(30.0);

        // Removing an observer
        weatherData.removeObserver(display1);

        // Changing the temperature again
        weatherData.setTemperature(28.7);
    }
}