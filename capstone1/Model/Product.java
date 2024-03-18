package com.example.capstone1.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {



    @NotNull(message = "Id must be not empty ")
    private Integer ID ;

    @NotEmpty(message = "name must be not empty")
    @Size(min = 3 , message = "name must be more than 3 char")
    private String name ;

    @NotNull(message = "price must be not empty")
    @Positive(message = "price must be positive number")
    private Integer price ;

    @NotNull(message = "category ID must be not empty")
    private Integer categoryID ;


}
