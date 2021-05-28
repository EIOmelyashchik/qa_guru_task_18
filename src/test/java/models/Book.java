package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
//@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Book {
    private Long isbn;
    private String title;
    private String author;
    private Integer pages;
}
