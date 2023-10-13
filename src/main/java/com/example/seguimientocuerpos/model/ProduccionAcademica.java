package com.example.seguimientocuerpos.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document(value = "ProduccionAcademica")
@Data
public class ProduccionAcademica {
    @Id
    private String id;
    private String tipo;
    private String titulo;
    private LocalDate fecha;
    private List<String> integrantes;
    private String path;
}
