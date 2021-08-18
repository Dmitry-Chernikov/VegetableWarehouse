package ru.dmitry.VegetableWarehouse.model;
import lombok.*;
import javax.persistence.*;
import java.util.UUID;

/**
 * База всех продуктов
 */
@Entity
@Table(name = "BASE")
//@Builder
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ProductsBase extends BaseEntity{
    private static final long serialVersionUID = -4265266289869875308L;

    /**
     * Уникальный идентификатор товара в базе штрих код
     */
    @Column(name = "Barcode")
    private UUID barcode;

    /**
     * Имя типа склада где храниться товар
     */
    @ManyToOne
    @JoinColumn(name = "Warehouse")
    private TypeWarehouse warehouseName;

    /**
     * Имя товара
     */
    @ManyToOne
    @JoinColumn(name = "Name_Goods_FK")
    private Goods goodsName;
}
