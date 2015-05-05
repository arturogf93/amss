package controles;

import entidades.*;
import entidades.Editorial;
import entidades.Edicion;

public class ControlCreaEdicion {

  Editorial editorial;
  Edicion edicion;

  public ControlCreaEdicion() {
    editorial = new Editorial();
    edicion = new Edicion();
  }

  public boolean crearEdic(int idEdicion, int idEditorial){

    if(!edicion.existe(idEdicion) && editorial.existe(idEditorial)){
      edicion.crear(idEdicion,idEditorial);
      return true;
    }
    else return false;
  }
  }
