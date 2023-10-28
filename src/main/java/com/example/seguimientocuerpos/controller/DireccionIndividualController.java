package com.example.seguimientocuerpos.controller;

import com.example.seguimientocuerpos.model.DireccionIndividual;
import com.example.seguimientocuerpos.service.DireccionIndividualService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class DireccionIndividualController {

    private final DireccionIndividualService direccionIndividualService;

    @PostMapping("/direccionIndividual")
    public void save(@RequestBody DireccionIndividual direccionIndividual){
        direccionIndividualService.save(direccionIndividual);
    }

    @GetMapping("/direccionIndividuales")
    public List<DireccionIndividual> findAll(){
        return direccionIndividualService.findAll();
    }

    @GetMapping("/direccionIndividual/{id}")
    public DireccionIndividual findById(@PathVariable String id){
        return direccionIndividualService.findById(id).get();
    }

    @DeleteMapping("/direccionIndividual/{id}/{id_usuario}")
    public ResponseEntity<Object> deleteById(@PathVariable String id, @PathVariable String id_usuario){
        if(direccionIndividualService.findById(id).get().getId_usuario().equals(id_usuario)){
            direccionIndividualService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @PutMapping("/direccionIndividual/{id_usuario}")
    public ResponseEntity<Object> update(@RequestBody DireccionIndividual direccionIndividual, @PathVariable String id_usuario){
        if(direccionIndividualService.findById(direccionIndividual.getId()).get().getId_usuario().equals(id_usuario)){
            direccionIndividualService.save(direccionIndividual);
            return new ResponseEntity<>(HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
}
