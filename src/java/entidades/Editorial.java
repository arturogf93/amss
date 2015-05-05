package entidades;
import java.util.Date;
import java.sql.*;
import java.io.*;

public class Editorial {

  Connection conn;
  Statement stmt;

  public Editorial(){
    try {
      String userName = "root"; //usuario de mysql
      String password = "password"; //password de mysql
      String url = "jdbc:mysql://162.243.134.61/test"; //test es el nombre de la base de datos
      Class.forName ("com.mysql.jdbc.Driver").newInstance();
      conn = DriverManager.getConnection (url, userName, password);
      stmt = conn.createStatement();
    }catch (Exception e) { System.out.println ("Cannot connect to database server"); }
  }

  public boolean existe(int editorial){
    try {
      stmt.executeQuery ("SELECT idEditorial FROM Editorial WHERE idEditorial = " + editorial);
       ResultSet rs = stmt.getResultSet();
       if (rs.next()) { //Va al primer registro si lo hay
        int idEditorial = rs.getInt ("idEditorial");
          rs.close(); 
          return( editorial == idEditorial);
       }else{ return false;}
    } catch (SQLException e) {}
      return false;
    }

  }
