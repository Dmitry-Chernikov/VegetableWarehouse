package ru.dmitry.VegetableWarehouse.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Id;
import java.io.Serializable;

@Getter
@Setter
public abstract class AbstractDto implements Serializable{
        @ApiModelProperty(value = "Ключ в таблице")
    private long id;

/*    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    LocalDateTime created;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    LocalDateTime updated;*/
}
