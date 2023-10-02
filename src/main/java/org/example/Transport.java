package org.example;

/**
 * Базовий клас для всіх видів транспорту.
 */
public class Transport {
    protected String brand;
    protected String model;
    protected int year;

    /**
     * Конструктор для класу Transport.
     *
     * @param brand бренд транспорту
     * @param model модель транспорту
     * @param year  рік виробництва
     */
    public Transport(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    /**
     * Повертає інформацію про транспорт у вигляді рядка.
     *
     * @return рядок з інформацією про транспорт
     */
    @Override
    public String toString() {
        return "Transport{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                '}';
    }

    /**
     * Порівнює два об'єкти Transport на рівність.
     *
     * @param o об'єкт, з яким порівнюється поточний об'єкт
     * @return true, якщо об'єкти рівні, інакше false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transport transport = (Transport) o;

        if (year != transport.year) return false;
        if (!brand.equals(transport.brand)) return false;
        return model.equals(transport.model);
    }

    /**
     * Повертає хеш-код об'єкта Transport.
     *
     * @return хеш-код об'єкта
     */
    @Override
    public int hashCode() {
        int result = brand.hashCode();
        result = 31 * result + model.hashCode();
        result = 31 * result + year;
        return result;
    }

    /**
     * Клас-білдер для створення об'єктів Transport.
     */
    public static class Builder {
        private String brand;
        private String model;
        private int year;

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
         * Побудова об'єкта Transport за допомогою Builder.
         *
         * @return новий об'єкт Transport з параметрами з Builder
         */
        public Transport build() {
            if (brand == null || model == null) {
                throw new IllegalStateException("Бренд і модель повинні бути встановлені");
            }
            return new Transport(brand, model, year);
        }
    }
}


