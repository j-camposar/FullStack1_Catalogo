package com.catalogo.catalogo.Model;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Catalogo {
    private int id;
    @NotBlank(message = "No puede ir nombre en blanco")
    private String nombre;
    @Min(value = 1, message = "El precio no puede ser menor a 1")
    private int price;
    @NotNull(message = "La categoria no puede ser nula")
    private String categoria;
} 
