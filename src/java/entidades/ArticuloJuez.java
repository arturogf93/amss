package entidades;
import java.sql.*;
import java.io.*;

public class ArticuloJuez {
  Connection conn;
  Statement stmt;

  public ArticuloJuez(){
    try {
      String userName = "root"; //usuario de mysql
      String password = "password"; //password de mysql
      String url = "jdbc:mysql://localhost:3306/test"; //test es el nombre de la base de datos
      Class.forName ("com.mysql.jdbc.Driver").newInstance();
      conn = DriverManager.getConnection (url, userName, password);
      stmt = conn.createStatement();
    }catch (Exception e) { System.out.println ("Cannot connect to database server"); }
  }

  public void seVoto(int articulo, int juez){
    try {
      String s = "INSERT INTO ArticuloJuez (idArticulo, idJuez)" +
                " VALUES ("+ articulo + " , " + juez + " )";
      System.out.println(s); 
      stmt.executeUpdate(s);
    }catch (Exception e) { System.out.println ("Cannot update database" + e ); }
  }

  public boolean puedo(int articulo, int juez){
    try {
      stmt.executeQuery ("SELECT COUNT(*) AS hay,idArticulo, idJuez FROM ArticuloJuez WHERE idJuez = " + juez + " AND idArticulo = " + articulo);
      ResultSet rs = stmt.getResultSet();
      if (rs.next()) { //Va al primer registro si lo hay
        int hay = rs.getInt("hay");
        rs.close(); 
        return(hay==0);
      }
    }catch (SQLException e) {}
      return true;
  }

}
