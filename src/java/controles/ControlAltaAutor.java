package controles;

import entidades.*;
import entidades.Autor;
import entidades.Usuario;
import javax.servlet.annotation.WebServlet;

public class ControlAltaAutor {

  Autor autor;
  Usuario usuario;

  public ControlAltaAutor() {
    autor = new Autor();
    usuario = new Usuario();
  }

  public boolean Alta(String autorNombre, String titulo, int idRevista){
      autor.crear(autorNombre, titulo, idRevista);
      return true;
  }
}
