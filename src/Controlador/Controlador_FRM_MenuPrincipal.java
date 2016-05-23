/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConexionBD;
import Vista.FRM_Eleccion;
import Vista.FRM_Login;
import Vista.FRM_MantenimientoCursos;
import Vista.FRM_MantenimientoEstudiantes;
import Vista.FRM_MantenimientoUsuarios;
import Vista.FRM_Matricula;
import Vista.FRM_MenuPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador_FRM_MenuPrincipal implements ActionListener{
    
    FRM_MantenimientoEstudiantes mantenimientoEstudiantes;
    FRM_MantenimientoCursos mantenimientoCursos;
    FRM_MantenimientoUsuarios mantenimientoUsuarios;
    FRM_Matricula matricula;
    FRM_Eleccion frm_eleccion;
    FRM_Login login;
    ConexionBD conexion;
    
    String fuente="";
    
    public Controlador_FRM_MenuPrincipal(FRM_MenuPrincipal frm_MenuPrincipal)
    {
        mantenimientoEstudiantes=new FRM_MantenimientoEstudiantes();
        mantenimientoCursos=new FRM_MantenimientoCursos();
        mantenimientoUsuarios=new FRM_MantenimientoUsuarios();
        matricula= new FRM_Matricula(mantenimientoEstudiantes,mantenimientoCursos);
        frm_eleccion=new FRM_Eleccion(frm_MenuPrincipal);
        conexion=new ConexionBD();
        mantenimientoEstudiantes.controlador_FRM_MantenimientoEstudiantes.conexion=this.conexion;
        mantenimientoCursos.controlador.conexion=this.conexion;
        mantenimientoUsuarios.controlador_FRM_MantenimientoUsuarios.conexion=this.conexion;
       matricula.controlador.conexion=this.conexion;
    }
    
    public String establecerFuente(String eleccion){
        fuente=eleccion;
        mantenimientoEstudiantes.establecerFuente(eleccion);
        mantenimientoCursos.establecerFuente(eleccion);
        matricula.establecerFuente(eleccion);
        mantenimientoUsuarios.establecerFuente(eleccion);
                
        return fuente;
    }
    
      
 

    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Salir"))
        {
            System.exit(0);        
        }
        if(e.getActionCommand().equals("Estudiantes"))
        {
            this.mantenimientoEstudiantes.setVisible(true);
            
        }
        if(e.getActionCommand().equals("Cursos"))
        {
            this.mantenimientoCursos.setVisible(true);
        }
        if(e.getActionCommand().equals("Matricula"))
        {
            this.matricula.setVisible(true);
            this.matricula.colocarCodigo();
        }
        if(e.getActionCommand().equals("Usuarios"))
        {
            this.mantenimientoUsuarios.setVisible(true);            
        }
    
    }
    
}