package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CarTest {

    @Test
    public void testGetNumberOfDoors() {
        Car car = new Car.Builder()
                .setBrand("Toyota")
                .setModel("Camry")
                .setYear(2020)
                .setNumberOfDoors(4)
                .build();

        int numberOfDoors = car.getNumberOfDoors();
        Assert.assertEquals(numberOfDoors, 4);
    }

    @Test
    public void testToString() {
        Car car = new Car.Builder()
                .setBrand("Honda")
                .setModel("Civic")
                .setYear(2021)
                .setNumberOfDoors(2)
                .build();

        String expectedString = "Car{brand='Honda', model='Civic', year=2021, numberOfDoors=2}";
        String actualString = car.toString();
        Assert.assertEquals(actualString, expectedString);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testNegativeNumberOfDoors() {
        new Car.Builder()
                .setBrand("Ford")
                .setModel("Fiesta")
                .setYear(2019)
                .setNumberOfDoors(-2)
                .build();
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testNullBrand() {
        new Car.Builder()
                .setBrand(null)
                .setModel("Accord")
                .setYear(2018)
                .setNumberOfDoors(4)
                .build();
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testEmptyModel() {
        new Car.Builder()
                .setBrand("Chevrolet")
                .setModel("")
                .setYear(2022)
                .setNumberOfDoors(4)
                .build();
    }
}
