package com.example.seguimientocuerpos.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(value = "Minuta")
@Data
public class Minuta {
    @Id
    private String id;
    private String tipo;
    private Date fecha;
    private String path;
}
