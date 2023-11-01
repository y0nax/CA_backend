package com.example.seguimientocuerpos.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "Usuario")
@Data
public class Usuario {
    @Id
    private String id;
    private String contraseña;
    private String nombre;
    private String rol;
    private String idCa;
}
