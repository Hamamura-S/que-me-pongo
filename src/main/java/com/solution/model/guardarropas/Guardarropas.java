package com.solution.model.guardarropas;

import com.solution.model.prendas.Prenda;
import java.util.ArrayList;
import java.util.List;

public class Guardarropas {

  private Long id;
  private List<Prenda> prendas = new ArrayList<>();
  private List<PropuestaModificacion> sugerenciasPendientes;
  private List<PropuestaModificacion> sugerenciasAceptadas;
  private String categoria;

  public void tieneSugerencia(PropuestaModificacion propuesta) {
    if (! sugerenciasPendientes.contains(propuesta)) {
      throw new RuntimeException("No existia la propuesta xd");
    }
  }

  public void recibirPropuesta(PropuestaModificacion propuesta) {
    sugerenciasPendientes.add(propuesta);
  }

  public void removerPropuesta(PropuestaModificacion propuesta) {
    sugerenciasPendientes.remove(propuesta);
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

  public void setCategoria(String categoria) {
    this.categoria = categoria;
  }

  public String getCategoria() {
    return categoria;
  }

  public void setPrendas(List<Prenda> prendas) {
    this.prendas = prendas;
  }

  public List<Prenda> getPrendas() {
    return prendas;
  }

  public Prenda getPrenda(Long idPrenda) {
    return prendas.stream().filter(prenda -> prenda.getId().equals(idPrenda)).findFirst().orElse(null);
  }

  public List<PropuestaModificacion> getSugerenciasPendientes() {
    return sugerenciasPendientes;
  }

  public List<PropuestaModificacion> getSugerenciasAceptadas() {
    return sugerenciasAceptadas;
  }

  public Long getId() {
    return id;
  }

}
