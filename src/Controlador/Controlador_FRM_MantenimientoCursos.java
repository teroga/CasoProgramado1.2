/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ArchivoCursos;
import Modelo.ConexionBD;
import Modelo.MetodosCursos;
import Modelo.Metodos_XML_Cursos;
import Vista.FRM_MantenimientoCursos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class Controlador_FRM_MantenimientoCursos implements ActionListener{
    
    String fuenteCursos="";
    
    FRM_MantenimientoCursos frm_MantenimientoCursos;
    public MetodosCursos metodos;
    ArchivoCursos archivo;
    ConexionBD conexion;
    Metodos_XML_Cursos metodosXMLCursos;
    
    public Controlador_FRM_MantenimientoCursos(FRM_MantenimientoCursos frm_MantenimientoCursos)
    {
        this.frm_MantenimientoCursos= frm_MantenimientoCursos;
        metodos = new MetodosCursos();
        frm_MantenimientoCursos.estadoInicial();
        metodosXMLCursos=new Metodos_XML_Cursos(frm_MantenimientoCursos);
        archivo=new ArchivoCursos();
        
        if(archivo.cargarArchivoCursos()){
     metodos.setArray(archivo.devolverInformacionDeCursos());
     }
     else
     {
         archivo.crearArchivoCursos();
         
     }
    } 
    
    //METODO ELECCION
        public void establecerFuente(String eleccion){
        fuenteCursos=eleccion;
    }//METODO ELECCION
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Agregar"))
        {
            //Archvos
            if(fuenteCursos.equals("Archivos")){
            System.out.println("Archivos");
            metodos.agregarCurso(frm_MantenimientoCursos.devolverInformacion());
            metodos.mensaje("El curso ha sido registrado con éxito");
            archivo.crearArchivoCursos();
            frm_MantenimientoCursos.estadoInicial();
            for(int contador=0; contador<metodos.getTamano();contador++){
               archivo.ingresarInformacionCursos(metodos.get(contador));
                }
         }//FIN ARCHIVOS
            
            //BD
            if(fuenteCursos.equals("BD")){
                conexion.registrarCurso(frm_MantenimientoCursos.devolverInformacion());
                frm_MantenimientoCursos.estadoInicial();
            }//FIN BD
            
            //XML
            if(fuenteCursos.equals("XML")){
                  
                metodosXMLCursos.guardarEnXML(frm_MantenimientoCursos.devolverInformacion());
                System.out.println("Información agregada.");
                frm_MantenimientoCursos.estadoInicial();
            }//XML
            
        }
        
        
        
        
        if(e.getActionCommand().equals("Consultar"))
        {
            //ARCHIVOS
            if(fuenteCursos.equals("Archivos")){
            if(metodos.consultarCurso(frm_MantenimientoCursos.devolverSigla()))
            {
                frm_MantenimientoCursos.mostrarInformacion(metodos.getArregloInformacion());
                frm_MantenimientoCursos.habilitarOpciones();
            }
            else
            {
                metodos.mensaje("No se encontro el curso");
                frm_MantenimientoCursos.habilitarAgregar();
            }
        }
        }//ARCHIVOS
        
        //BD
        if(fuenteCursos.equals("BD")){
            if(conexion.consultarCurso((frm_MantenimientoCursos.devolverSigla()))){
                frm_MantenimientoCursos.mostrarInformacion(conexion.getArregloInformacionCurso());
                frm_MantenimientoCursos.habilitarOpciones();
            }
            else{
                metodos.mensaje("No se encontro el curso");
                frm_MantenimientoCursos.habilitarAgregar();
            }
        }
        //BD
        
        //XML
            if(fuenteCursos.equals("XML")){
                if(metodosXMLCursos.consultarInformacionDelXml(frm_MantenimientoCursos.devolverSigla())){
                    frm_MantenimientoCursos.mostrarInformacionXML(metodosXMLCursos.getArregloInformacion());
                    frm_MantenimientoCursos.habilitarOpciones();
                    System.out.println("Información encontrada con la cédula: "+frm_MantenimientoCursos.devolverSigla());
                }
                else{
                    JOptionPane.showMessageDialog(null,"No se encontró información con la cédula: "+frm_MantenimientoCursos.devolverSigla());
                    frm_MantenimientoCursos.habilitarAgregar();
                }
            }//FIN XML
        
        
        if(e.getActionCommand().equals("Eliminar"))
        {
            //Archivos
            if(fuenteCursos.equals("Archivos")){
            metodos.eliminarCurso(frm_MantenimientoCursos.devolverInformacion());
            metodos.mensaje("El curso ha sido eliminado con éxito");
            
            }//FIN ARCHIVOS
            
            //BD
            if(fuenteCursos.equals("BD")){
                conexion.eliminarCurso(frm_MantenimientoCursos.devolverSigla());
            }
            //BD
            
            //XML
            if(fuenteCursos.equals("XML")){
                metodosXMLCursos.eliminarInformacionDelXml(frm_MantenimientoCursos.devolverSigla());
                System.out.println("Info eliminada");
            }
            frm_MantenimientoCursos.resetearInterfaz();
            frm_MantenimientoCursos.estadoInicial();
        }
        
        
        if(e.getActionCommand().equals("Modificar"))
        {
            //ARCHIVOS
            if(fuenteCursos.equals("Archivos")){
           metodos.modificarCurso(frm_MantenimientoCursos.devolverInformacion());
           metodos.mensaje("Los datos han sido modificados exitosamente");
            }//FIN Archivos
           
           //XML
            if(fuenteCursos.equals("XML")){
                metodosXMLCursos.modificarInformacionDelXml(frm_MantenimientoCursos.devolverInformacion());
                System.out.println("Info modificada");
        }//FIN XML
        
        }
    }
    
    public void guardarArchivo(){
        archivo.crearArchivoCursos();
        for(int contador=0; contador<metodos.getTamano();contador++){
            archivo.ingresarInformacionCursos(metodos.get(contador));
        }
    }
    
    }
