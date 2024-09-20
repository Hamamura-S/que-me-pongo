package com.solution.controller;

import com.solution.model.Usuario;
import com.solution.model.prendas.Prenda;
import com.solution.repository.PrendaRepository;
import com.solution.repository.UsuarioRepository;
import com.solution.util.EntityManagerProvider;
import java.util.List;

public class UsuarioController {

  private final UsuarioRepository usuarioRepository;

  public UsuarioController(EntityManagerProvider entityManagerProvider) {
    usuarioRepository = new UsuarioRepository(entityManagerProvider);
  }

  public List<Prenda> obtenerPrendas(Long id) {
    Usuario usuario = usuarioRepository.buscarPorId(id);
    return usuario == null ? null : usuario.getPrendas();
  }

}
