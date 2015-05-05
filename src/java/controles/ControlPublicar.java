package controles;
import entidades.*;
import entidades.Articulo;
import entidades.Autor;
import entidades.Edicion;
import entidades.ArticuloAutor;

public class ControlPublicar {
  Articulo articulo;
  Autor autor;
  Edicion edicion;
  ArticuloAutor artautor;

  public ControlPublicar(){
    articulo = new Articulo(); //Asume que la instancia persiste durante la sesion
    autor = new Autor();
    edicion = new Edicion();
    artautor = new ArticuloAutor();
  }

  //Valida si la cuenta existe en la base de datos
  public boolean puedoPublicar(int idAutor, int idEdicion){
    return(autor.existe(idAutor) && edicion.existe(idEdicion) && autor.puedoPublicar(idAutor));
  }

  //Implementa una regla de negocio;
  //no se puede extaer mas de $3000 en una transaccion
  public boolean publicar(int autorpub, int articulopub, String titulo, String fecha, int edicion, String contenido){
  if(articulo.publicar(articulopub,titulo,fecha,edicion,contenido)){
    artautor.publicar(articulopub,autorpub);
    autor.publicar(autorpub);
    return true;
    }else {
      return false; //No hay fondos suficientes en la cuenta
    }
  }
}
