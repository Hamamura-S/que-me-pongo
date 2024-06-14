package com.solution.comunicacion;

import com.solution.Usuario;

public interface Correo {
  public void enviarCorreo(Usuario user, String cuerpo);
}
