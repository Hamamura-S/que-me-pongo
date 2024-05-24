package com.solution.guardarropas;

import com.solution.Usuario;
import com.solution.prendas.Prenda;
import java.util.List;

public class Guardarropas {

  private List<Prenda> prendas;
  private List<PropuestaModificacion> sugerenciasPendientes;
  private List<PropuestaModificacion> sugerenciasAceptadas;
  private Usuario owner;

  public Guardarropas(Usuario owner) {
    this.owner = owner;
  }

  public void recibirPropuesta(PropuestaModificacion propuesta) {
    sugerenciasPendientes.add(propuesta);
  }

  public void agregarPrenda(Prenda prenda) {
    prendas.add(prenda);
  }

  /**
   * Elimina una prenda del guardarropas.
   * @param unaPrenda prenda a eliminar.
   * @throws RuntimeException si la prenda no existia en el guardarropas.
   */
  public void removerPrenda(Prenda unaPrenda) {
    if (prendas.remove(unaPrenda)) {
      System.out.println("Se removió una prenda.");
    } else {
      throw new RuntimeException("La prenda no existía en el guardarropas.");
    }
  }

  public List<Prenda> getPrendas() {
    return prendas;
  }

  public List<PropuestaModificacion> verSugerenciasPendientes() {
    return sugerenciasPendientes;
  }

  public List<PropuestaModificacion> verSugerenciasAceptadas() {
    return sugerenciasAceptadas;
  }

}
