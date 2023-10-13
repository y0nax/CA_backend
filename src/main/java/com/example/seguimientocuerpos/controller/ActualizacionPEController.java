package com.example.seguimientocuerpos.controller;

import com.example.seguimientocuerpos.model.ActualizacionPE;
import com.example.seguimientocuerpos.service.ActualizacionPEService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ActualizacionPEController {

    private final ActualizacionPEService actualizacionPEService;

    @PostMapping("/actualizacionPE")
    public void save(@RequestBody ActualizacionPE actualizacionPE){
        actualizacionPEService.save(actualizacionPE);
    }

    @GetMapping("/actualizacionPEs")
    public List<ActualizacionPE> findAll(){
        return actualizacionPEService.findAll();
    }

    @GetMapping("/actualizacionPE/{id}")
    public ActualizacionPE findById(@PathVariable String id){
        return actualizacionPEService.findById(id).get();
    }

    @DeleteMapping("/actualizacionPE/{id}")
    public void deleteById(@PathVariable String id){
        actualizacionPEService.deleteById(id);
    }

    @PutMapping("/actualizacionPE")
    public void update(@RequestBody ActualizacionPE actualizacionPE){
        actualizacionPEService.save(actualizacionPE);
    }
}
