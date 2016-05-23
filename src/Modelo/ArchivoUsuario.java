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


public class ArchivoUsuario {
    ObjectOutputStream archivoSalida;
    ObjectInputStream archivoEntrada;
    
    public boolean verificarExistenciaDeArchivoDeUsuarios()
    {
        boolean existeArchivo=true;
        try{
        archivoEntrada=new ObjectInputStream(new FileInputStream("usuarios.dat"));
        }
        catch(Exception e)
        {
            existeArchivo=false;
            System.out.println("Error al cargar el archivo de Usuarios: "+e);
        }
            
        return existeArchivo;
    }
    
    
    
    public ArchivoUsuario()
    {
            try{
           archivoEntrada=new ObjectInputStream(new FileInputStream("usuarios.dat"));
           }
           catch(Exception e)
           {

           }
       }
       public void crearArchivo()
       {
           try{
               archivoSalida=new ObjectOutputStream(new FileOutputStream("usuarios.dat"));
           }
           catch(Exception e)
           {

           } 
       }
       
       public boolean cargarArchivoUsuarios()
                {
                    boolean existe=false;
                    try{           

                    archivoEntrada=new ObjectInputStream(new FileInputStream("usuarios.dat"));
                    existe=true;
                    
                            }
                    catch(Exception e)
                    {
                        System.out.println("Error al cargar archivo usuarios"+e);
                    }
                    return existe;
                }
        
       
       public void crearArchivoUsuarios()
            {
                try{       
                archivoSalida=new ObjectOutputStream(new FileOutputStream("usuarios.dat"));
                System.out.println("Se creó el archivo de usuarios de forma correcta");
                }
                catch(Exception e)
                {
                 System.out.println("Error al crear archivo usuarios"+e);
                }

            }
       
       public void escribirInformacionEnArchivo(Usuarios usuarios)
       {
           try
           {
               archivoSalida.writeObject(usuarios);
           }
           catch(Exception e)
           {

           }
       }
       
       public void crearArchivoEUsuario()
            {
                try{       
                archivoSalida=new ObjectOutputStream(new FileOutputStream("usuarios.dat"));
                System.out.println("Se creó el archivo de usuarios de forma correcta");
                }
                catch(Exception e)
                {
                 System.out.println("Error al crear archivo usuarios"+e);
                }

            }
       
       
       public ArrayList<Usuarios> devolverInformacionDeUsuarios()
        {
            ArrayList <Usuarios> arrayUsuarios=new ArrayList<Usuarios>();
            
            try
            {
              while(true)
              {
                  arrayUsuarios.add((Usuarios)archivoEntrada.readObject());
              }
            }
            catch(Exception e)
            {
                System.out.println("Se llegó al final del archivo usuarios");
            }
            
            return arrayUsuarios;
        }
       
        public void ingresarInformacionUsuarios(Usuarios usuarios){
         try
         {
             archivoSalida.writeObject(usuarios);
             System.out.println("Se escribió de forma correcta la información del archivo");
         }
         catch(Exception e)
         {
             System.out.println("Error al ingresar información al archivo"+e);
         }
        }
        
       
       public Usuarios[] devolverInformacionDelArchivoComoArreglo()
       {
           int tamano=devolverTamanoDelArchivo();
           Usuarios arregloUsuarios[]=new Usuarios[tamano];
           try
           {
               archivoEntrada=new ObjectInputStream(new FileInputStream("usuarios.dat"));
               for(int contador=0;contador<tamano;contador++)
               {
                   arregloUsuarios[contador]=(Usuarios)archivoEntrada.readObject();
               }
           }
           catch(Exception e)
           {
               System.out.println("error al devolver informacion del archivo como arreglo.");
           }  
           return arregloUsuarios;
       }
       public int devolverTamanoDelArchivo()
       {
           int contador=0;
           Usuarios temporal;
           try
           {

               while(true)
               {
                 temporal=(Usuarios)archivoEntrada.readObject();
                 contador++;
                 System.out.println("paso x aqui");
               }
           }
           catch(Exception e)
           {
               System.out.println("error al devolver tamaño del archivo."+e);

           }
           return contador;
       }
    }
