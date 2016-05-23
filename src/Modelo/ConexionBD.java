

package Modelo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;



public class ConexionBD {
    
    Connection con = null;
    String arregloInformacionConsultada[]=new String[2];
    String arregloInformacionCurso[]=new String[3];
    String arregloInformacionUsuario[]=new String[3];
    
    public ConexionBD()
    {
        realizarConexion();
    }
    public void realizarConexion()
    {
        try {
            String userName = "root";
            String password = "";
            String url = "jdbc:mysql://localhost:3306/casoprogramado";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(url, userName, password);
            System.out.println("Conexión Realizada");
        } catch (Exception e) {
            System.err.println("Cannot connect to database server");
            System.err.println(e.getMessage());
            e.printStackTrace();
        } 
    }
    public boolean registrarEstudiante(String arreglo[])
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("INSERT INTO estudiantes(cedula, nombre, direccion) VALUES ('"+arreglo[0]+"','"+arreglo[1]+"','"+arreglo[2]+"')");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
    
      public boolean registrarCurso(String arreglo[])
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("INSERT INTO cursos(sigla, nombre, creditos, horario) VALUES ('"+arreglo[0]+"','"+arreglo[1]+"','"+arreglo[2]+"','"+arreglo[3]+"')");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
    
      public boolean registrarUsuario(String arreglo[])
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("INSERT INTO usuarios(nombre, usuario, contraseña, tipo) VALUES ('"+arreglo[0]+"','"+arreglo[1]+"','"+arreglo[2]+"','"+arreglo[3]+"')");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
      
       public boolean registrarMatricula(String arreglo[])
    {
        ResultSet rs = null;
        Statement cmd = null;
        String codigo=arreglo[0];
        String cedula=arreglo[1];
        String sigla=arreglo[2];
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("INSERT INTO matricula(codigo, cedula, sigla) VALUES ('"+codigo+"','"+cedula+"','"+sigla+"')");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
      
    public boolean actualizarEstudiante(String arreglo[])
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("UPDATE `estudiantes` SET cedula='"+arreglo[0]+"',nombre='"+arreglo[1]+"',direccion='"+arreglo[2]+"' WHERE cedula='"+arreglo[0]+"'");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
    
     public boolean actualizarCursos(String sigla, String nombre, int creditos, String horario)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("UPDATE `cursos` SET sigla='"+sigla+"',nombre='"+nombre+"',creditos='"+creditos+"',horario='"+horario+"' WHERE sigla='"+sigla+"'");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
     
     public boolean actualizarUsuario(String arreglo[])
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("UPDATE `usuarios` SET nombre='"+arreglo[0]+"',usuario='"+arreglo[1]+"',contraseña='"+arreglo[2]+"',tipo='"+arreglo[3]+"' WHERE nombreUsuario='"+arreglo[1]+"'");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
     
     public boolean actualizarMatricula(String codigo, String cedula, String sigla)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("UPDATE `matricula` SET codigo='"+codigo+"',nombre='"+cedula+"',direccion='"+sigla+"' WHERE cedula='"+codigo+"'");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
    
     
     public boolean eliminarEstudiante(String cedula)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("DELETE FROM estudiantes WHERE cedula='"+cedula+"'");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
     public boolean eliminarCurso(String sigla)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("DELETE FROM cursos WHERE sigla='"+sigla+"'");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
     
      public boolean eliminarUsuario(String usuario)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("DELETE FROM usuarios WHERE nombreUsuario='"+usuario+"'");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
      
      public boolean eliminarMatricula(String codigo)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("DELETE FROM matricula WHERE codigo='"+codigo+"'");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
     
    public void consultarEstudiante(String cedula)
    {
        ResultSet rs = null;
        Statement cmd = null;

        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT * FROM estudiantes where cedula='"+cedula+"'");
                
                while (rs.next()) 
                {
                    String nombre = rs.getString("Nombre");
                    String direccion = rs.getString("direccion");
                    arregloInformacionConsultada[0]=nombre;
                    arregloInformacionConsultada[1]=direccion;
                    System.out.println("Información de la BD: "+nombre+" Direccion: "+direccion); 
                }
                rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
        
    }
    
    public boolean consultarEstudiantes(String cedula)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean encontro=false;

        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT * FROM estudiantes where cedula='"+cedula+"'");
                
                while (rs.next()) 
                {
                    String nombre = rs.getString("Nombre");
                    String direccion = rs.getString("direccion");
                    arregloInformacionConsultada[0]=nombre;
                    arregloInformacionConsultada[1]=direccion;
                    System.out.println("Información de la BD: "+nombre+" Direccion: "+direccion); 
                    encontro=true;
                }
                rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
        return encontro;
    }
     public void consultarCursos(String sigla)
    {
        ResultSet rs = null;
        Statement cmd = null;

        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT * FROM cursos where sigla='"+sigla+"'");
                
                while (rs.next()) 
                {
                    String nombre = rs.getString("nombre");
                    int creditos = rs.getInt("creditos");
                    String horario = rs.getString("horario");

                    
                    System.out.println("Información de la BD: "+nombre+" Creditos: "+creditos+" Horario: "+horario); 
                }
                rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
        
    }
     public boolean consultarCurso(String sigla)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean encontro=false;
        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT * FROM cursos where sigla='"+sigla+"'");
                
