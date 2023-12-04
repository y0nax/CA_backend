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

    @GetMapping("/direccionIndividualA/{anio}")
    public ResponseEntity<Object> findByFecha(@PathVariable String anio){
        if(direccionIndividualService.findByAnio(anio).size()>0)
            return new ResponseEntity<>(direccionIndividualService.findByAnio(anio), HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/direccionIndividualN/{nivel}")
    public ResponseEntity<Object> findByNivel(@PathVariable String nivel){
        if(direccionIndividualService.findByNivel(nivel).size()>0)
            return new ResponseEntity<>(direccionIndividualService.findByNivel(nivel), HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/direccionIndividualI/{idCa}")
    public ResponseEntity<Object> findByIntegrantesCa(@PathVariable String idCa){
        if(direccionIndividualService.findByIdCa(idCa).size()>0)
            return new ResponseEntity<>(direccionIndividualService.findByIdCa(idCa), HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/direccionIndividual/{id}/{id_usuario}")
    public ResponseEntity<Object> deleteById(@PathVariable String id, @PathVariable String id_usuario){
        if(direccionIndividualService.findById(id).get().getIdUsuario().equals(id_usuario)){
            direccionIndividualService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @PutMapping("/direccionIndividual/{id_usuario}")
    public ResponseEntity<Object> update(@RequestBody DireccionIndividual direccionIndividual, @PathVariable String id_usuario){
        if(direccionIndividualService.findById(direccionIndividual.getId()).get().getIdUsuario().equals(id_usuario)){
            direccionIndividualService.save(direccionIndividual);
            return new ResponseEntity<>(HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
}
