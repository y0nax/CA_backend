package com.example.seguimientocuerpos.controller;

import com.example.seguimientocuerpos.model.ProduccionAcademica;
import com.example.seguimientocuerpos.service.ProduccionAcademicaService;
import com.example.seguimientocuerpos.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ProduccionAcademicaController {

    private final ProduccionAcademicaService produccionAcademicaService;
    private final UsuarioService usuarioService;

    @PostMapping("/produccionAcademica")
    public void save (@RequestBody ProduccionAcademica produccionAcademica){
        produccionAcademicaService.save(produccionAcademica);
    }

    @GetMapping("/produccionAcademicas")
    public List<ProduccionAcademica> findAll(){
        return produccionAcademicaService.findAll();
    }

    @GetMapping("/produccionAcademicaT/{tipo}/{id_usuario}")
    public ResponseEntity<Object> findByTipo (@PathVariable String tipo,@PathVariable String id_usuario){
        List<ProduccionAcademica> filtro = new ArrayList<>();
        for(ProduccionAcademica p: produccionAcademicaService.findByTipo(tipo)){
            if(usuarioService.findById(id_usuario).get().getIdCa().equals(p.getIdCa()))
                filtro.add(p);
        }
        if(filtro.size()>0)
            return new ResponseEntity<>(filtro,HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/produccionAcademicaI/{id_usario}")
    public ResponseEntity<Object> findByIntegrantesIdUsuario(@PathVariable String id_usario){
        if(produccionAcademicaService.findByIntegrantesIdUsuario(id_usario).size()>0)
            return new ResponseEntity<>(produccionAcademicaService.findByIntegrantesIdUsuario(id_usario),HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/produccionAcademicaA/{anio}/{id_usuario}")
    public ResponseEntity<Object> findByFecha(@PathVariable String anio, @PathVariable String id_usuario){
        List<ProduccionAcademica> filtro = new ArrayList<>();
        if(produccionAcademicaService.findByAnio(anio).size()>0){
            for (ProduccionAcademica p: produccionAcademicaService.findByAnio(anio))
                if(usuarioService.findById(id_usuario).get().getIdCa().equals(p.getIdCa()))
                    filtro.add(p);

            if(filtro.size()>0)
                return new ResponseEntity<>(filtro,HttpStatus.OK);
            else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/produccionAcademica/{id}/{id_usuario}")
    public ResponseEntity<Object> deleteById(@PathVariable String id, @PathVariable String id_usuario){
        if(produccionAcademicaService.findById(id).get().getIdUsuario().equals(id_usuario)) {
            produccionAcademicaService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @PutMapping("/produccionAcademica/{id_usuario}")
    public ResponseEntity<Object> update(@RequestBody ProduccionAcademica produccionAcademica, @PathVariable String id_usuario){
        if(produccionAcademicaService.findById(produccionAcademica.getId()).get().getIdUsuario().equals(id_usuario)) {
            produccionAcademicaService.save(produccionAcademica);
            return new ResponseEntity<>(HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
}
