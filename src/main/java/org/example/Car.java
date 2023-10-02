package org.example;

public class Car extends Transport {
    private int numberOfDoors;

    private Car(String brand, String model, int year, int numberOfDoors) {
        super(brand, model, year);
        this.numberOfDoors = numberOfDoors;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", numberOfDoors=" + numberOfDoors +
                '}';
    }

    /**
     * Клас-білдер для створення об'єктів Car.
     */
    public static class Builder {
        private String brand;
        private String model;
        private int year;
        private int numberOfDoors;

        /**
         * Встановлює бренд транспорту.
         *
         * @param brand бренд транспорту
         * @return посилання на поточний об'єкт Builder
         */
        public Builder setBrand(String brand) {
            if (brand == null || brand.isEmpty()) {
                throw new IllegalArgumentException("Бренд не може бути пустим");
            }
            this.brand = brand;
            return this;
        }

        /**
         * Встановлює модель транспорту.
         *
         * @param model модель транспорту
         * @return посилання на поточний об'єкт Builder
         */
        public Builder setModel(String model) {
            if (model == null || model.isEmpty()) {
                throw new IllegalArgumentException("Модель не може бути пустою");
            }
            this.model = model;
            return this;
        }

        /**
         * Встановлює рік виробництва транспорту.
         *
         * @param year рік виробництва
         * @return посилання на поточний об'єкт Builder
         */
        public Builder setYear(int year) {
            if (year < 0) {
                throw new IllegalArgumentException("Рік не може бути від'ємним");
            }
            this.year = year;
            return this;
        }

        /**
         * Встановлює кількість дверей автомобіля.
         *
         * @param numberOfDoors кількість дверей
         * @return посилання на поточний об'єкт Builder
         */
        public Builder setNumberOfDoors(int numberOfDoors) {
            if (numberOfDoors < 0) {
                throw new IllegalArgumentException("Кількість дверей не може бути від'ємною");
            }
            this.numberOfDoors = numberOfDoors;
            return this;
        }

        /**
         * Побудова об'єкта Car за допомогою Builder.
         *
         * @return новий об'єкт Car з параметрами з Builder
         */
        public Car build() {
            if (brand == null || model == null) {
                throw new IllegalStateException("Бренд і модель повинні бути встановлені");
            }
            return new Car(brand, model, year, numberOfDoors);
        }
    }
}
