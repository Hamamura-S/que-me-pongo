package com.solution.repository;

import com.solution.model.guardarropas.Guardarropas;
import com.solution.util.EntityManagerProvider;

public class GuardarropasRepository extends Repository<Guardarropas, Long> {


  public GuardarropasRepository(EntityManagerProvider emProvider, Class<Guardarropas> entityClass) {
    super(emProvider, entityClass);
  }

  public GuardarropasRepository(EntityManagerProvider emProvider) {
    super(emProvider, Guardarropas.class);
  }

}
