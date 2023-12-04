package com.example.seguimientocuerpos.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Comprobante {
    @Id
    private String id;
    private String idApoyo;
    private double monto;
    private String rubro;
    private String fecha;
    private String idUsuario;
    private String path;
}
