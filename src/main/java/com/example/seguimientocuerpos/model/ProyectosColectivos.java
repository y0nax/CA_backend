package com.example.seguimientocuerpos.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document(value = "ProyectosColectivos")
@Data
public class ProyectosColectivos {
    @Id
    private String id;
    private String titulo;
    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;
    private List<String> integrantes;
    private String id_usuario;
    private String ca;
    private String path;
}
