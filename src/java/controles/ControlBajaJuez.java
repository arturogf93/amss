package controles;

import entidades.*;
import entidades.Juez;

public class ControlBajaJuez {

  Juez juez;

  public ControlBajaJuez() {
    juez = new Juez();
  }

  public boolean BajaJuez(int idJuez){

    if(juez.existe(idJuez)){
      juez.eliminar(idJuez);
      return true;
    }
    return false;
  }
}
