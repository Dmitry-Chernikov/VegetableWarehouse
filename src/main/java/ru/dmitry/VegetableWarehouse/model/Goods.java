package ru.dmitry.VegetableWarehouse.model;

        import lombok.*;
        import javax.persistence.*;
        import java.util.Date;

/**
 * Товары
 */
@Entity
@Table(name = "GOODS")
//@Builder
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Goods extends BaseEntity{
    private static final long serialVersionUID = -935293741889753637L;

    /**
     * Наименование продукта
     */
    @ManyToOne
    @JoinColumn(name = "Production_FK")
    private Production productionName;

    /**
     * Наименование сорта
     */
    @Column(name = "Name_Variety")
    private String varietyName;

    /**
     * Годен до
     */
    @Column(name = "Fit_To")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fitTo;

    /**
     * Ед.изм
     */
    @ManyToOne
    @JoinColumn(name = "Unit_FK")
    private String unitName;

    /**
     * Наименование производителя
     */
    @Column(name = "Name_Manufacture")
    private String manufactureName;

    /**
     * Страна происхождения
     */
    @Column(name = "Couty_manufacture")
    private String manufactureCouty;
}
