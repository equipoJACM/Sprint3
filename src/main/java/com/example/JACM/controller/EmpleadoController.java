package com.example.JACM.controller;

import com.example.JACM.model.Empleado;
import com.example.JACM.model.Empresa;
import com.example.JACM.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpleadoController {

    @Autowired
    EmpleadoService empleadoService;

    @PostMapping("/empleado")
    private void crearEmpleado(@RequestBody Empleado empleado) {
        empleadoService.crearYActualizarEmpleado(empleado);
    }

    @GetMapping("/lempleado")
    private List<Empleado> verEmpleado(){
        return empleadoService.verEmpleado();
    }

    @DeleteMapping("/empleado/{id}")
    private void eliminarEmpleado(@PathVariable("id") Long id){
        empleadoService.eliminarEmpleado(id);
    }

    @PutMapping("/empleado")
    private void editarEmpleado(@RequestBody Empleado empleado){
        empleadoService.crearYActualizarEmpleado(empleado);
    }

    @GetMapping("/empleado")
    public ResponseEntity<List<Empleado>>listarEmpleados(){
      return ResponseEntity.ok().body(this.empleadoService.ListarEmpleados());
    }
}
