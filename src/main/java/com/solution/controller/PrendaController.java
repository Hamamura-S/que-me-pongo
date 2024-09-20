package com.solution.controller;

import com.solution.DTO.PrendaDTO;
import com.solution.model.prendas.Prenda;
import com.solution.model.prendas.TipoPrenda;
import com.solution.repository.PrendaRepository;
import com.solution.repository.Repository;
import com.solution.repository.TipoPrendaRepository;
import com.solution.util.EntityManagerProvider;
import java.util.List;

public class PrendaController {

  private final PrendaRepository prendaRepository;
  private final TipoPrendaRepository tipoPrendaRepository;

  public PrendaController(EntityManagerProvider entityManagerProvider) {
    prendaRepository = new PrendaRepository(entityManagerProvider);
    tipoPrendaRepository = new TipoPrendaRepository(entityManagerProvider);
  }

  public void agregarPrenda(PrendaDTO prendaData) throws IllegalArgumentException {
    Long tipoPrendaId = prendaData.getId();
    TipoPrenda tipoPrenda = tipoPrendaRepository.buscarPorId(tipoPrendaId);
    if (tipoPrenda == null) {
      throw new IllegalArgumentException("Tipo de prenda no existe");
    }
    Prenda prenda = new Prenda(
        tipoPrenda,
        prendaData.getMaterial(),
        prendaData.getColorPrimario(),
        prendaData.getTrama(),
        prendaData.getColorSecundario(),
        prendaData.getFormalidad(),
        prendaData.getTemperaturaLimite()
    );
    prendaRepository.guardar(prenda);
  }

}
