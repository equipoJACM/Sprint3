package com.co.JACM.Sprint.Service;

import com.co.JACM.Sprint.Entitys.Empleado;
import com.co.JACM.Sprint.Entitys.Empresa;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServicioUsuario {
    ArrayList<Empleado> listUser;
    public ServicioUsuario(ArrayList<Empleado> listUser) {
        this.listUser = listUser;
    }

    public ArrayList<Empleado> consultarTodos(){
        return listUser;
        // "Nombre de todos los empleados";
    }

    public Empleado consultarUnUsuario(int id){
        Empleado empleado = null;
        for (Empleado E :listUser) {
            if(E.getId() == id){
                return E;
            }
        }
        return empleado;
    }

    public void crearUsuario(Empleado E){
        Empleado ObjEmpleado = new Empleado(E.getId(), E.getNombre(), E.getCorreo(), E.getEmpresaEmpleado(),E.getRolEmpleado());
        ObjEmpleado.setId(E.getId());
        ObjEmpleado.setNombre(E.getNombre());
        ObjEmpleado.setCorreo(E.getCorreo());
        ObjEmpleado.setEmpresaEmpleado(E.getEmpresaEmpleado());
        ObjEmpleado.setRolEmpleado(E.getRolEmpleado());
        listUser.add(ObjEmpleado);

    }

    public Empleado editarUsuario(Empleado E, String n, String c, String eE, String rE){
        if(n==null){
            E.setNombre(E.getNombre());;
        }else{
            E.setNombre(n);
        }
        if(c==null){
            E.setCorreo(E.getCorreo());
        }else{
            E.setCorreo(c);
        }

        if(eE==null){
            E.setEmpresaEmpleado(E.getEmpresaEmpleado());
        }else{
            E.setEmpresaEmpleado(eE);
        }
        if(rE==null){
            E.setRolEmpleado(E.getRolEmpleado());
        }else{
            E.setRolEmpleado(rE);
        }
        return E;
    }

    public Boolean borrarUsuario(Empleado E){
        listUser.remove(E);
        return Boolean.TRUE;
    }
}
