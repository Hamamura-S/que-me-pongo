package com.solution.repository;


import com.solution.model.prendas.Prenda;
import com.solution.util.EntityManagerProvider;
import java.util.List;
import javax.persistence.EntityManager;

public class PrendaRepository extends Repository<Prenda, Long> {

  public PrendaRepository(EntityManagerProvider emProvider, Class<Prenda> entityClass) {
    super(emProvider, entityClass);
  }

  public PrendaRepository(EntityManagerProvider emProvider) {
    super(emProvider, Prenda.class);
  }


}
