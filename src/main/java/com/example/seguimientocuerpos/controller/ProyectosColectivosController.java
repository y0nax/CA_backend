package com.example.seguimientocuerpos.controller;

import com.example.seguimientocuerpos.model.ProyectosColectivos;
import com.example.seguimientocuerpos.service.ProyectosColectivosService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @DeleteMapping("/proyectoColectivo/{id}/{id_usuario}")
    public ResponseEntity<Object> deleteById(@PathVariable String id, @PathVariable String id_usuario){
        if(proyectosColectivosService.findById(id).get().getId_usuario().equals(id_usuario)){
            proyectosColectivosService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @PutMapping("/proyectoColectivo/{id_usuario}")
    public ResponseEntity<Object> update(@RequestBody ProyectosColectivos proyectosColectivos, @PathVariable String id_usuario){
        if(proyectosColectivosService.findById(proyectosColectivos.getId()).get().getId_usuario().equals(id_usuario)){
            proyectosColectivosService.save(proyectosColectivos);
            return new ResponseEntity<>(HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
}
