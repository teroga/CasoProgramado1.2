/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ArchivoUsuario;
import Vista.FRM_Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.FRM_MantenimientoUsuarios;
import Modelo.ConexionBD;
import Modelo.MetodosUsuarios;
import Vista.FRM_Eleccion;

public class Controlador_FRM_Login implements ActionListener{
    String fuenteLogin="BD";
    FRM_Login fRM_Login;
    FRM_MantenimientoUsuarios fRM_MantenimientoUsuarios;
    ConexionBD conexion;
    MetodosUsuarios metodosUsuarios;
    FRM_Eleccion frm_Eleccion;
    ArchivoUsuario archivo;
  
  public Controlador_FRM_Login(FRM_Eleccion frm_Eleccion, FRM_Login frm_Login){
        this.fRM_Login =  frm_Login;
        this.frm_Eleccion = frm_Eleccion;
        fRM_MantenimientoUsuarios = new FRM_MantenimientoUsuarios();
        metodosUsuarios= new MetodosUsuarios();
        archivo=new ArchivoUsuario();
        this.conexion=new ConexionBD();
        
        if(archivo.verificarExistenciaDeArchivoDeUsuarios()){
            metodosUsuarios.setArray(archivo.devolverInformacionDeUsuarios());
        }
        else{
            archivo.crearArchivoUsuarios();
        }
        
  }
  
  public void verificar()
  {
      if(metodosUsuarios.verificarUsuarios()){
           metodosUsuarios.mensaje("Existen usuarios registrados, ingrese los datos");
        }
  }
  public void actionPerformed(ActionEvent e)
  {
      String login="Archivos";
     if(e.getActionCommand().equals("Login"))
     {
         if(fuenteLogin.equals("Archivos"))
         {
             if(metodosUsuarios.buscarUsuario(fRM_Login.devolverInformacion()))
             {
                fRM_Login.noHacerLogin();
             }
         }
         //BD
         if(fuenteLogin.equals("BD"))
         {
          if(conexion.consultarUsuarios(fRM_MantenimientoUsuarios.devolverInformacion()))
           {
             fRM_Login.noHacerLogin();
           }  
          else
          {
            fRM_Login.noHacerLogin();
            System.out.println("Los datos son incorrectos");   
          }
         }//Fin BD
         //XML
         if(fuenteLogin.equals("XML"))
         {
           
         }//Fin XML
         /*System.out.println("Login");
                    if(metodosUsuarios.buscarUsuario(fRM_Login.devolverInformacion())){
                fRM_Login.noHacerLogin();
                fRM_Login.setVisible(false);
            }
            else{
                System.out.println("Los datos son incorrectos");
            }*/
        }
     
     if(e.getActionCommand().equals("Registrarse"))
     {
         fRM_MantenimientoUsuarios.setVisible(true);
         System.out.println("Registrarse");
         
         
     }
  }
}