                while (rs.next()) 
                {
                    String nombre = rs.getString("nombre");
                    String creditos = rs.getString("creditos");
                    String horario = rs.getString("horario");
                    arregloInformacionCurso[0]=nombre;
                    arregloInformacionCurso[1]=creditos;
                    arregloInformacionCurso[2]=horario;
                    System.out.println("Información de la BD: "+nombre+" Creditos: "+creditos+" Horario: "+horario); 
                    encontro=true;
                }
                rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
        return encontro;
    }
     public boolean consultarUsuario(String nombreUsuario)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean encontro=false;
        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT * FROM usuarios where nombreUsuario='"+nombreUsuario+"'");
                
                while (rs.next()) 
                {
                    String nombreCompleto = rs.getString("nombre");
                    String contraseña = rs.getString("contraseña");
                    String tipo = rs.getString("tipo");
                    arregloInformacionUsuario[0]=nombreCompleto;
                    arregloInformacionUsuario[1]=contraseña;
                    arregloInformacionUsuario[2]=tipo;
                    System.out.println("Información de la BD: Usuario "+nombreCompleto+" Tipo: "+tipo); 
                    encontro=true;
                }
                rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
        return encontro;
    }
     
        public boolean consultarUsuarios(String arreglo[])
    {
        ResultSet rs = null;
        Statement cmd = null;
        String nombreUsuario=arreglo[0];
        String password=arreglo[1];        
        boolean encontroUsuario=false;
     
        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT * FROM usuarios where nombreUsuario='"+nombreUsuario+"'");
                
                while (rs.next()) 
                {
                  String usuario = rs.getString("usuario");
                  String contraseña = rs.getString("contraseña");
                  if(nombreUsuario.equals(usuario) && password.equals(contraseña))
                  {
                      encontroUsuario=true;
                  }
                        
                    
                    System.out.println("Información de la BD: Usuario "+usuario); 
                }
                rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
   
      
        return encontroUsuario;
    }
     
      public boolean consultarMatricula(String codigo)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean encontro=false;

        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT * FROM matricula where codigo='"+codigo+"'");
                
                while (rs.next()) 
                {
                    String cedula = rs.getString("cedula");
                    String sigla = rs.getString("sigla");
                    arregloInformacionConsultada[0]=cedula;
                    arregloInformacionConsultada[1]=sigla;
                    System.out.println("Información de la BD: "+cedula+" Direccion: "+sigla); 
                    encontro=true;
                }
                rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
        return encontro;
    }
      
        public String devolverCodigo()
    {
        ResultSet rs = null;
        Statement cmd = null;
        String filas= "";
        String codigo;
        
         try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT COUNT(codigo) FROM matricula");
                
                while (rs.next()) 
                {
                    filas=""+rs.getInt(1);
                   
                    System.out.println(filas); 
                }
                rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
        if(filas.equals(0))
        {
            codigo="1";
         }
       else
        {
            int numero=Integer.parseInt(filas);
            numero++;
            codigo=""+numero;
        }
        
        return codigo; 
    }
        
     public boolean comprobarUsuario()
     {
        ResultSet rs = null;
        Statement cmd = null;
        boolean hayUsuarios=false;
        String filas= "";
        String codigo;
        
         try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT COUNT(nombre) FROM usuarios");
                
                while (rs.next()) 
                {
                    filas=""+rs.getInt(1);
                    if(filas.equals("0"))
                    {                
                      hayUsuarios=false;
                    }else
                    {
                        hayUsuarios=true;
                    }
                    System.out.println(filas); 
                }
                rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
         return hayUsuarios;
     }
     
    
     
     public String[] getArregloInformacion()
    {
        return this.arregloInformacionConsultada;
    }
     
     public String[] getArregloInformacionCurso(){
         return arregloInformacionCurso;
     }
     public String[] getArregloInformacionUsuario()
    {
        return this.arregloInformacionUsuario;
    }
     
}
