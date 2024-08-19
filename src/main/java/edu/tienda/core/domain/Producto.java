package edu.tienda.core.domain;

import lombok.*;

@Data

public class Producto {
    private Integer id;
    private String nombre;
    private Double precio;
    private Integer stock;
}
