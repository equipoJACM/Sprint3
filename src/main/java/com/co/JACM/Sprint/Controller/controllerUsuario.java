package com.co.JACM.Sprint.Controller;

import com.co.JACM.Sprint.Entitys.Empleado;
import com.co.JACM.Sprint.Entitys.Empresa;
import com.co.JACM.Sprint.Service.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value="JACM")
public class controllerUsuario {
    @Autowired
    ServicioUsuario SU;
    Empleado empleado;

    @GetMapping(path="/users", produces= MediaType.ALL_VALUE)
    public ResponseEntity<String> mensaje(){
        String msj = "2do responseEntity";
        return new ResponseEntity<String>(msj, HttpStatus.OK);
    }
    @PostMapping(path="/users", produces= MediaType.ALL_VALUE,
            consumes = MediaType.ALL_VALUE)
    public ResponseEntity<String> m1(@RequestBody String msj){
        String nMsj = msj + " Hola mundo";
        return new ResponseEntity<>(nMsj, HttpStatus.OK);}

    @GetMapping(path = "/consultarUsuarios", produces = "application/json")
    public ArrayList<Empleado> consultarTodos(){
        return SU.consultarTodos();
    }

    @GetMapping(path="/consultarUnUsuario/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Empleado> consultarUnUsuario(@PathVariable int id){

        return new ResponseEntity<Empleado>(SU.consultarUnUsuario(id), HttpStatus.OK);
    }

    @PostMapping(path="/crearU", produces= MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Empleado> crearU(@RequestBody Empleado empleado){
        SU.crearUsuario(empleado);
        return new ResponseEntity<Empleado>(HttpStatus.OK);
    }

    @PatchMapping(path="/actualizarU", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Empleado>ActualizarU(@RequestParam int id, @RequestParam(required = false) String nombreModificado,
                                              @RequestParam (required = false)String correoModificado, @RequestParam (required = false)String empresaEmpleadoModificado,
                                               @RequestParam(required = false) String rolEmpleadoModificado){
        Empleado empleado = SU.consultarUnUsuario(id);
        SU.editarUsuario(empleado, nombreModificado, correoModificado, empresaEmpleadoModificado, rolEmpleadoModificado);

        return new ResponseEntity<Empleado>(empleado, HttpStatus.OK);
    }

    @DeleteMapping(path="/borrarU/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String>BorrarU(@PathVariable int id){
        Empleado empleado = SU.consultarUnUsuario(id);
        String salida="";
        if(SU.borrarUsuario(empleado) == Boolean.TRUE){
            salida = "Usuario eliminado con éxito";
        }
        return new ResponseEntity<String>(salida, HttpStatus.OK);
    }
}
