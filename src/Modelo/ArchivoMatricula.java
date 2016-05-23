/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class ArchivoMatricula {
    
    ObjectOutputStream archivoSalida;
    ObjectInputStream archivoEntrada;
    
    public ArchivoMatricula()
    {
         if(cargarArchivoMatricula()){
         System.out.println("El archivo se cargó correctamente");   
        }
        else
        {
          System.out.println("Error al cargar archivo");  
        }
        
    }
    
    
     public void crearArchivoMatricula()
            {
                try{       
                archivoSalida=new ObjectOutputStream(new FileOutputStream("archivoMatricula.dat"));
                System.out.println("Se creó el archivo de matricula de forma correcta");
                }
                catch(Exception e)
                {
                 System.out.println("Error al crear archivo de matricula"+e);
                }

            }
      public void ingresarInformacionMatricula(Matricula matricula)
        {
         try
         {
             archivoSalida.writeObject(matricula);
             System.out.println("Se escribió de forma correcta la información del archivo");
         }
         catch(Exception e)
         {
             System.out.println("Error al ingresar información al archivo"+e);
         }
        }
      
     
     public boolean cargarArchivoMatricula()
                {
                    boolean existe=false;
                    try{           

                    archivoEntrada=new ObjectInputStream(new FileInputStream("archivoMatricula.dat"));
                    existe=true;
                    
                            }
                    catch(Exception e)
                    {
                        System.out.println("Error al cargar archivo matricula"+e);
                    }
                    return existe;
                }
     
     public ArrayList<Matricula> devolverInformacionDeMatricula()
        {
            ArrayList <Matricula> array=new ArrayList<Matricula>();
            
            try
            {
              while(true)
              {
                  array.add((Matricula)archivoEntrada.readObject());
              }
            }
            catch(Exception e)
            {
                System.out.println("Se llegó al final del archivo matricula");
            }
            
            return array;
        }
     
}
