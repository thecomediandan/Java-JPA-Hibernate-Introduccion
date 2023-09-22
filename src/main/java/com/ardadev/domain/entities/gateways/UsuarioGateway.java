package com.ardadev.domain.entities.gateways;

import com.ardadev.domain.entities.Usuario;

import java.util.List;

public interface UsuarioGateway {
    void guardar(Usuario usuario);
    void actualizar(Usuario usuario);
    void eliminar(Usuario usuario);
    Usuario encontrarPorId(Integer id);
    List<Usuario> encontrarTodos();
}
