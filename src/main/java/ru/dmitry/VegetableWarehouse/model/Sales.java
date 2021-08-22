package ru.dmitry.VegetableWarehouse.model;

import lombok.*;
import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Расходная накладная
 */
@Entity
@Table(name = "SALES")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Sales extends BaseEntity{
            private static final long serialVersionUID = -4958131087059395614L;


    /**
     * Уникальный идентификатор расходной товарной наклодной
     */
    @Column(name = "Purchase_ID_TT")
    private UUID barcode;

    /**
     * Имя товара
     */
    @OneToOne
    @JoinColumn(name = "Name_Goods_FK")
    private ProductsBase nameGoodsSales;

    /**
     * Количество товара
     */
    @Column(name = "Count_Product")
    private double countProduct;

    /**
     * Наименование получателя
     */
    @Column(name = "Name_Client")
    private String clientName;

    /**
     * ФИО прнинявшего клиента товар
     */
    @ManyToOne
    @JoinColumn(name = "Full_Name_Client_FK")
    private Clients clientFullName;

    /**
     * ФИО сдавшего товар
     */
    @ManyToOne
    @JoinColumn(name = "Full_Name_Employee_FK")
    private Employee employeeFullName;

    /**
     * Дата расхода товара на склад
     */
    @Column(name = "Date_Operation")
    private Date operationDate;

    /**
     * Цена товара
     */
    @Column(name = "Price_Value")
    private double valuePrice;
}
