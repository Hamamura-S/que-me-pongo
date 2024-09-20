package com.solution.repository;

import com.solution.model.prendas.TipoPrenda;
import com.solution.util.EntityManagerProvider;

public class TipoPrendaRepository extends Repository<TipoPrenda, Long> {


  public TipoPrendaRepository(EntityManagerProvider emProvider, Class<TipoPrenda> entityClass) {
    super(emProvider, entityClass);
  }

  public TipoPrendaRepository(EntityManagerProvider emProvider) {
    super(emProvider, TipoPrenda.class);
  }

}
