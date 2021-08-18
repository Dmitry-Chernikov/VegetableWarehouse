package ru.dmitry.VegetableWarehouse.model;

import lombok.*;
import javax.persistence.*;

/**
 * Список типов складов
 */
@Entity
@Table(name = "WAREHOUSE")
//@Builder
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class TypeWarehouse extends BaseEntity{   
            private static final long serialVersionUID = 1353555820728941054L;
    /**
     * Наименование склада
     */
    @Column(name = "Name_Warehouse")
    private String nameWarehouse;
    
    /**
     * Хранилище силосного типа
     * Silage,
     */
    
    /**
     * Хранилище ангарнойго типа
     * Hangar,
     */
    
    /**
     * Хранилище подвального типа
     *Cellar
     */    
}
