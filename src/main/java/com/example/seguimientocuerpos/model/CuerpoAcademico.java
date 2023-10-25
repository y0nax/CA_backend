package com.example.seguimientocuerpos.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(value = "CuerpoAcademicio")
@Data
public class CuerpoAcademico {
    @Id
    private String id;
    private String nombre;
    private String descripcion;
    private String lineas;
    private String grado;
}
