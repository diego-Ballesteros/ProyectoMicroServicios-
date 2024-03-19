package edu.unimagdalena.demo.persistence.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MessageDto {
    @JsonProperty("idMessage")
    private Long id;

    @JsonProperty("creator")
    private String creator;

    @JsonProperty("content")
    private String content;


}
