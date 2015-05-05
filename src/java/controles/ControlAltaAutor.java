package controles;

import entidades.*;
import entidades.Autor;
import entidades.Usuario;
import entidades.Editorial;
import javax.servlet.annotation.WebServlet;

public class ControlAltaAutor {

  Autor autor;
  Usuario usuario;
  Editorial editorial;

  public ControlAltaAutor() {
    autor = new Autor();
    usuario = new Usuario();
    editorial = new Editorial();
  }

  public boolean Alta(int idUsuario,int idEditorial){
      autor.crear(idUsuario,idEditorial);
      return true;
  }
}
