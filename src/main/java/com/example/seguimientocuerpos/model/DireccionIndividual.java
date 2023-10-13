package com.example.seguimientocuerpos.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document(value = "DireccionIndividual")
@Data
public class DireccionIndividual {
    @Id
    private String id;
    private String nivel;
    private String titulo;
    private String nombre;
    private LocalDate fecha;
    private List<String> jurado;
    private String id_usuario;
    private String ca;
    private String path;
}
