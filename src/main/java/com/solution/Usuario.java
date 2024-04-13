package com.solution;

import static java.util.Objects.requireNonNull;

import com.solution.enums.Material;
import com.solution.enums.Trama;
import java.util.List;

public class Usuario {

  /*TIENE SENSIBILIDADES RESPECTO DE FACTORES CLIMATICOS Y GUSTOS - no implementado*/

  protected List<Prenda> guardarropas;

  protected List<Atuendo> atuendos;

  protected Prenda ultimaPrendaCreada;

  /*BONUS I2*/
  protected List<Uniforme> uniformesSugeridos;

  //GETTERS
  public List<Prenda> getGuardarropas() {
    return guardarropas;
  }

  public Prenda getUltimaPrendaCreada() {
    return ultimaPrendaCreada;
  }

  /*-------------------------*/

  public Prenda crearPrenda(TipoPrenda tipo) {
    return new Prenda(tipo); //borrador
  }

  public void guardarBorrador(Prenda unaPrenda) {
    ultimaPrendaCreada = unaPrenda;
  }

  public void definirMaterial(Prenda unaPrenda, Material unMaterial) {
    unaPrenda.setMaterialSeguro(unMaterial);
  }

  public void definirColorPrimario(Prenda unaPrenda, Color unColor) {
    unaPrenda.setColorPrimario(unColor);
  }

  public void definirColorSecundario(Prenda unaPrenda, Color unColor) {
    unaPrenda.setColorSecundario(unColor);
  }

  public void definirTrama(Prenda unaPrenda, Trama unaTrama) {
    unaPrenda.setTrama(unaTrama);
  }

  //se agrega al guardarropas solo si es valida
  public void guardarPrenda(Prenda unaPrenda) {
    requireNonNull(unaPrenda.getColorPrimario(), "La prenda no tiene color primario aún.");
    requireNonNull(unaPrenda.getMaterial(), "La prenda no tiene material aún.");
    System.out.println("Se guardó una prenda de tipo " + unaPrenda.getNombre());
    System.out.println("Compuesta de " + unaPrenda.getMaterial());
    System.out.println("Y de color " + unaPrenda.getColorPrimario());
    guardarropas.add(unaPrenda);
  }

  public void removerPrenda(Prenda unaPrenda) {
    if (guardarropas.remove(unaPrenda)) {
      System.out.println("Se removió una prenda.");
    } else {
      System.out.println("La prenda no existía en el guardarropas.");
    }
  }

  public void solicitarAtuendo() {
    Atuendo nuevoAtuendo = Servidor.generarAtuendo(this);
    atuendos.add(nuevoAtuendo);
  }

  /*BONUS I2*/
  public void recibirSugerenciasUniformes(List<Uniforme> uniformesSugeridos) {
    this.uniformesSugeridos.addAll(uniformesSugeridos);
  }

}

public class Administrador extends Usuario {

  public Uniforme crearUniforme(String colegio, TipoPrenda tipoSuperior, TipoPrenda tipoInferior, TipoPrenda tipoCalzado) {
    return new Uniforme(colegio, tipoSuperior, tipoInferior, tipoCalzado);
  }

}
