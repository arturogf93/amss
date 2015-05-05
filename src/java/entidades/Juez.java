package entidades;

import java.util.Date;
import java.sql.*;
import java.io.*;

public class Juez {
  Connection conn;
  Statement stmt;

  public Juez(){
    try {
      String userName = "root"; //usuario de mysql
      String password = "password"; //password de mysql
      String url = "jdbc:mysql://localhost:3306/test"; //test es el nombre de la base de datos
      Class.forName ("com.mysql.jdbc.Driver").newInstance();
      conn = DriverManager.getConnection (url, userName, password);
      stmt = conn.createStatement();
    }catch (Exception e) { System.out.println ("Cannot connect to database server"); }
  }

  public boolean existe(int juez){
    try {
      stmt.executeQuery ("SELECT idJuez FROM Juez WHERE idJuez = " + juez);
      ResultSet rs = stmt.getResultSet();
      if (rs.next()) { //Va al primer registro si lo hay
        int idJuez = rs.getInt ("idJuez");
        rs.close(); 
        return( juez == idJuez );
      }else{ return false;}
    } catch (SQLException e) {}
      return false;
  }

  public void eliminar(int juez){
    try{
      String s = "DELETE FROM Juez WHERE idJuez = " + juez;
      System.out.println(s);
      stmt.executeUpdate(s);
    }catch (Exception e) { System.out.println ("Cannot update database" + e ); }
  }

  public void crear(int usuario,int editorial){
      try {
        String s = "INSERT INTO Juez (idJuez,idEditorial)"+"VALUES ("+usuario+","+editorial+")";
        System.out.println(s);
        stmt.executeUpdate(s);
      } catch (SQLException e) {}
  }
}
