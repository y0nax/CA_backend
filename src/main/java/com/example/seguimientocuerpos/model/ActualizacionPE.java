package com.example.seguimientocuerpos.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document(value = "ActualizacionPE")
@Data
public class ActualizacionPE {
    @Id
    private String id;
    private String nivel;
    private String materia;
    private String clave;
    private LocalDate fecha;
    private String area;
    private List<String> integrantes;
    private String id_usuario;
    private String ca;
    private String path;
}