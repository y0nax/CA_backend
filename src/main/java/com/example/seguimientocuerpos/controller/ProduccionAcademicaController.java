package com.example.seguimientocuerpos.controller;

import com.example.seguimientocuerpos.model.ProduccionAcademica;
import com.example.seguimientocuerpos.service.ProduccionAcademicaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @DeleteMapping("/produccionAcademica/{id}/{id_usuario}")
    public ResponseEntity<Object> deleteById(@PathVariable String id, @PathVariable String id_usuario){
        if(produccionAcademicaService.findById(id).get().getId_usuario().equals(id_usuario)) {
            produccionAcademicaService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @PutMapping("/produccionAcademica/{id_usuario}")
    public ResponseEntity<Object> update(@RequestBody ProduccionAcademica produccionAcademica, @PathVariable String id_usuario){
        if(produccionAcademicaService.findById(produccionAcademica.getId()).get().getId_usuario().equals(id_usuario)) {
            produccionAcademicaService.save(produccionAcademica);
            return new ResponseEntity<>(HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
}
