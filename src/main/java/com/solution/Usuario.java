package com.solution;

import static java.util.Objects.requireNonNull;

import com.google.common.collect.Lists;
import com.solution.enums.Categoria;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Usuario {

  protected List<Prenda> guardarropas;
  protected List<BorradorPrenda> borradoresPrendas;
  protected List<Atuendo> atuendos;
  protected List<Sugerencia> sugerencias = new ArrayList<>();

  /**
   * La nueva instancia de borrador se retorna y ademas se guarda en el usuario.
   * Los cambios efectuados se reflejan en la instancia ya almacenada.
   * @param tipo el tipo de la prenda de TipoPrenda.
   * @return Borrador
   */
  public BorradorPrenda nuevaPrenda(TipoPrenda tipo) {
    BorradorPrenda newBorradorPrenda = new BorradorPrenda(tipo);
    borradoresPrendas.add(newBorradorPrenda);
    return newBorradorPrenda;
  }

  /**
   * Elimina el borrador y carga la nueva prenda en el guardarropas.
   * @param borradorPrenda sus datos deberan estar cargados.
   */
  public void guardarPrenda(BorradorPrenda borradorPrenda) {
    Prenda newPrenda = borradorPrenda.build();
    borradoresPrendas.remove(borradorPrenda);
    guardarropas.add(newPrenda);
  }

  /**
   * Elimina una prenda del guardarropas.
   * @param unaPrenda prenda a eliminar.
   * @throws RuntimeException si la prenda no existia en el guardarropas.
   */
  public void removerPrenda(Prenda unaPrenda) {
    if (guardarropas.remove(unaPrenda)) {
      System.out.println("Se removió una prenda.");
    } else {
      throw new RuntimeException("La prenda no existía en el guardarropas.");
    }
  }

  public void recibirAtuendo(Atuendo unAtuendo) {
    atuendos.add(unAtuendo);
  }

  public List<Sugerencia> generarSugerencias() {
    List<Prenda> partesSuperiores = guardarropas.stream().filter(prenda -> prenda.getTipo().categoria == Categoria.PARTE_SUPERIOR).collect(Collectors.toList());
    List<Prenda> partesInferiores = guardarropas.stream().filter(prenda -> prenda.getTipo().categoria == Categoria.PARTE_INFERIOR).collect(Collectors.toList());
    List<Prenda> calzados = guardarropas.stream().filter(prenda -> prenda.getTipo().categoria == Categoria.CALZADO).collect(Collectors.toList());

    List<List<Prenda>> cartesianProduct = Lists.cartesianProduct(partesSuperiores, partesInferiores, calzados);

    List<Sugerencia> sugerencias = new ArrayList<>();
    cartesianProduct.forEach(sugerencia -> sugerencias.add(
        new Sugerencia(
            sugerencia.get(0), //prenda superior
            sugerencia.get(1), //prenda inferior
            sugerencia.get(2)) //calzado
    ));

    return sugerencias;
  }

  //GETTERS
  public Prenda getPrenda(int index) {
    return guardarropas.get(index);
  }

  public BorradorPrenda getBorrador(int index) {
    return borradoresPrendas.get(index);
  }

}

