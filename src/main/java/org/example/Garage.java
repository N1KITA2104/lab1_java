package org.example;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Garage {
    private final Map<Car, LocalDate> listCars;
    private final int capacity;

    public Garage(int capacity) {
        listCars = new HashMap<>();
        this.capacity = capacity;
    }

    public void addCar(Car car) {
        if (listCars.size() >= capacity) {
            throw new IllegalArgumentException("The garage is full. Cannot add more cars.");
        }

        listCars.put(car, LocalDate.now());
    }

    public void removeCar(Car car) {
        if (!listCars.containsKey(car)) {
            throw new IllegalArgumentException("Car not found in the garage.");
        }

        listCars.remove(car);
    }

    public Map<Car, LocalDate> getInformation() {
        return listCars;
    }
}
