package com.example.bean;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;

@Data
@Accessors(chain = true)
public class User {

    @ApiModelProperty(name="id")
    @Min(value = 10,message = "id不能小于10")
    private Long id;

    @ApiModelProperty(name="名称")
    @Length(max = 30,min = 3,message = "名字不能少于3个字")
    private String name;


}
