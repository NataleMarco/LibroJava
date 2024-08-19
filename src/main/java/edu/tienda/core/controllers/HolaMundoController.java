package edu.tienda.core.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saludo")
public class HolaMundoController{

    @GetMapping("/hola/{nombre}")
    public String saludo(@PathVariable String nombre){
        return "hola " + nombre;
    }
}
