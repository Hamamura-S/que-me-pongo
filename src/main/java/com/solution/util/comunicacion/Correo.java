package com.solution.util.comunicacion;

import com.solution.model.Usuario;

public interface Correo {
  public void enviarCorreo(Usuario user, String cuerpo);
}
