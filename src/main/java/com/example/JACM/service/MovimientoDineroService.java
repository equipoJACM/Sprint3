package com.example.JACM.service;

import com.example.JACM.model.Empleado;
import com.example.JACM.model.Empresa;
import com.example.JACM.model.MovimientoDinero;
import com.example.JACM.repository.MoviminetoDineroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovimientoDineroService {
    @Autowired
    MoviminetoDineroRepository moviminetoDineroRepository;

    public void crearYActualizarMovimientoDinero(MovimientoDinero movimientoDinero){
        moviminetoDineroRepository.save(movimientoDinero);
    }

    public List<MovimientoDinero> verMovimientoDinero(){
        List<MovimientoDinero> movimientoDineros = new ArrayList<MovimientoDinero>();
        movimientoDineros.addAll(moviminetoDineroRepository.findAll());
        return movimientoDineros;
    }


    public MovimientoDinero verMovimientoDineroPorId(Long id) {
        return moviminetoDineroRepository.findById(id).get();
    }

//    public List<MovimientoDinero> ListarMovimientoDinero(){ return this.moviminetoDineroRepository.findAll();}

    public void eliminarMovimientoDinero(Long id){
        moviminetoDineroRepository.deleteById(id);
    }
}
