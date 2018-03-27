/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parques;

/**
 *
 * @author alumno
 */

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Bd {
    private Connection con;
    private String url;
    private String usu;

    public Bd() {
     this.url = "jdbc:mysql://192.168.4.187:3310/parques";
        this.usu = "marcos";   
    }

    public Bd(String url, String usu) {
        this.url = url;
        this.usu = usu;
    }
    
    private void conectar(){
        try {
            con = (Connection) DriverManager.getConnection(url,usu,usu);
        } catch (SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     private void desconectar(){
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
       
     public String mostrarParquesPorCiudad(String ciu){
       conectar();
       String aux="";
         try {
            Statement s = (Statement) con.createStatement(); 
            ResultSet rs = s.executeQuery("select parque.nombre from parque , ciudad"
                    + " where ciudad.id=parque.idCiudad and ciudad.nombre='"+ciu+"';");
            while(rs.next()){
                aux+=rs.getString(1)+"\n";
            }
            desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aux;
     }
      public void añadirCiudad(String ciu){
       conectar();

         try {
            Statement s = (Statement) con.createStatement(); 
            s.executeUpdate("insert into ciudad values(0,'"+ciu+"');");
            desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
        }

     } 
      public void añadirParque(String ciu,String par,String ext){
       conectar();
         try {
            Statement s = (Statement) con.createStatement(); 
            Statement b = (Statement) con.createStatement(); 
            ResultSet rs =  b.executeQuery("select id from ciudad where nombre='"+ciu+"';");
            if(rs.first()){
            s.executeUpdate("insert into parque values(0,'"+par+"','"+ext+"',(select id from ciudad where nombre='"+ciu+"'));");
            }else{
                System.out.println("no existe la ciudad");
            }
            desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
        }
         

     } 
        public String mostrarParquesPorCadena(String ca){
       conectar();
       String aux="";
         try {
            Statement s = (Statement) con.createStatement(); 
            ResultSet rs = s.executeQuery("select nombre from parque where nombre like '%"+ca+"%';");
            while(rs.next()){
                aux+=rs.getString(1)+"\n";
            }
            desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aux;
     }
         public String contarParquesPorCiudad(String ciu){
       conectar();
       String aux="";
         try {
            Statement s = (Statement) con.createStatement(); 
            ResultSet rs = s.executeQuery("select count(*) from parque , ciudad"
                    + " where ciudad.id=parque.idCiudad and ciudad.nombre='"+ciu+"';");
            if(rs.first()){
                aux+=rs.getString(1);
            }
            desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aux;
     }
         public void borrarParque(String ciu){
       conectar();
         try {
            Statement s = (Statement) con.createStatement(); 
            s.executeUpdate("delete from parque where idCiudad IN (select id from ciudad where nombre = '"+ciu+"');");
            desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
        }
         

     } 
         public String mostrarCiudadesPorExtension(String ext){
       conectar();
       String aux="";
         try {
            Statement s = (Statement) con.createStatement(); 
            ResultSet rs = s.executeQuery("select distinct c.nombre from parque p , ciudad c where c.id=p.idCiudad and p.extension='"+ext+"';");
            if(rs.first()){
                aux+=rs.getString(1)+"\n";
            }
            desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aux;
     }
    
}
