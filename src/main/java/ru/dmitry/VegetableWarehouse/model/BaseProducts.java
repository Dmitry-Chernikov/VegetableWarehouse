package ru.dmitry.VegetableWarehouse.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.UUID;

/**
 * База всех продуктов
 */

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class BaseProducts extends BaseEntity{
        private static final long serialVersionUID = -4265266289869875308L;

        /**
         * Уникальный идентификатор товара в базе штрих код
         */
        @Column(name = "barcode")
        private String barcode = UUID.randomUUID().toString();

        /**
         * Имя типа склада, где храниться товар
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

        @OneToMany(mappedBy = "baseProducts", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        private List<Sales> saleses;

        @OneToMany(mappedBy = "baseProducts", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        private List<Purchase> purchases;

}
