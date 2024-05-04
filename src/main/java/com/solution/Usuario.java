package com.solution;

import static java.util.Objects.requireNonNull;

import com.solution.atuendos.Atuendo;
import com.solution.atuendos.Sugerencia;
import com.solution.motorSugerencias.MotorSugerencias;
import com.solution.motorSugerencias.MotorSugerenciasNormal;
import com.solution.prendas.BorradorPrenda;
import com.solution.prendas.Prenda;
import com.solution.prendas.TipoPrenda;
import java.util.ArrayList;
import java.util.List;


public class Usuario {

  protected List<Prenda> guardarropas = new ArrayList<>();
  protected List<BorradorPrenda> borradoresPrendas = new ArrayList<>();
  protected List<Atuendo> atuendos = new ArrayList<>();
  protected List<Sugerencia> sugerencias = new ArrayList<>();
  protected int edad;
  public MotorSugerencias motor;

  public Usuario(int edad, MotorSugerencias motor) {
    this.edad = edad;
    this.motor = motor;
  }

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

  /**
   * Utiliza el motor cargado actualmente para generar sugerencias con el guardarropas.
   */
  public void recibirSugerencias() {
    sugerencias.addAll(motor.generarSugerencias(guardarropas, this.edad));
  }

  //GETTERS
  public Prenda getPrenda(int index) {
    return guardarropas.get(index);
  }

  public BorradorPrenda getBorrador(int index) {
    return borradoresPrendas.get(index);
  }

  public int getEdad() {
    return edad;
  }

}

