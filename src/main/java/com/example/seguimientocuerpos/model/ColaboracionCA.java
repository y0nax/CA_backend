package com.example.seguimientocuerpos.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document(value = "ColaboracionCA")
@Data
public class ColaboracionCA {
    @Id
    private String id;
    private String tipo;
    private String titulo;
    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;
    private List<Integrantes> integrantes;
    private String path;
}