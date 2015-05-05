package controles;

import entidades.*;
import entidades.Articulo;
import entidades.Juez;
import entidades.Edicion;
import entidades.ArticuloJuez;

public class ControlVotar {

  Juez juez;
  Edicion edicion;
  Articulo articulo;
  ArticuloJuez artjuez;

  public ControlVotar() {
    articulo = new Articulo(); // Asume que la instancia persiste durante la sesion
    edicion = new Edicion();
    juez = new Juez();
    artjuez = new ArticuloJuez();
  }

  // Valida si la cuenta existe en la base de datos
  public boolean votar(int idJuez, int idEdicion, int idArt) {
    if ( juez.existe(idJuez) && edicion.existe(idEdicion) && articulo.existe(idArt) &&
        artjuez.puedo(idArt, idJuez) ){

      artjuez.seVoto(idArt, idJuez);

      return true;
    }
    else return false;
  }
}
