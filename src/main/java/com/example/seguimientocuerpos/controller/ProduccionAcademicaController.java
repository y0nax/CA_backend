package com.example.seguimientocuerpos.controller;

import com.example.seguimientocuerpos.model.ProduccionAcademica;
import com.example.seguimientocuerpos.service.ProduccionAcademicaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ProduccionAcademicaController {

    private final ProduccionAcademicaService produccionAcademicaService;

    @PostMapping("/produccionAcademica")
    public void save (@RequestBody ProduccionAcademica produccionAcademica){
        produccionAcademicaService.save(produccionAcademica);
    }

    @GetMapping("/produccionAcademicas")
    public List<ProduccionAcademica> findAll(){
        return produccionAcademicaService.findAll();
    }

    @GetMapping("/produccionAcademica/{id}")
    public ProduccionAcademica findById(@PathVariable String id){
        return produccionAcademicaService.findById(id).get();
    }

    @DeleteMapping("/produccionAcademica/{id}")
    public void deleteById(@PathVariable String id){
        produccionAcademicaService.deleteById(id);
    }

    @PutMapping("/produccionAcademica")
    public void update(@RequestBody ProduccionAcademica produccionAcademica){
        produccionAcademicaService.save(produccionAcademica);
    }
}
