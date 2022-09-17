package com.example.JACM.controller;

import com.example.JACM.model.Empresa;
import com.example.JACM.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpresaController {


    @Autowired
    EmpresaService empresaService;

    @GetMapping("/empresa")
    private List<Empresa> verEmpresa(){
        return empresaService.verEmpresa();
    }


    @PostMapping("/empresa")
    private void crearEmpresa(@RequestBody Empresa empresa){
        empresaService.crearYActualizarEmpresa(empresa);
    }

    @DeleteMapping("/empresa/{id}")
    private void eliminarEmpresa(@PathVariable("id") Long id){
        empresaService.eliminarEmpresa(id);
    }

    @PutMapping("/empresa")
    private void editarEmpresa(@RequestBody Empresa empresa){
        empresaService.crearYActualizarEmpresa(empresa);
    }

}
