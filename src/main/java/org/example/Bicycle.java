package org.example;

public class Bicycle extends Transport {
    private int numberOfGears;

    private Bicycle(String brand, String model, int year, int numberOfGears) {
        super(brand, model, year);
        this.numberOfGears = numberOfGears;
    }

    public int getNumberOfGears() {
        return numberOfGears;
    }

    @Override
    public String toString() {
        return "Bicycle{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", numberOfGears=" + numberOfGears +
                '}';
    }

    /**
     * Клас-білдер для створення об'єктів Bicycle.
     */
    public static class Builder {
        private String brand;
        private String model;
        private int year;
        private int numberOfGears;

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
         * Встановлює кількість передач у велосипеда.
         *
         * @param numberOfGears кількість передач
         * @return посилання на поточний об'єкт Builder
         */
        public Builder setNumberOfGears(int numberOfGears) {
            if (numberOfGears < 0) {
                throw new IllegalArgumentException("Кількість передач не може бути від'ємною");
            }
            this.numberOfGears = numberOfGears;
            return this;
        }

        /**
         * Побудова об'єкта Bicycle за допомогою Builder.
         *
         * @return новий об'єкт Bicycle з параметрами з Builder
         */
        public Bicycle build() {
            if (brand == null || model == null) {
                throw new IllegalStateException("Бренд і модель повинні бути встановлені");
            }
            return new Bicycle(brand, model, year, numberOfGears);
        }
    }
}
