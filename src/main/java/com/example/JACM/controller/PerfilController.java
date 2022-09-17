package com.example.JACM.controller;

import com.example.JACM.model.MovimientoDinero;
import com.example.JACM.model.Perfil;
import com.example.JACM.service.PerfilServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PerfilController {

    @Autowired
    PerfilServices perfilServices;


    @GetMapping("/perfil")
    private List<Perfil> verMovimientoPerfil(){
        return perfilServices.verPerfil();
    }


    @PostMapping("/perfil")
    private void crearMovimientoPerfil(@RequestBody Perfil perfil){
        perfilServices.crearYActualizarPerfil(perfil);
    }

    @DeleteMapping("/perfil/{id}")
    private void eliminarMovimientoPerfil(@PathVariable("id") Long id){
        perfilServices.eliminarPerfil(id);
    }

    @PutMapping("/perfil")
    private void editarMovimientoPerfil(@RequestBody Perfil perfil){
        perfilServices.crearYActualizarPerfil(perfil);
    }
}
