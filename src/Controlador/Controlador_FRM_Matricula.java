/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ArchivoMatricula;
import Modelo.ConexionBD;
import Modelo.Matricula;
import Modelo.MetodosCursos;
import Modelo.MetodosEstudiantes;
import Modelo.MetodosMatricula;
import Modelo.Metodos_XML_Matricula;
import Vista.FRM_MantenimientoCursos;
import Vista.FRM_MantenimientoEstudiantes;
import Vista.FRM_Matricula;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Controlador_FRM_Matricula implements ActionListener{
    
    MetodosCursos metodosCursos;
    MetodosEstudiantes metodosEstudiantes;
    MetodosMatricula metodosMatricula;
    Metodos_XML_Matricula metodosXML;
    FRM_Matricula frm_Matricula;
    boolean encontroEstudiante=false;
    boolean encontroCurso=false;
    ArchivoMatricula archivo;
    ConexionBD conexion;
    String fuente="";
    int tamanio=0;
   
    public Controlador_FRM_Matricula(FRM_MantenimientoEstudiantes mantenimientoEstudiantes,FRM_MantenimientoCursos mantenimientoCursos,FRM_Matricula frm_Matricula)
    {
        this.metodosCursos=mantenimientoCursos.controlador.metodos;
        this.metodosEstudiantes=mantenimientoEstudiantes.controlador_FRM_MantenimientoEstudiantes.metodos;
        this.frm_Matricula=frm_Matricula;
        metodosMatricula=new MetodosMatricula();
        metodosXML = new Metodos_XML_Matricula(frm_Matricula);
        archivo=new ArchivoMatricula();
        this.conexion=conexion;        
        
        archivo=new ArchivoMatricula();
        
        if(archivo.cargarArchivoMatricula()){
        metodosMatricula.setArray(archivo.devolverInformacionDeMatricula());
     }
     else
     {
         archivo.crearArchivoMatricula();
     }
    }//CONSTRUCTOR
    
    public void establecerFuente(String fuente)
    {
        this.fuente=fuente;
    }
    
         public ArrayList<Matricula> getArray(){
             return metodosMatricula.getArray();
    }
    
    public void actionPerformed(ActionEvent e)
    {
        
        //ARCHIVOS
        if(e.getActionCommand().equals("ConsultaRapidaEstudiante"))
        {
            //archivos
            if (fuente.equals("Archivos")){
                 if(metodosEstudiantes.consultarEstudiante(frm_Matricula.devolverCedula()))
            {
                String arreglo[]=metodosEstudiantes.getArregloInformacion();
                frm_Matricula.mostrarNombreEstudiante(arreglo[0]);
                encontroEstudiante=true;     
            }
            else
            {
            frm_Matricula.mostrarMensaje("El estudiante consultado no se encuentra, favor dirigirse al modulo mantenimiento estudiantes");
            }    
            }
            //ARCHIVOS
            
            if(fuente.equals("BD")){
                if(conexion.consultarEstudiantes(frm_Matricula.devolverCedula())){
                    String arreglo[]=conexion.getArregloInformacion();
                    frm_Matricula.mostrarNombreEstudiante(arreglo[0]);
                    encontroEstudiante=false;
                }
                else{
                    frm_Matricula.mostrarMensaje("El estudiante consultado no se encuentra, favor dirigirse al modulo mantenimiento estudiantes");
                }
            }
               
        }//FIN CONSULTAESTUDIANTE
        
        if(e.getActionCommand().equals("ConsultaRapidaCurso"))
        {
            if(fuente.equals("Archivos")){
                 if(metodosCursos.consultarCurso(frm_Matricula.devolverSigla()))
            {
                String arreglo[]=metodosCursos.getArregloInformacion();
                frm_Matricula.mostrarNombreCurso(arreglo[0]);
                encontroCurso=true;      
            }
            else
            {
              frm_Matricula.mostrarMensaje("El curso consultado no se encuentra, favor dirigirse al modulo mantenimiento curso"); 
            }
            }//ARCHIVOS
                 
            //BD
                  if(fuente.equals("BD")){
                if(conexion.consultarCurso(frm_Matricula.devolverSigla())){
                    String arreglo[]=conexion.getArregloInformacionCurso();
                    frm_Matricula.mostrarNombreCurso(arreglo[0]);
                    encontroEstudiante=false;
                }
                else{
                    frm_Matricula.mostrarMensaje("El curso consultado no se encuentra, favor dirigirse al modulo mantenimiento curso");
                }
            }//BD
                  
                  //XML
            if(fuente.equals("XML")){
                if(metodosXML.consultarInformacionDelXml(frm_Matricula.devolverCodigo())){
                    frm_Matricula.mostrarInformacion(metodosXML.getArregloInformacion());
                    
                    
                    frm_Matricula.mostrarMensaje("Información encontrada con la cédula: "+frm_Matricula.devolverCedula());
                }
                else{
                    frm_Matricula.mostrarMensaje("No se encontró información con la cédula: "+frm_Matricula.devolverCodigo());
                    
                    
                }
            }//FIN XML
                  
        }//FIN CONSULTACURSO
        
        if(e.getActionCommand().equals("Consultar"))
        {
            System.out.println("Consultar");
            //ARCHIVOS
            if(fuente.equals("Archivos")){
                 if(metodosMatricula.consultarMatricula(frm_Matricula.devolverCodigo()))
            {
                frm_Matricula.mostrarInformacion(metodosMatricula.getArregloInformacion());
                frm_Matricula.habilitarOpciones();
            }
            else
            {
              frm_Matricula.mostrarMensaje("El código consultado, no tiene ninguna matricula registrada");
              frm_Matricula.habilitarAgregar();
            }
            }//ARCHIVOS
            
            //BD
            if(fuente.equals("BD")){
                if(conexion.consultarMatricula(frm_Matricula.devolverCodigo())){
                    frm_Matricula.mostrarInformacion(conexion.getArregloInformacion());
                    frm_Matricula.mostrarMensaje("Informacion Encontrada");
                    frm_Matricula.habilitarOpciones();
                }
                else{
                    frm_Matricula.mostrarMensaje("El código consultado, no tiene ninguna matricula registrada");
                    frm_Matricula.habilitarAgregar();
                }
            }
            //BD
            //XML
            if(fuente.equals("XML"))
            {
              if(true)
              {
               frm_Matricula.habilitarOpciones();
              }
              else
              {
               frm_Matricula.habilitarAgregar();
              }
            }//FIN XML
           
        }//CONSULTAR
        
        if(e.getActionCommand().equals("Agregar"))
        {
            
         frm_Matricula.cargarTabla();
                        
            //ARCHIVOS
            if(fuente.equals("Archivos")){

            encontroCurso=false;
            archivo.crearArchivoMatricula();
            for(int contador=0; contador<metodosMatricula.getTamano();contador++){
            archivo.ingresarInformacionMatricula(metodosMatricula.get(contador));
           }
            metodosMatricula.mostrarInformacion();            
            frm_Matricula.limpiarCurso();
            
            }//ARCHIVOS
            
            //BD
            //BD
            
            //XML
            //XML
            if(fuente.equals("XML")){
                metodosXML.guardarEnXML(frm_Matricula.devolverInformacion());
                frm_Matricula.mostrarMensaje("Información agregada.");
            }
            //XML
            
            
        }//Agregar
        
          if(e.getActionCommand().equals("Finalizar"))
         {
             frm_Matricula.estadoInicial();
             //Archivos
             if(fuente.equals("Archivos")){
            for(int contador=0;contador<frm_Matricula.getCantidadDeCursosMatriculados();contador++)
            {
                metodosMatricula.agregarMatricula(frm_Matricula.getInformacionTabla(contador));
                archivo.ingresarInformacionMatricula(metodosMatricula.get(contador));
            }
                        
            metodosMatricula.mostrarInformacion();
            
        if(encontroEstudiante && encontroCurso)
        {
            frm_Matricula.habilitarAgregar();
        }
        
         }//ARCHIVOS
             
                       //BD
              if(fuente.equals("BD")){
            for(int contador=0;contador<frm_Matricula.getCantidadDeCursosMatriculados();contador++)
            {
                conexion.registrarMatricula(frm_Matricula.getInformacionTabla(contador));
            }
          }
             //BD  
              
              //XML
              if(fuente.equals("XML")){
                  
              }
              //XML
              
              
             }//FINALIZAR
          
       if(e.getActionCommand().equals("Eliminar"))
        {
            frm_Matricula.resetearInterfaz();
            //ARCHIVOS
            if(fuente.equals("Archivos")){
                
            }
            
            //ARCHIVOS
            
            //BD
            if(fuente.equals("BD")){
                
            int confirmado=JOptionPane.showConfirmDialog(null, "Si elimina su matrícula, perderá todos sus datos.\n¿Desea continuar?");
            if (JOptionPane.YES_OPTION==confirmado){
            conexion.eliminarMatricula(frm_Matricula.devolverCodigo());
            frm_Matricula.mostrarMensaje("Ha elimado la matrícula");
            }
            else{
                    frm_Matricula.mostrarMensaje("Sus datos siguen intactos.");
                    }
            }
            //BD
            System.out.println("Eliminar");

        }//ELIMINAR  
    }//ACTIONPERFORMED
    
    
    public String colocarCodigo()
    {
        return metodosMatricula.devolverCodigo();
    }
}//FIN CLASE
