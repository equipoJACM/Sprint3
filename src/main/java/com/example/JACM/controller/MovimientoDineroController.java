package com.example.JACM.controller;

import com.example.JACM.model.Empresa;
import com.example.JACM.model.MovimientoDinero;
import com.example.JACM.service.EmpresaService;
import com.example.JACM.service.MovimientoDineroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MovimientoDineroController {

    @Autowired
    MovimientoDineroService movimientoDineroService;



/*
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

 */

    /* Contoller Empresa para los Templates Se Necesita @Controller  */

    @GetMapping("/movimientoDinero")
    public String verMovimientoDinero(Model model){
        model.addAttribute("movimientoDineros",movimientoDineroService.verMovimientoDinero());

        return "movimientoDinero";
    }


    @GetMapping("/agregar-movimientoDinero")
    private String verFormularioDeRegistroMovimientoDinero(MovimientoDinero movimientoDinero){
        return "agregar-movimientoDinero";
    }

    @PostMapping("/movimientoDinero")
    private String crearMovimientoDinero(MovimientoDinero movimientoDinero){
        movimientoDineroService.crearYActualizarMovimientoDinero(movimientoDinero);
        return "redirect:/movimientoDinero";
    }

    @GetMapping("movimientoDinero/borrar/{id}")
    private String eliminarMovimientoDinero(@PathVariable("id") Long id){
        movimientoDineroService.eliminarMovimientoDinero(id);
        return "redirect:/movimientoDinero";
    }

    @GetMapping("/movimientoDinero/editar/{id}")
    private String verMovimientoDineroPorId(@PathVariable("id") Long id, Model model){
        MovimientoDinero movimientoDinero = movimientoDineroService.verMovimientoDineroPorId(id);
        model.addAttribute("movimientoDinero", movimientoDinero);
        return "actualizar-movimientoDinero";
    }

    @PostMapping("/movimientoDinero/actualizar/{id}")
    private String editarMovimientoDinero(@PathVariable("id") Long id, MovimientoDinero movimientoDinero){
        movimientoDineroService.crearYActualizarMovimientoDinero(movimientoDinero);
        return "redirect:/movimientoDinero";
    }
}
