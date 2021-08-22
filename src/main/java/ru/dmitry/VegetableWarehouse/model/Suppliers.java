package ru.dmitry.VegetableWarehouse.model;
import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Поставщики склада
 */
@Entity
@Table(name = "SYPPLIERS")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Suppliers extends BaseEntity{
    private static final long serialVersionUID = -4624970170178964461L;

    /**
     * Наименование поставщика
     */
    @Column(name = "Suppliers_Name")
    private String name;

    /**
     * Код учётного номера плательщика УНП
     */
    @Column(name = "Code_UNP")
    private String codeUNP;

    /**
     * Юридический адрес
     */
    @Column(name = "Legal_address")
    private String legalAddress;

    /**
     * Телефон
     */
    @Column(name = "Telephone_Number")
    private String telephoneNumber;

    /**
     * Контактное лицо
     */
    @Column(name = "Full_Name")
    private String fullName;

    /**
     * Должность
     */
    @Column(name = "Working_Position")
    private String workingPosition;

    @OneToMany
    private List<Purchase> purchaseList;

}
