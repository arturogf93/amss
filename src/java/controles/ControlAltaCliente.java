package controles;

import entidades.*;
import entidades.Autor;
import entidades.Usuario;
import javax.servlet.annotation.WebServlet;

public class ControlAltaCliente {

  Cliente cliente;

  public ControlAltaCliente() {
    cliente = new Cliente();

  }

  public boolean Alta(String nombre, String direccion, String usuario, String password, int copia){
      cliente.crear(nombre, direccion, usuario, password, copia);
      return true;
  }
}
