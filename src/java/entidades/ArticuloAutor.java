package entidades;
import java.sql.*;
import java.io.*;

public class ArticuloAutor {
  Connection conn;
  Statement stmt;

  public ArticuloAutor(){
    try {
      String userName = "root"; //usuario de mysql
      String password = "password"; //password de mysql
      String url = "jdbc:mysql://localhost:3306/test"; //test es el nombre de la base de datos
      Class.forName ("com.mysql.jdbc.Driver").newInstance();
      conn = DriverManager.getConnection (url, userName, password);
      stmt = conn.createStatement();
    }catch (Exception e) { System.out.println ("Cannot connect to database server"); }
  }

  public void publicar(int articulo, int autor){
    try {
      String s = "INSERT INTO test (nombre)" +
                " VALUES ("+ articulo + " , " + autor + " )";
      System.out.println(s); 
      stmt.executeUpdate(s);
    }catch (Exception e) { System.out.println ("Cannot update database" + e ); }
  }
}
