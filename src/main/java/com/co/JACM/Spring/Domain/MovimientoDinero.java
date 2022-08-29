package com.co.JACM.Spring.Domain;

import lombok.Data;

@Data
public class MovimientoDinero {

    private double monto;
    private String concepto;
    private String usuario;


    public double montos(){
        return -1;
    }

    public String usuarioEncargado(){

        return "usuarioEncargado";
    }
}
