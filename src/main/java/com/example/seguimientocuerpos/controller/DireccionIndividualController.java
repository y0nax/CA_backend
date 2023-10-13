package com.example.seguimientocuerpos.controller;

import com.example.seguimientocuerpos.model.DireccionIndividual;
import com.example.seguimientocuerpos.service.DireccionIndividualService;
import lombok.RequiredArgsConstructor;
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

    @DeleteMapping("/direccionIndividual")
    public void deleteById(@PathVariable String id){
        direccionIndividualService.deleteById(id);
    }

    @PutMapping("/direccionIndividual")
    public void update(@RequestBody DireccionIndividual direccionIndividual){
        direccionIndividualService.save(direccionIndividual);
    }
}
