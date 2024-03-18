package com.example.capstone1.Model;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {


    @NotNull(message = "ID must be not empty")
    private Integer ID ;

    @NotEmpty(message = "username must be not empty")
    @Size(min = 5 , message = "username must be more then 5 length long")
    private String username ;

    @NotEmpty(message = "password must be not empty")
    @Size(min = 6 , message = "password must be more then 6 length long" )
//    @Pattern(regexp = "^[A-Za-z0-9]$" , message = "password must have characters and digits")
    private String password ;

    @NotEmpty(message = "email must be not empty")
    @Email(message = "must be valid email")
    private String email ;

    @NotEmpty(message = "role must be not empty")
    @Pattern(regexp = "^(Admin|Customer)$" , message = "role have to be in Admin, Customer")
    private String role ;

    @NotNull(message = "balance must be not empty")
    @Positive(message = "balance must be positive number")
    private Integer balance ;



}
