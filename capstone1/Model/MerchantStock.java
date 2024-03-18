package com.example.capstone1.Model;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class MerchantStock {


    @NotNull(message = "ID must be not empty")
    private Integer ID ;

    @NotNull(message = "product ID must be not empty")
    private Integer productID ;

    @NotNull(message = "merchant ID must be not empty")
    private Integer merchantID ;

    @NotNull(message = "stock must be not empty")
    @Min(value = 10 , message = "stock must be more than 10 at start")
    private Integer stock ;



}
