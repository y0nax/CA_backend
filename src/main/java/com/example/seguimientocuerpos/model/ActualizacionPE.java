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
    private String fecha;
    private String area;
    private List<Integrantes> integrantes;
    private String idUsuario;
    private String idCa;
    private String path;
}
