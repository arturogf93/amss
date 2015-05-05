package entidades;
import java.util.Date;
import java.sql.*;
import java.io.*;

public class Autor {

  Connection conn;
  Statement stmt;

  public Autor(){
    try {
      String userName = "root"; //usuario de mysql.
      String password = "password"; //password de mysql.
      String url = "jdbc:mysql://162.243.134.61/test"; //test es el nombre de la base de datos.
      Class.forName ("com.mysql.jdbc.Driver").newInstance();
      conn = DriverManager.getConnection (url, userName, password);
      stmt = conn.createStatement();
    }catch (Exception e) { System.out.println ("Cannot connect to database server"); }
  }

  public boolean existe(int autor){
    try {
      stmt.executeQuery ("SELECT idUsuario FROM Autor WHERE idUsuario = " + autor);
       ResultSet rs = stmt.getResultSet();
       if (rs.next()) { //Va al primer registro si lo hay
        int idAutor = rs.getInt ("idUsuario");
          rs.close(); 
          return( autor == idAutor );
       }else{ return false;}
    } catch (SQLException e) {}
      return false;
  }

  public boolean puedoPublicar(int autor){
    try {
      stmt.executeQuery ("SELECT publicar FROM Autor WHERE idUsuario = " + autor);
      ResultSet rs = stmt.getResultSet();
      if (rs.next()){
        boolean publicar = rs.getBoolean ("publicar");
        rs.close();
        return (publicar);
      }else{ return false;}
    } catch (SQLException e) {	}
      return false;
  }

  public void publicar(int autor){
    try{
      String s = "UPDATE Autor SET publicar ="+false+""+
              "WHERE idAutor = "+autor;
      System.out.println(s); 
      stmt.executeUpdate(s);
    }catch (Exception e) { System.out.println ("Cannot update database" + e ); }
  }
  
  public void crear(int usuario,int editorial){
    try {
      String s = "INSERT INTO Test (nombre,editorial)"+"VALUES ("+usuario+","+editorial+")";
      System.out.println(s);
      stmt.executeUpdate(s);
    } catch (SQLException e) {
    }
  }
	public void altaJuez(int usuario){
		try {
			String s = "UPDATE Autor SET publicar ="+false+""+
			              "WHERE idAutor = "+usuario;
			System.out.println(s); 
			stmt.executeUpdate(s);
		} catch (Exception e) {
		}
	}
  /*
  public void nominarJuez(int idJuez) {

  }

  public void altaJuez() {

  }

  public void generarArticulo(int idEdicion) {

  }*/
}
