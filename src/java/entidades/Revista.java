package entidades;
import java.util.Date;
import java.sql.*;
import java.io.*;

public class Revista {

  Connection conn;
  Statement stmt;

  public Revista(){
    try {
      String userName = "root"; //usuario de mysql.
      String password = "password"; //password de mysql.
      String url = "jdbc:mysql://localhost:3306/test"; //test es el nombre de la base de datos.
      Class.forName ("com.mysql.jdbc.Driver").newInstance();
      conn = DriverManager.getConnection (url, userName, password);
      stmt = conn.createStatement();
    }catch (Exception e) { System.out.println ("Cannot connect to database server"); }
  }

  
  public void crear(String titulo, int numero){
      //String test = "45";
    try {
      String s = "INSERT INTO Revista (titulo, numero)"+"VALUES ('"+titulo+"',"+numero+")";
      System.out.println(s);
      stmt.executeUpdate(s);
    } catch (SQLException e) {
    }
  }
	

}
