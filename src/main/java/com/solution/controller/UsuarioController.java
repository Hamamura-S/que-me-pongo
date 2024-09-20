package com.solution.controller;

import com.solution.DTO.PrendaDTO;
import com.solution.model.Usuario;
import com.solution.model.guardarropas.Guardarropas;
import com.solution.model.prendas.Prenda;
import com.solution.repository.GuardarropasRepository;
import com.solution.repository.PrendaRepository;
import com.solution.repository.UsuarioRepository;
import com.solution.util.EntityManagerProvider;
import java.util.List;

public class UsuarioController {

  private final UsuarioRepository usuarioRepository;

  public UsuarioController(EntityManagerProvider entityManagerProvider) {
    usuarioRepository = new UsuarioRepository(entityManagerProvider);
  }

  // los GET pueden devolver 200 o 404

  // GET : /api/usuario/{id}/prendas
  public List<Prenda> obtenerPrendas(Long usuarioId) {
    Usuario usuario = usuarioRepository.buscarPorId(usuarioId);
    return usuario == null ? null : usuario.getPrendas();
  }

  // GET : /api/usuario/{id}/guardarropas/{idGuardarropas}/prendas
  public List<Prenda> obtenerPrendasPorGuardarropas(Long usuarioId, Long guardarropasId) {
    Usuario usuario = usuarioRepository.buscarPorId(usuarioId);
    return usuario == null ? null : usuario.getGuardarropas(guardarropasId).getPrendas();
  }

  // GET : /api/usuario/{id}/guardarropas/{idGuardarropas}/prendas/{idPrenda}
  public Prenda obtenerPrenda(Long id, Long idGuardarropas, Long idPrenda) {
    Usuario usuario = usuarioRepository.buscarPorId(id);
    if (usuario == null) {
      return null;
    }
    Guardarropas guardarropas = usuario.getGuardarropas(idGuardarropas);
    return guardarropas == null ? null : guardarropas.getPrenda(idPrenda);
  }

  // DELETE Devuelve 200 o 404

  // DELETE : /api/usuario/{id}/guardarropas/{idGuardarropas}/prendas/{idPrenda}
  /*
  * body success : {
  *   "id": 1,
  *   "tipo": 2,
  *   "material": 3,
  *   "colorPrimario": 4,
  * }
  * */
  public PrendaDTO eliminarPrenda(Long id, Long idGuardarropas, Long idPrenda) {
    Usuario usuario = usuarioRepository.buscarPorId(id);
    if (usuario == null) {
      return null;
    }
    Guardarropas guardarropas = usuario.getGuardarropas(idGuardarropas);
    if (guardarropas == null) {
      return null;
    }
    Prenda prenda = guardarropas.getPrenda(idPrenda);
    if (prenda == null) {
      return null;
    }
    guardarropas.removerPrenda(prenda);
    usuarioRepository.actualizar(usuario);
    return prenda.toDTO();
  }

}
