package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ShipTest {

    @Test
    public void testGetShipType() {
        Ship ship = new Ship.Builder()
                .setBrand("Titanic")
                .setModel("Passenger Ship")
                .setYear(1912)
                .setShipType("Luxury")
                .build();
        String shipType = ship.getShipType();
        Assert.assertEquals(shipType, "Luxury");
    }

    @Test
    public void testToString() {
        Ship ship = new Ship.Builder()
                .setBrand("Queen Mary 2")
                .setModel("Cruise Ship")
                .setYear(2004)
                .setShipType("Luxury")
                .build();
        String expectedString = "Ship{brand='Queen Mary 2', model='Cruise Ship', year=2004, shipType='Luxury'}";
        String actualString = ship.toString();
        Assert.assertEquals(actualString, expectedString);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testNullShipType() {
        new Ship.Builder()
                .setBrand("Cargo Ship")
                .setModel("Bulk Carrier")
                .setYear(1998)
                .setShipType(null)
                .build();
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testEmptyShipType() {
        new Ship.Builder()
                .setBrand("Fishing Boat")
                .setModel("Small Boat")
                .setYear(2021)
                .setShipType("")
                .build();
    }
}
