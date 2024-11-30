package classes;

import interfaces.DisplayElement;
import interfaces.Observer;
import interfaces.Subject;

public class StatisticsDisplay implements Observer, DisplayElement {
    private float maxTemperature = 0.0f;
	private float minTemperature = 200;
	private float temperatureSum= 0.0f;
	private int temperatureChangeCount;
    private Subject weatherData;

    public StatisticsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    public void update(float temperature, float humidity, float pressure) {
        maxTemperature = Math.max(maxTemperature, temperature);
        minTemperature = Math.min(minTemperature, temperature);
        temperatureSum += temperature;
        temperatureChangeCount++;
        display();
    }

    public void display() {
        System.out.println("Avg/Max/Min temperatures: " + (temperatureSum/temperatureChangeCount) + "/"+ maxTemperature + "/"+ minTemperature);
    }
}