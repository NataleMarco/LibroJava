package edu.tienda.core.configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Getter
@Setter

@Configuration
@ConfigurationProperties(prefix = "app")
public class ConfigurationParameters{
    private String nombre;
    private String pais;
    private String author;
    private String lenguaje;

    public String toString(){
        return "ConfigurationParameters{" + 
        "nombre ='" + nombre + '\'' +
        ", pais  ='" + pais + '\'' +
        ", author ='" + author + '\'' +
        ", lenguaje  ='" + lenguaje + '\'' +
        '}';
    }

}
