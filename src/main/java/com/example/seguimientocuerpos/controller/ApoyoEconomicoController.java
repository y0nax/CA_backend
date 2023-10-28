package com.example.seguimientocuerpos.controller;

import com.example.seguimientocuerpos.model.ApoyoEconomico;
import com.example.seguimientocuerpos.service.ApoyoEconomicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ApoyoEconomicoController {

    private final ApoyoEconomicoService apoyoEconomicoService;

    @PostMapping("/apoyoEconomico")
    public void save(@RequestBody ApoyoEconomico apoyoEconomico){
        apoyoEconomicoService.save(apoyoEconomico);
    }

    @GetMapping("/apoyoEconomicos")
    public List<ApoyoEconomico> findAll(){
        return apoyoEconomicoService.findAll();
    }

    @GetMapping("/apoyoEconomico/{id}")
    public ApoyoEconomico findById(@PathVariable String id){
        return apoyoEconomicoService.findById(id).get();
    }

    @DeleteMapping("/apoyoEconomico/{id}/{id_usuario}")
    public ResponseEntity<Object> deleteById(@PathVariable String id, @PathVariable String id_usuario){
        if(apoyoEconomicoService.findById(id).get().getId_usuario().equals(id_usuario)){
            apoyoEconomicoService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @PutMapping("/apoyoEconomico/{id_usuario}")
    public ResponseEntity<Object> update(@RequestBody ApoyoEconomico apoyoEconomico, @PathVariable String id_usuario){
        if(apoyoEconomicoService.findById(apoyoEconomico.getId()).get().getId_usuario().equals(id_usuario)){
            apoyoEconomicoService.save(apoyoEconomico);
            return new ResponseEntity<>(HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
}
