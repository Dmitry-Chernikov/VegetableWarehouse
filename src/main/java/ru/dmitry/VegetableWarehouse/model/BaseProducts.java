package ru.dmitry.VegetableWarehouse.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

/**
 * База всех продуктов
 */
@Table(name = "BaseProducts")
@Entity
//@Table(name = "PRODUCTS BASE")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BaseProducts extends BaseEntity{
        private static final long serialVersionUID = -4265266289869875308L;

        /**
         * Уникальный идентификатор товара в базе штрих код
         */
        @Column(name = "barcode")
        private UUID barcode;

        /**
         * Имя типа склада где храниться товар
         */
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "type_warehouse_id")
        private TypeWarehouse typeWarehouse;

        /**
         * Имя товара
         */
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "goods_id")
        private Goods goods;

        @OneToMany(mappedBy = "baseProducts", fetch = FetchType.LAZY)
        private List<Sales> saleses;

}
