package com.example.seguimientocuerpos.controller;

import com.example.seguimientocuerpos.model.ProyectosColectivos;
import com.example.seguimientocuerpos.service.ProyectosColectivosService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ProyectosColectivosController {

    private final ProyectosColectivosService proyectosColectivosService;

    @PostMapping("/proyectoColectivo")
    public void save(@RequestBody ProyectosColectivos proyectosColectivos){
        proyectosColectivosService.save(proyectosColectivos);
    }

    @GetMapping("/proyectoColectivos")
    public List<ProyectosColectivos> findAll(){
        return proyectosColectivosService.findAll();
    }

    @GetMapping("/proyectoColectivo/{id}")
    public ProyectosColectivos findById(@PathVariable String id){
        return proyectosColectivosService.findById(id).get();
    }

    @DeleteMapping("/proyectoColectivo/{id}")
    public void deleteById(@PathVariable String id){
        proyectosColectivosService.deleteById(id);
    }

    @PutMapping("/proyectoColectivo")
    public void update(@RequestBody ProyectosColectivos proyectosColectivos){
        proyectosColectivosService.save(proyectosColectivos);
    }
}
