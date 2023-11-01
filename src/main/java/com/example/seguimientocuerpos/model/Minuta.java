package com.example.seguimientocuerpos.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(value = "Minuta")
@Data
public class Minuta {
    @Id
    private String id;
    private String tipo;
    private LocalDate fecha;
    private String idCa;
    private String path;
}
