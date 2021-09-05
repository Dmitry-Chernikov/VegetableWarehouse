package ru.dmitry.VegetableWarehouse.model;

import lombok.*;
import javax.persistence.*;
import java.util.List;

/**
 * Поставщики склада
 */
@Entity
//@Table(name = "SYPPLIERS")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Suppliers extends BaseEntity{
        private static final long serialVersionUID = -4624970170178964461L;

        /**
         * Наименование поставщика
         */
        @Column(name = "suppliers_name", length = 50)
        private String name;

        /**
         * Код учётного номера плательщика УНП
         */
        @Column(name = "code_unp", length = 50)
        private String codeUNP;

        /**
         * Юридический адрес
         */
        @Column(name = "legal_address", length = 100)
        private String legalAddress;

        /**
         * Телефон
         */
        @Column(name = "telephone_number", length = 20)
        private String telephoneNumber;

        /**
         * Контактное лицо
         */
        @Column(name = "full_name", length = 50)
        private String fullName;

        /**
         * Должность
         */
        @Column(name = "working_position", length = 50)
        private String workingPosition;

        @OneToMany(mappedBy = "suppliers", fetch = FetchType.LAZY)
        private List<Purchase> purchases;

}
