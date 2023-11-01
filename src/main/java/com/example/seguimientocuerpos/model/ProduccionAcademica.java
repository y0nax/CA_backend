package com.example.seguimientocuerpos.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(value = "ProduccionAcademica")
@Data
public class ProduccionAcademica {
    @Id
    private String id;
    private String tipo;
    private String titulo;
    private String fecha;
    private List<Integrantes> integrantes;
    private String idUsuario;
    private String idCa;
    private String path;
}
