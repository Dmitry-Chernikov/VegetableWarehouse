package ru.dmitry.VegetableWarehouse.model;

import lombok.*;
import javax.persistence.*;

/**
 * Продукты
 */

@Entity
@Table(name = "PRODUCTION")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Production extends BaseEntity{
            private static final long serialVersionUID = 1353555821748941084L;
    
     /**
     * Наименование продукта
     */
    @Column(name = "Name_Production")
    private String nameProduction; 
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
