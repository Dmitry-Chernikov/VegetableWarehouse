package ru.dmitry.VegetableWarehouse.model;

import lombok.*;
import javax.persistence.*;
import java.util.List;

/**
 * Продукты
 */

@Entity
@Getter
@Setter
public class Products extends BaseEntity{

        private static final long serialVersionUID = 1353555821748941084L;
        /**
         * Наименование продукта
         */
        @Column(name = "type_vegetable", length = 50)
        private String nameTypeVegetable;

        @OneToMany(mappedBy = "products", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        private List<Goods> goodses;

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
