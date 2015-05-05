package controles;

import entidades.*;
import entidades.Autor;
import entidades.Usuario;
import entidades.Editorial;
import entidades.Juez;

public class ControlAltaJuez {

  Autor autor;
  Usuario usuario;
  Editorial editorial;
  Juez juez;

  public ControlAltaJuez() {
    autor = new Autor();
    usuario = new Usuario();
    editorial = new Editorial();
	 juez = new Juez();
  }

  public boolean AltaJuez(int idUsuario,int idEditorial){
    if(usuario.existe(idUsuario) && editorial.existe(idEditorial) && autor.existe(idUsuario) && !juez.existe(idUsuario)){
		autor.altaJuez(idUsuario);
      juez.crear(idUsuario,idEditorial);
      return true;
    }
    else return false;
  }
}
