/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import javax.swing.JOptionPane;


public class MetodosUsuarios {
    
    private ArrayList <Usuarios> arrayUsuarios;
    String arregloInformacionConsultada[]=new String[4];
    ArchivoUsuario archivoUsuario;
    
    public MetodosUsuarios()
    {
        arrayUsuarios=new ArrayList <Usuarios>();
        archivoUsuario=new ArchivoUsuario();
       // cargarArchivoAlArray();
    }
    
    public void cargarArchivoAlArray(){
        Usuarios arregloUsuarios[]=archivoUsuario.devolverInformacionDelArchivoComoArreglo();
        for(int contador=0;contador<arregloUsuarios.length;  contador++){
            System.out.println("Se agregó un objeto");
        }
    }
    
    
    public void agregarUsuario(String informacion[])
    {
        Usuarios temporal=new Usuarios(informacion[0], informacion[1], informacion[2], informacion[3]);
        arrayUsuarios.add(temporal);
        
    }
    
    public boolean verificarUsuarios(){
        return archivoUsuario.verificarExistenciaDeArchivoDeUsuarios();
    }
    
    public void escribirInformacionArchivo(){
        this.archivoUsuario.crearArchivo();
        for(int contador=0; contador<arrayUsuarios.size(); contador++){
            archivoUsuario.escribirInformacionEnArchivo(arrayUsuarios.get(contador));
            System.out.println("Se escribió");
        }
    }
    
    
    
    public void setArray(ArrayList<Usuarios> array){
        arrayUsuarios=array;
    }
    
    
     public ArrayList<Usuarios> getArray(){
       return arrayUsuarios;
    }
     
     public int getTamano(){
         return arrayUsuarios.size();
     }
     
     public Usuarios get(int numero){
         return arrayUsuarios.get(numero);
     }
    
    public void mostrarInformacion()
    { 
        for(int contador=0;contador<arrayUsuarios.size();contador++)
        {
         System.out.println(arrayUsuarios.get(contador).getInformacion());
        
        }
    
    }
    
    public void mensaje(String mensaje)
    {
        JOptionPane.showMessageDialog(null,mensaje);
    }
    
    public boolean consultarUsuarios(String nombreUsuario)
    {
        boolean existe=false;
        
        for(int contador=0;contador<arrayUsuarios.size();contador++)
        {
            if(arrayUsuarios.get(contador).getNombreUsuario().equals(nombreUsuario))
            {
                arregloInformacionConsultada[0]=arrayUsuarios.get(contador).getNombreCompleto();                
                arregloInformacionConsultada[1]=arrayUsuarios.get(contador).getContraseña();
                arregloInformacionConsultada[2]=arrayUsuarios.get(contador).getTipo();
                existe=true;
            }
        
        }
        return existe;
    
    }
    
    public boolean buscarUsuario (String arreglo[])
    {
       boolean encontro=true;
       for(int contador=0;contador<arrayUsuarios.size();contador++)
       {
          if(arrayUsuarios.get(contador).getNombreUsuario().equals(arreglo[0])&&arrayUsuarios.get(contador).equals(arreglo[1]))
          {
              encontro=true;
          }
              
          }
         return encontro;
       }    //Fin del método buscar
    
 
    
    public void modificarUsuarios(String arreglo[])
    {
        for(int contador=0;contador<arrayUsuarios.size();contador++)
        {
            if(arrayUsuarios.get(contador).getNombreUsuario().equals(arreglo[1]))
            {
                arrayUsuarios.get(contador).setNombreCompleto(arreglo[0]);
                arrayUsuarios.get(contador).setContraseña(arreglo[2]);
                arrayUsuarios.get(contador).setTipo(arreglo[3]);
            }
        }
    }
    public void eliminarUsuarios(String arreglo[])
    {
        for(int contador=0;contador<arrayUsuarios.size();contador++)
        {
            if(arrayUsuarios.get(contador).getNombreUsuario().equals(arreglo[1]))
            {
                arrayUsuarios.remove(contador);
            }
        }
    }
    public String[] getArregloInformacion()
    {
        return this.arregloInformacionConsultada;
    }
}