package com.example.seguimientocuerpos.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(value = "ApoyoEconomico")
@Data
public class ApoyoEconomico {
    @Id
    private String id;
    private double montoTotal;
    private String periodoInicio;
    private String periodoFin;
    private List<IntegranteMonto> montoUsuario;
    private List<Comprobante> comprobanteList;
    private String idCa;
    private String idUsuario;
}
