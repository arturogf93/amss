package entidades;
import java.util.Date;
import java.sql.*;
import java.io.*;

public class Edicion {

  Connection conn;
  Statement stmt;

  public Edicion(){
    try {
      String userName = "root"; //usuario de mysql
      String password = "password"; //password de mysql
      String url = "jdbc:mysql://162.243.134.61/test"; //test es el nombre de la base de datos
      Class.forName ("com.mysql.jdbc.Driver").newInstance();
      conn = DriverManager.getConnection (url, userName, password);
      stmt = conn.createStatement();
    }catch (Exception e) { System.out.println ("Cannot connect to database server"); }
  }

  public boolean existe(int edicion){
    try {
      stmt.executeQuery ("SELECT idEdicion FROM Edicion WHERE idEdicion = " + edicion);
       ResultSet rs = stmt.getResultSet();
       if (rs.next()) { //Va al primer registro si lo hay
        int idEdicion = rs.getInt ("idEdicion");
          rs.close(); 
          return( edicion == idEdicion );
       }else{ return false;}
    } catch (SQLException e) {}
      return false;
    }

  public void crear(int idEdicion, int idEditorial){
    try{
      String s = "INSERT INTO Edicion (idEdicion, idEditorial)" +
                  " VALUES ("+ idEdicion + " , " + idEditorial + " )";
       System.out.println(s); 
       stmt.executeUpdate(s);
    }catch (Exception e) { System.out.println ("Cannot update database" + e ); }
  }

  public void publicar() {

  }

  public void actualizarEdicion() {

  }
}
