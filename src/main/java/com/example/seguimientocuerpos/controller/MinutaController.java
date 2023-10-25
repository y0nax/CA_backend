package com.example.seguimientocuerpos.controller;

import com.example.seguimientocuerpos.model.Minuta;
import com.example.seguimientocuerpos.service.MinutaService;
import com.example.seguimientocuerpos.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class MinutaController {

    private final MinutaService minutaService;
    private final UsuarioService usuarioService;

    @PostMapping("/minuta")
    public void save(@RequestBody Minuta minuta){
        minutaService.save(minuta);
    }

    @GetMapping("/minutas")
    public List<Minuta> findAll(){
        return minutaService.findAll();
    }

    @GetMapping("/minuta/{id}")
    public Minuta findById(@PathVariable String id){
        return minutaService.findById(id).get();
    }

    @DeleteMapping("/minuta/{id}/{id_usuario}")
    public ResponseEntity<Object> deleteById (@PathVariable String id, @PathVariable String id_usuario){
        if(usuarioService.findById(id_usuario).get().getRol().equals("LIDER")) {
            minutaService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
}
