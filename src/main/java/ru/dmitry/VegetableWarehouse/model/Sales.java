package ru.dmitry.VegetableWarehouse.model;

import lombok.*;
import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

/**
 * Расходная накладная
 */
@Entity
//@Table(name = "SALES")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Sales extends BaseEntity{
        private static final long serialVersionUID = -4958131087059395614L;

        /**
         * Уникальный идентификатор расходной товарной наклодной
         */
        @Column(name = "barcode")
        private UUID barcode;

        /**
         * Имя товара
         */
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "base_products_id")
        private BaseProducts baseProducts;

        /**
         * Количество товара
         */
        @Column(name = "count_product")
        private double countProduct;

        /**
         * Наименование получателя
         */
        @Column(name = "name_client", length = 50)
        private String clientName;

        /**
         * ФИО прнинявшего клиента товар
         */
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "clients_id")
        private Clients clients;

        /**
         * ФИО сдавшего товар
         */
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "employee_id")
        private Employee employee;;

        /**
         * Дата расхода товара на склад
         */
        @Column(name = "date_operation")
        private Date operationDate;

        /**
         * Цена товара
         */
        @Column(name = "price_value")
        private double valuePrice;



}
