package com.example.JACM.controller;

import com.example.JACM.model.Empleado;
import com.example.JACM.model.Empresa;
import com.example.JACM.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmpleadoController {

    @Autowired
    EmpleadoService empleadoService;

    /* Contoller Empleado para la BD Se Necesita @Rescontroller  */

    /*
    @PostMapping("/empleado")
    private void crearEmpleado(@RequestBody Empleado empleado) {
        empleadoService.crearYActualizarEmpleado(empleado);
    }

    @GetMapping("/lempleado")
    private List<Empleado> verEmpleado(){
        return empleadoService.verEmpleado();
    }

        @GetMapping("/empleado")
    public ResponseEntity<List<Empleado>>listarEmpleados(){
      return ResponseEntity.ok().body(this.empleadoService.ListarEmpleados());
    }

    @DeleteMapping("/empleado/{id}")
    private void eliminarEmpleado(@PathVariable("id") Long id){
        empleadoService.eliminarEmpleado(id);
    }

    @PutMapping("/empleado")
    private void editarEmpleado(@RequestBody Empleado empleado){
        empleadoService.crearYActualizarEmpleado(empleado);
    }

*/

/* Contoller Empleado para los Templates Se Necesita @Controller  */

    @GetMapping("/empleado")
    public String verEmpleados(Model model){
        model.addAttribute("empleados",empleadoService.verEmpleado());

        return "empleado";
    }


    @GetMapping("/agregar-empleado")
    private String verFormularioDeRegistroEmpleado(Empleado empleado){
        return "agregar-empleado";
    }

    @PostMapping("/empleado")
    private String crearEmpleado(Empleado empleado){
        empleadoService.crearYActualizarEmpleado(empleado);
        return "redirect:/empleado";
    }

    @GetMapping("empleado/borrar/{id}")
    private String eliminarEmpleado(@PathVariable("id") Long id){
        empleadoService.eliminarEmpleado(id);
        return "redirect:/empleado";
    }

    @GetMapping("/empleado/editar/{id}")
    private String verEmpleadoPorId(@PathVariable("id") Long id, Model model){
        Empleado empleado = empleadoService.verEmpleadoPorId(id);
        model.addAttribute("empleado", empleado);
        return "actualizar-empleado";
    }

    @PostMapping("/empleado/actualizar/{id}")
    private String editarEmpleado(@PathVariable("id") Long id, Empleado empleado){
        empleadoService.crearYActualizarEmpleado(empleado);
        return "redirect:/empleado";
    }


}/*end EmpleadoController */
