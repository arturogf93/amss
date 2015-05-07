package controles;

import entidades.*;
import entidades.Autor;
import entidades.Usuario;
import javax.servlet.annotation.WebServlet;

public class ControlAltaRevista {

  Revista revista;

  public ControlAltaRevista() {
    revista = new Revista();
  }

  public boolean Alta(String titulo, int numero){
      revista.crear(titulo, numero);
      return true;
  }
}
