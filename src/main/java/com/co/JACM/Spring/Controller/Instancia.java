package com.co.JACM.Spring.Controller;

import com.co.JACM.Spring.Domain.Empleado;
import com.co.JACM.Spring.Domain.Empresa;
import com.co.JACM.Spring.Domain.MovimientoDinero;

public class Instancia {
    public static void main(String args[]){
        Empleado ObjEmpleado = new Empleado();
        ObjEmpleado.setCorreo("H@gmail.com");
        ObjEmpleado.setEmpresaEmpleado("Multinacional SS");
        ObjEmpleado.setNombre("Jorge Granados");
        ObjEmpleado.setRolEmpleado("Administrativo");

        Empresa ObjEmpresa = new Empresa();
        ObjEmpresa.setNombre("Multinacional SS");
        ObjEmpresa.setDireccion("CRA 86-94");
        ObjEmpresa.setTelefono(123456789);
        ObjEmpresa.setNit(1234);

        MovimientoDinero ObjMovDin = new MovimientoDinero();
        ObjMovDin.setConcepto("Transferencia");
        ObjMovDin.setUsuario("Jorge Granados");
        ObjMovDin.setMonto(30000);
        ObjMovDin.montos();
        ObjMovDin.usuarioEncargado();
    }
}
