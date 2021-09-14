package ru.dmitry.VegetableWarehouse.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.util.List;

/**
 * Список типов складов
 */
@Entity
@Data
public class TypeWarehouse extends BaseEntity{   
        private static final long serialVersionUID = 1353555820728941054L;
        
        /**
         * Наименование склада
         */
        @Column(name = "name_warehouse", length = 50)
        private String nameWarehouse;

        @OneToMany(mappedBy = "typeWarehouse", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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
