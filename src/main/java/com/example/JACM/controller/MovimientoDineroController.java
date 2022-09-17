package com.example.JACM.controller;

import com.example.JACM.model.Empresa;
import com.example.JACM.model.MovimientoDinero;
import com.example.JACM.service.EmpresaService;
import com.example.JACM.service.MovimientoDineroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovimientoDineroController {

    @Autowired
    MovimientoDineroService movimientoDineroService;




    @GetMapping("/transaction")
    private List<MovimientoDinero> verMovimientoDinero(){
        return movimientoDineroService.verMovimientoDinero();
    }


    @PostMapping("/transaction")
    private void crearMovimientoDinero(@RequestBody MovimientoDinero movimientoDinero){
        movimientoDineroService.crearYActualizarMovimientoDinero(movimientoDinero);
    }

    @DeleteMapping("/transaction/{id}")
    private void eliminarMovimientoDinero(@PathVariable("id") Long id){
        movimientoDineroService.eliminarMovimientoDinero(id);
    }

    @PutMapping("/transaction")
    private void editarMovimientoDinero(@RequestBody MovimientoDinero movimientoDinero){
        movimientoDineroService.crearYActualizarMovimientoDinero(movimientoDinero);
    }
}
