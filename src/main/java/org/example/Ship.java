package org.example;

public class Ship extends Transport {
    private String shipType;

    public Ship(String brand, String model, int year, String shipType) {
        super(brand, model, year);
        if (shipType == null || shipType.isEmpty()) {
            throw new IllegalArgumentException("Тип корабля не може бути пустим");
        }
        this.shipType = shipType;
    }

    public String getShipType() {
        return shipType;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", shipType='" + shipType + '\'' +
                '}';
    }

    /**
     * Клас-білдер для створення об'єктів Ship.
     */
    public static class Builder {
        private String brand;
        private String model;
        private int year;
        private String shipType;

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
         * Встановлює тип корабля.
         *
         * @param shipType тип корабля
         * @return посилання на поточний об'єкт Builder
         */
        public Builder setShipType(String shipType) {
            if (shipType == null || shipType.isEmpty()) {
                throw new IllegalArgumentException("Тип корабля не може бути пустим");
            }
            this.shipType = shipType;
            return this;
        }

        /**
         * Побудова об'єкта Ship за допомогою Builder.
         *
         * @return новий об'єкт Ship з параметрами з Builder
         */
        public Ship build() {
            if (brand == null || model == null || shipType == null) {
                throw new IllegalStateException("Бренд, модель і тип корабля повинні бути встановлені");
            }
            return new Ship(brand, model, year, shipType);
        }
    }

}
