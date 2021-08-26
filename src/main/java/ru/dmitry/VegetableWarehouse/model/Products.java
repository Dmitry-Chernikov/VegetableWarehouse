package ru.dmitry.VegetableWarehouse.model;

import lombok.*;
import javax.persistence.*;

/**
 * Продукты
 */

@Entity
//@Table(name = "PRODUCTS")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Products extends BaseEntity{
        private static final long serialVersionUID = 1353555821748941084L;

        /**
         * Наименование продукта
         */
        @Column(name = "type_vegetable", unique = true, length = 50)
        private String nameTypeVegetable;

        /**
         * Клубниплоды
         * Studes,
         */

        /**
         * Корнеплоды
         * Roots,
         */

        /**
         * Капуста
         * Cabbage,
         */

        /**
         * Салаты
         * Salad,
         */

        /**
         * Пряные
         * Spicy,
         */

        /**
         * Луковые
         * Bulbous,
         */

        /**
         * Паслёновые
         * Parenic,
         */

        /**
         * Бахчевые
         * Bakhchy,
         */

        /**
         * Бобовые
         * Beans,
         */

        /**
         * Зерновые
         * Grain,
         */

        /**
         * Десертные
         * Dessert
         */
}
