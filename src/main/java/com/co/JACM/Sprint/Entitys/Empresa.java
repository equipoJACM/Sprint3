package com.co.JACM.Sprint.Entitys;

import lombok.Data;

@Data
public class Empresa {

    private String nombre;
    private String direccion;
    private Integer telefono;
    private Integer nit;

    public Empresa(String nombre, String direccion, Integer telefono, Integer nit) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.nit = nit;
    }
}
