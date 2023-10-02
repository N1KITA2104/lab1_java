package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BicycleTest {

    @Test
    public void testGetNumberOfGears() {
        Bicycle bicycle = new Bicycle.Builder()
                .setBrand("Trek")
                .setModel("Mountain Bike")
                .setYear(2022)
                .setNumberOfGears(21)
                .build();

        int numberOfGears = bicycle.getNumberOfGears();
        Assert.assertEquals(numberOfGears, 21);
    }

    @Test
    public void testToString() {
        Bicycle bicycle = new Bicycle.Builder()
                .setBrand("Giant")
                .setModel("Road Bike")
                .setYear(2021)
                .setNumberOfGears(18)
                .build();

        String expectedString = "Bicycle{brand='Giant', model='Road Bike', year=2021, numberOfGears=18}";
        String actualString = bicycle.toString();
        Assert.assertEquals(actualString, expectedString);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testNegativeNumberOfGears() {
        new Bicycle.Builder()
                .setBrand("Schwinn")
                .setModel("Cruiser")
                .setYear(2020)
                .setNumberOfGears(-3)
                .build();
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testNullBrand() {
        new Bicycle.Builder()
                .setBrand(null)
                .setModel("Hybrid Bike")
                .setYear(2019)
                .setNumberOfGears(7)
                .build();
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testEmptyModel() {
        new Bicycle.Builder()
                .setBrand("Specialized")
                .setModel("")
                .setYear(2022)
                .setNumberOfGears(24)
                .build();
    }
}
