package ru.dmitry.VegetableWarehouse.dto;

import lombok.Data;

import java.io.Serializable;


@Data
public abstract class AbstractDto implements Serializable {

    private Long id;

/*    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    LocalDateTime created;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    LocalDateTime updated;*/
}
