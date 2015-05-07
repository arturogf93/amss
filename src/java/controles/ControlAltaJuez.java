package controles;

import entidades.*;
import entidades.Autor;
import entidades.Usuario;
import entidades.Juez;

public class ControlAltaJuez {

  Autor autor;
  Usuario usuario;
  Juez juez;

  public ControlAltaJuez() {
    autor = new Autor();
    usuario = new Usuario();
	 juez = new Juez();
  }

  public boolean AltaJuez(String nombre, String password){
    //if(usuario.existe(idUsuario) && editorial.existe(idEditorial) && autor.existe(idUsuario) && !juez.existe(idUsuario)){
	//	autor.altaJuez(idUsuario);
      juez.crear(nombre, password);
      return true;
    //}
    //else return false;
  }
}
