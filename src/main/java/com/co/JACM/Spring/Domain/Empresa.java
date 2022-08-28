package com.co.JACM.Spring.Domain;

public class Empresa {


    private String nombreEmpresa;
    private String direccionEmpresa;
    private Integer telefonoEmpresa;
    private Integer nitEmpresa;

    public Empresa(String nombre, String direccion, Integer telefono, Integer nit) {
        this.nombreEmpresa = nombre;
        this.direccionEmpresa = direccion;
        this.telefonoEmpresa = telefono;
        this.nitEmpresa = nit;
    }

    public String getNombre() {
        return nombreEmpresa;
    }

    public void setNombre(String nombre) {
        this.nombreEmpresa = nombre;
    }

    public String getDireccion() {
        return direccionEmpresa;
    }

    public void setDireccion(String direccion) {
        this.direccionEmpresa = direccion;
    }

    public Integer getTelefono() {
        return telefonoEmpresa;
    }

    public void setTelefono(Integer telefono) {
        this.telefonoEmpresa = telefono;
    }

    public Integer getNit() {
        return nitEmpresa;
    }

    public void setNit(Integer nit) {
        this.nitEmpresa = nit;
    }
}
