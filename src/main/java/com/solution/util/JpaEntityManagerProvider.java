package com.solution.util;

import javax.persistence.EntityManager;

public class JpaEntityManagerProvider implements EntityManagerProvider {

  /**
   * Usa JpaUtil para crear un EntityManager.
   *
   * @return EntityManager.
   */
  public EntityManager getEntityManager() {
    return JpaUtil.getEntityManagerFactory().createEntityManager();
  }

  @Override
  public void closeEntityManager() {
    JpaUtil.shutdown();
  }

}
