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


   public class ArchivoEstudiantes {

       ObjectOutputStream archivoSalida;
       ObjectInputStream archivoEntrada;
       
       public ArchivoEstudiantes()
       {
          if(cargarArchivoEstudiantes()){
         System.out.println("El archivo Estudiantes se cargó correctamente");   
        }
        else
        {
          System.out.println("Error al cargar archivo");  
        }
       }

       public void crearArchivoEstudiantes()
            {
                try{       
                archivoSalida=new ObjectOutputStream(new FileOutputStream("archivoEstudiantes.dat"));
                System.out.println("Se creó el archivo de estudiantes de forma correcta");
                }
                catch(Exception e)
                {
                 System.out.println("Error al crear archivo estudiantes"+e);
                }

            }
       
       public void ingresarInformacionEstudiantes(Estudiante estudiante){
         try
         {
             archivoSalida.writeObject(estudiante);
             System.out.println("Se escribió de forma correcta la información del archivo");
         }
         catch(Exception e)
         {
             System.out.println("Error al ingresar información al archivo"+e);
         }
        }
       
        public boolean cargarArchivoEstudiantes()
                {
                    boolean existe=false;
                    try{           

                    archivoEntrada=new ObjectInputStream(new FileInputStream("archivoEstudiantes.dat"));
                    existe=true;
                    
                            }
                    catch(Exception e)
                    {
                        System.out.println("Error al cargar archivo estudiantes"+e);
                    }
                    return existe;
                }
        
        
        public ArrayList<Estudiante> devolverInformacionDeEstudiantes()
        {
            ArrayList <Estudiante> arrayEstudiantes=new ArrayList<Estudiante>();
            
            try
            {
              while(true)
              {
                  arrayEstudiantes.add((Estudiante)archivoEntrada.readObject());
              }
            }
            catch(Exception e)
            {
                System.out.println("Se llegó al final del archivo estudiantes");
            }
            
            return arrayEstudiantes;
        }
        
       
   }//Fin