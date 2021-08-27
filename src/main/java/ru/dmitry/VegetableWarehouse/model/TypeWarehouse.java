package ru.dmitry.VegetableWarehouse.model;

import lombok.*;
import javax.persistence.*;
import java.util.List;

/**
 * Список типов складов
 */
@Entity
//@Table(name = "WAREHOUSE")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class TypeWarehouse extends BaseEntity{   
        private static final long serialVersionUID = 1353555820728941054L;
        
        /**
         * Наименование склада
         */
        @Column(name = "name_warehouse", length = 50)
        private String nameWarehouse;

        @OneToMany
        @JoinColumn(name = "type_warehouse_id")
        private List<BaseProducts> baseProductses;

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
