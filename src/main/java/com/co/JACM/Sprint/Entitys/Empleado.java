package com.co.JACM.Sprint.Entitys;

import lombok.Data;

@Data
public class Empleado {
    private int id;
    private String nombre;
    private String correo;
    private String empresaEmpleado;
    private String rolEmpleado;

    public Empleado(int id, String nombre, String correo, String empresaEmpleado, String rolEmpleado) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.empresaEmpleado = empresaEmpleado;
        this.rolEmpleado = rolEmpleado;
    }
}
