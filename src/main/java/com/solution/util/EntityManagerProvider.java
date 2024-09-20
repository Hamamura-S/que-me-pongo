package com.solution.util;

import javax.persistence.EntityManager;

public interface EntityManagerProvider {

  public EntityManager getEntityManager();

  void closeEntityManager();

}
