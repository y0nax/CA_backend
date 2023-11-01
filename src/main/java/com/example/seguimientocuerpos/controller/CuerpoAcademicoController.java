package com.example.seguimientocuerpos.controller;

import com.example.seguimientocuerpos.model.CuerpoAcademico;
import com.example.seguimientocuerpos.service.CuerpoAcademicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class CuerpoAcademicoController {

    private final CuerpoAcademicoService cuerpoAcademicoService;

    @PostMapping("/cuerpoAcademico")
    public void save(@RequestBody CuerpoAcademico cuerpoAcademico){
        cuerpoAcademicoService.save(cuerpoAcademico);
    }

    @GetMapping("/cuerpoAcademicos")
    public List<CuerpoAcademico> findAll(){
        return cuerpoAcademicoService.findAll();
    }

    @GetMapping("/cuerpoAcademico/{id}")
    public CuerpoAcademico findById(@PathVariable String id){
        return cuerpoAcademicoService.findById(id).get();
    }

    @DeleteMapping("/cuerpoAcademico/{id}")
    public void deleteById(@PathVariable String id){
        cuerpoAcademicoService.deleteById(id);
    }

    @PutMapping("/cuerpoAcademico")
    public void update(@RequestBody CuerpoAcademico cuerpoAcademico){
        cuerpoAcademicoService.save(cuerpoAcademico);
    }
}
