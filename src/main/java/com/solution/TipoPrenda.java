package com.solution;

import static java.util.Objects.requireNonNull;

import com.solution.enums.Categoria;
import com.solution.enums.Material;
import java.util.List;

public class TipoPrenda {

  public final String nombre;

  public final Categoria categoria;

  // Estilo
  protected final List<Material> materialesPosibles;

  public TipoPrenda(String nombre, Categoria categoria, List<Material> materialesPosibles) {
    this.nombre = requireNonNull(nombre, "Debe haber nombre del tipo de prenda.");
    this.categoria = requireNonNull(categoria, "Tipo de prenda debe tener una categoria");

    if (materialesPosibles.isEmpty()) {
      throw new RuntimeException("Debe haber al menos un material posible para el tipo de prenda.");
    }

    this.materialesPosibles = materialesPosibles;
  }

  public boolean puedeEstarHechoDe(Material unMaterial) {
    return materialesPosibles.contains(unMaterial);
  }

}
