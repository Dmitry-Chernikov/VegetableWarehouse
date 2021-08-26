package ru.dmitry.VegetableWarehouse.model;

import lombok.*;
import javax.persistence.*;

/**
 * Клиенты
 */

@Entity
//@Table(name = "clients")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Clients extends BaseEntity{
        private static final long serialVersionUID = 4923336868248054214L;

        /**
         * Наименование получателя
         */
        @Column(name = "clint_name", length = 50)
        private String nameClient;

        /**
         * Код учётного номера плательщика УНП
         */
        @Column(name = "code_unp", length = 50 )
        private String codeUNP;

        /**
         * Юридический адрес
         */
        @Column(name = "legal_address", length = 50)
        private String legalAddress;

        /**
         * Телефон
         */
        @Column(name = "telephone_Number", length = 50)
        private String telephoneNumber;

        /**
         * Контактное лицо
         */
        @Column(name = "full_name", length = 50)
        private String fullNameClient;

        /**
         * Должность
         */
        @Column(name = "working_position", length = 50)
        private String workingPosition;
}
