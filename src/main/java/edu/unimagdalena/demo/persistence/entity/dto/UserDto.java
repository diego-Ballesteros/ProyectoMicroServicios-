package edu.unimagdalena.demo.persistence.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserDto {

    @JsonProperty("User Name")
    private String userName;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Last Name")
    private String lastName;

    @JsonProperty("Email")
    private String email;

    @JsonProperty("Age")
    private Integer age;

    @JsonProperty("Photo")
    private Integer photo;

    @JsonProperty("Rol")
    private Integer rol;


}
