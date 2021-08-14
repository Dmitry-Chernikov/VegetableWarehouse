package ru.dmitry.VegetableWarehouse.model;

//import ch.qos.logback.core.joran.spi.NoAutoStart;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
@NoArgsConstructor
@Getter
@Setter
public class BaseEntity implements Serializable {
            private static final long serialVersionUID = 1972709113480192104L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
}
