package org.example;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Garage {
    private final Map<Car, Date> carsList;
    private final int capacity;

    public Garage(int capacity) {
        carsList = new HashMap<>();
        this.capacity = capacity;
    }

    public void addCar(Car car) {
        if (carsList.size() >= capacity) {
            throw new IllegalArgumentException("The garage is full. Cannot add more cars.");
        }

        Date currentDate = new Date();
        carsList.put(car, currentDate);
    }

    public void removeCar(Car car) {
        if (!carsList.containsKey(car)) {
            throw new IllegalArgumentException("Car not found in the garage.");
        }

        carsList.remove(car);
    }

    public Map<Car, Date> getCarsInfo() {
        return carsList;
    }
}
