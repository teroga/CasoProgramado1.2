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


public class ArchivoCursos {
    
    ObjectOutputStream archivoSalida;
    ObjectInputStream archivoEntrada;
    
    public ArchivoCursos()
    {
        if(cargarArchivoCursos()){
         System.out.println("El archivo se cargó correctamente");   
        }
        else
        {
          System.out.println("Error al cargar archivo");  
        }
    }
    
     public void crearArchivoCursos()
            {
                try{       
                archivoSalida=new ObjectOutputStream(new FileOutputStream("archivoCursos.dat"));
                System.out.println("Se creó el archivo de cursos de forma correcta");
                }
                catch(Exception e)
                {
                 System.out.println("Error al crear archivo de cursos"+e);
                }

            }
     
     public boolean cargarArchivoCursos()
                {
                    boolean existe=false;
                    try{           

                    archivoEntrada=new ObjectInputStream(new FileInputStream("archivoCursos.dat"));
                    existe=true;
                    
                            }
                    catch(Exception e)
                    {
                        System.out.println("Error al cargar archivo cursos"+e);
                    }
                    return existe;
                }
     public void ingresarInformacionCursos(Cursos cursos)
        {
         try
         {
             archivoSalida.writeObject(cursos);
             System.out.println("Se escribió de forma correcta la información del archivo");
         }
         catch(Exception e)
         {
             System.out.println("Error al ingresar información al archivo"+e);
         }
        }
     
      public ArrayList<Cursos> devolverInformacionDeCursos()
        {
            ArrayList <Cursos> arrayCursos=new ArrayList<Cursos>();
            
            try
            {
              while(true)
              {
                  arrayCursos.add((Cursos)archivoEntrada.readObject());
              }
            }
            catch(Exception e)
            {
                System.out.println("Se llegó al final del archivo cursos");
            }
            
            return arrayCursos;
        }
        
        
        
}
