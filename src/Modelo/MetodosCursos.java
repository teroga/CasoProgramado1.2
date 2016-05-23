/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MetodosCursos {
    
    private ArrayList <Cursos> arrayCursos;
    String arregloInformacionConsultada[]=new String[3];
    
    public MetodosCursos()
    {
        arrayCursos=new ArrayList <Cursos>();
    }
    public void agregarCurso(String informacion[])
    {
        Cursos temporal=new Cursos(informacion[0], informacion[1], Integer.parseInt(informacion[2]), informacion[3]);
        arrayCursos.add(temporal);
        
    }
    
    public void setArray(ArrayList<Cursos> array){
        arrayCursos=array;
    }
    
    
     public ArrayList<Cursos> getArray(){
       return arrayCursos;
    }
     
     public int getTamano(){
         return arrayCursos.size();
     }
     
     public Cursos get(int numero){
         return arrayCursos.get(numero);
     }
    
    public void mostrarInformacion()
    {
        for(int contador=0;contador<arrayCursos.size();contador++)
        {
         System.out.println(arrayCursos.get(contador).getInformacion());
        
        }
    
    }
    
    public void mensaje(String mensaje)
    {
        JOptionPane.showMessageDialog(null,mensaje);
    }
    
    public boolean consultarCurso(String sigla)
    {
        boolean existe=false;
        
        for(int contador=0;contador<arrayCursos.size();contador++)
        {
            if(arrayCursos.get(contador).getSigla().equals(sigla))
            {
                arregloInformacionConsultada[0]=arrayCursos.get(contador).getNombre();
                arregloInformacionConsultada[1]=""+arrayCursos.get(contador).getCreditos();
                arregloInformacionConsultada[2]=arrayCursos.get(contador).getHorario();
                existe=true;
            }
        
        }
        return existe;
    
    }
    public void modificarCurso(String arreglo[])
    {
        for(int contador=0;contador<arrayCursos.size();contador++)
        {
            if(arrayCursos.get(contador).getSigla().equals(arreglo[0]))
            {
                arrayCursos.get(contador).setNombre(arreglo[1]);
                arrayCursos.get(contador).setCreditos(Integer.parseInt(arreglo[2]));
                arrayCursos.get(contador).setHorario(arreglo[3]);
            }
        }
    }
    public void eliminarCurso(String arreglo[])
    {
        for(int contador=0;contador<arrayCursos.size();contador++)
        {
            if(arrayCursos.get(contador).getSigla().equals(arreglo[0]))
            {
                arrayCursos.remove(contador);
            }
        }
    }
    public String[] getArregloInformacion()
    {
        return this.arregloInformacionConsultada;
    } 
    
}
