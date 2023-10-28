package com.example.seguimientocuerpos.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.List;

@Data
public class Comprobante {
    @Id
    private String id;
    private String id_apoyo;
    private double monto;
    private String rubro;
    private LocalDate fecha;
    private List<Integrantes> integrantes;
    private String path;
}
