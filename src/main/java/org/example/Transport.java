package org.example;

import java.util.Objects;

/**
 * The Transport class represents general information about a transportation vehicle.
 */
public class Transport {
    private final String brand;
    private final String model;
    private final double transportWeight;
    private final int productionYear;
    private final double price;

    /**
     * Constructs a new Transport object using the provided builder.
     *
     * @param builder The builder used to construct the Transport object.
     */
    public Transport(Builder builder) {
        this.brand = builder.brand;
        this.model = builder.model;
        this.transportWeight = builder.transportWeight;
        this.productionYear = builder.productionYear;
        this.price = builder.price;
    }

    /**
     * Get the brand of the transportation vehicle.
     *
     * @return The brand of the transportation vehicle.
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Get the model of the transportation vehicle.
     *
     * @return The model of the transportation vehicle.
     */
    public String getModel() {
        return model;
    }

    /**
     * Get the type of the transportation vehicle.
     *
     * @return The type of the transportation vehicle.
     */
    public double getWeight() {
        return transportWeight;
    }

    /**
     * Get the production year of the transportation vehicle.
     *
     * @return The production year of the transportation vehicle.
     */
    public int getProductionYear() {
        return productionYear;
    }

    /**
     * Get the price of the transportation vehicle.
     *
     * @return The price of the transportation vehicle.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Returns a string representation of the Transport object.
     *
     * @return A string representation of the Transport object.
     */
    @Override
    public String toString() {
        return "Transport{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", transportWeight='" + transportWeight + '\'' +
                ", year=" + productionYear +
                ", price=" + price +
                '}';
    }

    /**
     * Compares two Transport objects for equality.
     *
     * @param o The object to compare with.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transport transport = (Transport) o;
        return productionYear == transport.productionYear &&
                Double.compare(transport.price, price) == 0 &&
                brand.equals(transport.brand) &&
                model.equals(transport.model) &&
                Double.compare(transport.transportWeight, transportWeight) == 0;
    }

    /**
     * Returns the hash code of the Transport object.
     *
     * @return The hash code of the Transport object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(brand, model, productionYear, price, transportWeight);
    }

    /**
     * The Builder class for constructing a Transport object with parameters.
     */
    public static class Builder {
        private final String brand;
        private final String model;
        private final double transportWeight;
        private int productionYear;
        private double price;

        /**
         * Constructs a new Builder for creating a Transport object.
         *
         * @param brand        The brand of the transportation vehicle.
         * @param model        The model of the transportation vehicle.
         * @param transportWeight The type of the transportation vehicle.
         */
        public Builder(String brand, String model, double transportWeight) {
            if (brand == null || model == null || transportWeight <= 0) {
                throw new IllegalArgumentException("Brand, model, and transportType must not be null.");
            }
            this.brand = brand;
            this.model = model;
            this.transportWeight = transportWeight;
        }

        /**
         * Set the production year of the transportation vehicle.
         *
         * @param productionYear The production year to set.
         * @return The Builder object for method chaining.
         */
        public Builder setProductionYear(int productionYear) {
            if (productionYear < 0) {
                throw new IllegalArgumentException("Production year cannot be negative.");
            }
            this.productionYear = productionYear;
            return this;
        }

        /**
         * Set the price of the transportation vehicle.
         *
         * @param price The price to set.
         * @return The Builder object for method chaining.
         */
        public Builder setPrice(double price) {
            if (price < 0) {
                throw new IllegalArgumentException("Price cannot be negative.");
            }
            this.price = price;
            return this;
        }

        /**
         * Build a Transport object using the information provided in the Builder.
         *
         * @return A new Transport object.
         */
        public Transport build() {
            return new Transport(this);
        }
    }
}

