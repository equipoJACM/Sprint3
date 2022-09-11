package com.co.JACM.Sprint.Controller;

import com.co.JACM.Sprint.Entitys.Empresa;
import com.co.JACM.Sprint.Service.ServicioEmpresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.awt.*;
import java.util.ArrayList;

@RestController //@controller: @responseBody y @requestMapping

@RequestMapping(value="JACM")
public class ControllerEmpresa {

    @Autowired
    ServicioEmpresa SE;
    Empresa E;

    @GetMapping(path="/enterprises", produces= MediaType.ALL_VALUE)
    public ResponseEntity<String> mensaje(){
        String msj = "Primer responseEntity";
        return new ResponseEntity<String>(msj, HttpStatus.OK);
    }
    @GetMapping("/Hola")
    public String m(){
        return "Vamos de nuevo";
    }

    @GetMapping(path = "/consultarEmpresas", produces = "application/json")
    public ArrayList<Empresa> consultarTodasE(){
        return SE.consultarAll();
    }

    @GetMapping(path="/consultarUnaE/{nit}", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Empresa> consultarUnaE(@PathVariable int nit){

        return new ResponseEntity<Empresa>(SE.consultarUnaE(nit), HttpStatus.OK);
    }

    @PostMapping(path="/crearE", produces= MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Empresa> crearE(@RequestBody Empresa E){
        SE.crearEmpresa(E);
        return new ResponseEntity<Empresa>(HttpStatus.OK);
    }

    @PatchMapping(path="/actualizarE", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Empresa>ActualizarE(@RequestParam int nit, @RequestParam(required = false) String nombreModificado,
    @RequestParam (required = false)String direccionModificada, @RequestParam (required = false)String telefonoModificado){
        Empresa E = SE.consultarUnaE(nit);
        SE.editarE(E, nombreModificado, direccionModificada, telefonoModificado);

        return new ResponseEntity<Empresa>(E, HttpStatus.OK);
    }

    @DeleteMapping(path="/borrarE/{nit}", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String>BorrarE(@PathVariable int nit){
        Empresa E = SE.consultarUnaE(nit);
        String salida="";
        if(SE.borrarEmpresa(E) == Boolean.TRUE){
            salida = "Empresa eliminada con éxito";
        }
        return new ResponseEntity<String>(salida, HttpStatus.OK);
    }

}
