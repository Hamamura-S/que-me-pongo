package com.solution;

import com.solution.enums.Material;
import com.solution.enums.Trama;
import static java.util.Objects.requireNonNull;

/**
 * Borrador de una Prenda.
 * Pueden guardarse para continuar despues. Solo requiere el tipo de prenda.
 * Utilizar build() para crear la prenda definitiva e inmutable.
 */
public class BorradorPrenda {

  protected final TipoPrenda tipo;
  protected Material material;  //obligatorio
  protected Color colorPrimario;  // obligatorio
  protected Trama trama = Trama.LISA;
  protected Color colorSecundario;

  public BorradorPrenda(TipoPrenda tipo) {
    this.tipo = tipo;
  }

  /**
   * Construye la prenda definitiva sobre el borrador.
   * @throws NullPointerException Si el borrador no posee color primario o material.
   * @return Prenda
   */
  public Prenda build() {
    return new Prenda(
        tipo,
        requireNonNull(material, "Se debe proveer un material antes de crear la prenda"),
        requireNonNull(colorPrimario, "Se debe proveer un color primario antes de crear la prenda."),
        trama,
        colorSecundario
    );
  }

  /**
   * Verifica que el material sea acorde al tipo de prenda seleccionado.
   * @param unMaterial Material de la prenda.
   * @throws RuntimeException Si el tipo de prenda no concuerda con el material.
   */
  public void setMaterial(Material unMaterial) {
    if (!(tipo.puedeEstarHechoDe(unMaterial))) {
      throw new RuntimeException("Este tipo de prenda no admite el material " + unMaterial.name());
    }
    this.material = unMaterial;
  }

  public void setColorPrimario(Color colorPrimario) {
    this.colorPrimario = colorPrimario;
  }

  public void setColorSecundario(Color colorSecundario) {
    this.colorSecundario = colorSecundario;
  }

  public void setTrama(Trama unaTrama) {
    this.trama = unaTrama;
  }

}
