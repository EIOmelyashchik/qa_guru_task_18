package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Book {
    private Long isbn;
    private String title;
    private String author;
    private Integer pages;
}
