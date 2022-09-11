package com.co.JACM.Sprint.Service;

import com.co.JACM.Sprint.Entitys.Empresa;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class ServicioEmpresa {

    ArrayList<Empresa> listE;
    public ServicioEmpresa(ArrayList<Empresa> listE) {
        this.listE = listE;
    }

    public ArrayList<Empresa> consultarAll(){
        return listE;
        // "Nombre de todas las empresas";
    }

    public Empresa consultarUnaE(int nit){
        Empresa empresa = null;
        for (Empresa E :listE) {
            if(E.getNit() == nit){
                return E;
            }
        }
        return empresa;
    }

    public void crearEmpresa(Empresa E){
        Empresa ObjE = new Empresa(E.getNombre(), E.getDireccion(),E.getTelefono(), E.getNit());
        ObjE.setNombre(E.getNombre());
        ObjE.setDireccion(E.getDireccion());
        ObjE.setTelefono(E.getTelefono());
        ObjE.setNit(E.getNit());
        listE.add(ObjE);

    }

    public Empresa editarE(Empresa E, String n, String d, String t){
        if(n==null){
            E.setNombre(E.getNombre());;
        }else{
            E.setNombre(n);
        }
        if(d==null){
            E.setDireccion(E.getDireccion());
        }else{
            E.setDireccion(d);
        }

        if(t==null){
            E.setTelefono(E.getTelefono());
        }else{
            int TM = Integer.parseInt(t);
            E.setTelefono(TM);
        }
        return E;
    }

    public Boolean borrarEmpresa(Empresa E){
        listE.remove(E);
        return Boolean.TRUE;
    }
}
