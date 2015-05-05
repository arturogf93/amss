package controles;

import entidades.*;
import entidades.EditorJefe;
import entidades.Articulo;
import entidades.Edicion;

public class ControlAprobar {

  EditorJefe editorJefe;
  Articulo articulo;
  Edicion edicion;

  public ControlAprobar() {
    editorJefe = new EditorJefe();
    articulo = new Articulo();
    edicion = new Edicion();
  }

  public boolean aprobar(int idEdicion, int idArticulo, int idEditorJefe){

    if(edicion.existe(idEdicion) && articulo.existe(idArticulo) && editorJefe.existe(idEditorJefe) && articulo.sePuedeAprobar(idArticulo)){

      articulo.aprobarArt(idArticulo,idEditorJefe);
      return true;
    }
    else return false;
  }
}
