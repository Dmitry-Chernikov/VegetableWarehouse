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
                @Column(name = "barcode")
                private UUID barcode;
         */


        /**
         * Имя товара
         */
        @Column(name = "base_products_fk")
        private long productsBase;

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
        @Column(name = "clients_fk")
        private long clientFullName;

        /**
         * ФИО сдавшего товар
         */
        @Column(name = "employee_fk")
        private long employeeSalesFullName;

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
