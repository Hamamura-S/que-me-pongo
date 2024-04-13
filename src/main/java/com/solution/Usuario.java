package com.solution;

import com.solution.enums.Categoria;
import com.solution.enums.Material;
import java.util.List;

public class Usuario {

  /*TIENE SENSIBILIDADES RESPECTO DE FACTORES CLIMATICOS Y GUSTOS - no implementado*/

  protected List<Prenda> guardarropas;

  protected List<Atuendo> atuendos;

  //GETTERS
  public List<Prenda> getGuardarropas() {
    return guardarropas;
  }

  /*-------------------------*/

  public void cargarPrenda(Material material, Color colorPrimario, String nombre, Categoria categoria) {
    TipoPrenda tipo = new TipoPrenda(nombre, categoria);
    Prenda unaPrenda = new Prenda(material, colorPrimario, tipo);
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

}
