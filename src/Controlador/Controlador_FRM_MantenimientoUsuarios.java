/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelo.ArchivoUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.ConexionBD;
import Modelo.MetodosUsuarios;
import Vista.FRM_MantenimientoUsuarios;
import javax.swing.JOptionPane;

public class Controlador_FRM_MantenimientoUsuarios implements ActionListener {
    String fuenteUsuario="Archivos";
    ConexionBD conexion;
    FRM_MantenimientoUsuarios mantenimientoUsuarios;
    MetodosUsuarios metodos;
    ArchivoUsuario archivoUsuarios;

    public Controlador_FRM_MantenimientoUsuarios() {
    }
    
  public Controlador_FRM_MantenimientoUsuarios(FRM_MantenimientoUsuarios fRM_MantenimientoUsuarios)
  {
   this.mantenimientoUsuarios=fRM_MantenimientoUsuarios;
   this.conexion=new ConexionBD();
   metodos=new MetodosUsuarios();   
   archivoUsuarios=new ArchivoUsuario();
        
        if(archivoUsuarios.cargarArchivoUsuarios()){
        metodos.setArray(archivoUsuarios.devolverInformacionDeUsuarios());
     }
     else
     {
         archivoUsuarios.crearArchivoUsuarios();
     }
   
  }
  //METODO ELECCION
        public void establecerFuente(String eleccion){
        fuenteUsuario=eleccion;
    }//METODO ELECCION
  
  
  public void actionPerformed(ActionEvent e)
  {
      
      if(e.getActionCommand().equals("Consultar"))
     {   
         //Archivos
         if(fuenteUsuario.equals("Archivos")){             
         buscar();
         }//Fin Archivos
         
     //BD
         if(fuenteUsuario.equals("BD"))
         {
             
            if(conexion.consultarUsuario(mantenimientoUsuarios.devolverNombreUsuario()))
            {
              mantenimientoUsuarios.mostrarInformacion(conexion.getArregloInformacionUsuario());
              mantenimientoUsuarios.habilitarOpciones();
              System.out.println("Usuario encontrado");  
            }
            else
            {
              System.out.println("Usuario no encontrado"); 
              mantenimientoUsuarios.habilitarAgregar();
            }
            System.out.println("Consultar");
         }//FIN BASES
         
         //XML
         if(fuenteUsuario.equals("XML"))
         {
          if(true)
          {
            mantenimientoUsuarios.habilitarOpciones();
          }
          else
          {
            mantenimientoUsuarios.habilitarAgregar();
          }
         }
         //FIN XML
     }
             
             
      if(e.getActionCommand().equals("Agregar"))
     {
         mantenimientoUsuarios.resetearInterfaz();
         //ARCHIVOS
         if(fuenteUsuario.equals("Archivos")){
        metodos.agregarUsuario(mantenimientoUsuarios.devolverInformacion());
        archivoUsuarios.crearArchivoUsuarios();
        mantenimientoUsuarios.estadoInicial();
        for(int contador=0; contador<metodos.getTamano();contador++){
        archivoUsuarios.ingresarInformacionUsuarios(metodos.get(contador));        
        metodos.mostrarInformacion();        
        }//ARCHIVOS
         }
         //BASES DE DATOS
        if(fuenteUsuario.equals("BD")){
          conexion.registrarUsuario(mantenimientoUsuarios.devolverInformacion());
          System.out.println("Usuario Agregado");
          mantenimientoUsuarios.estadoInicial();
         }
        //BASES DATOS
         
        //XML        
        if(true)
        {
         mantenimientoUsuarios.estadoInicial();   
        }
        //XML
         JOptionPane.showMessageDialog(null, "Usuario agregado");
     }
      if(e.getActionCommand().equals("Modificar"))
     {
         
         //ARCHIVOS
         if(fuenteUsuario.equals("Archivos"))
         {
             metodos.modificarUsuarios(mantenimientoUsuarios.devolverInformacion());
             System.out.println("Modificado");
         }//FIN ARCHIVOS
         
         //BD
         if(fuenteUsuario.equals("BD"))
         {
             conexion.actualizarUsuario(mantenimientoUsuarios.devolverInformacion());
         }//FIN BD
         
         //XML
         if(fuenteUsuario.equals("XML"))
         {
             
         }//FIN XML
         System.out.println("Modificar");
     }
      if(e.getActionCommand().equals("Eliminar"))
     {
          //ARCHIVOS
         if(fuenteUsuario.equals("Archivos"))
         {
           metodos.eliminarUsuarios(mantenimientoUsuarios.devolverInformacion());
           System.out.println("Eliminado");
         }//FIN ARCHIVOS
         
         //BD
         if(fuenteUsuario.equals("BD"))
         {
            conexion.eliminarUsuario(mantenimientoUsuarios.devolverNombreDeUsuario());
         }//FIN BD
         
         //XML
         if(fuenteUsuario.equals("XML"))
         {
             
         }//FIN XML
         mantenimientoUsuarios.estadoInicial();
         mantenimientoUsuarios.resetearInterfaz();
         System.out.println("Eliminar");
     }
  }
  
  
   public void buscar()
    {
            if(metodos.consultarUsuarios(mantenimientoUsuarios.devolverNombreDeUsuario()))
            {
                mantenimientoUsuarios.mostrarInformacion(metodos.getArregloInformacion());
                mantenimientoUsuarios.habilitarOpciones();                
            }
            else
            {
                metodos.mensaje("El usuario consultado no se encontró");
                mantenimientoUsuarios.habilitarAgregar();
            }
    }
    
    public void guardarArchivo(){
        archivoUsuarios.crearArchivoUsuarios();
        for(int contador=0; contador<metodos.getTamano();contador++){
            archivoUsuarios.ingresarInformacionUsuarios(metodos.get(contador));
        }
    }
    
  
  
}
