package entidades;
import java.util.Date;
import java.sql.*;
import java.io.*;

public class Usuario {

  Connection conn;
  Statement stmt;

  public Usuario(){
    try {
      String userName = "root"; //usuario de mysql
      String password = "password"; //password de mysql
      String url = "jdbc:mysql://162.243.134.61/test"; //test es el nombre de la base de datos
      Class.forName ("com.mysql.jdbc.Driver").newInstance();
      conn = DriverManager.getConnection (url, userName, password);
      stmt = conn.createStatement();
    }catch (Exception e) { System.out.println ("Cannot connect to database server"); }
  }

  public boolean existe(int usuario){
    try {
      stmt.executeQuery ("SELECT idUsuario FROM Usuario WHERE idUsuario = " + usuario);
       ResultSet rs = stmt.getResultSet();
       if (rs.next()) { //Va al primer registro si lo hay
        int idUsuario = rs.getInt ("idUsuario");
          rs.close(); 
          return( usuario == idUsuario );
       }else{ return false;}
    } catch (SQLException e) {}
      return false;
  }
}
