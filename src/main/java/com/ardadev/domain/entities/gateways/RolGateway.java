package com.ardadev.domain.entities.gateways;

import com.ardadev.domain.entities.Rol;

import java.util.List;

public interface RolGateway {
    void guardar(Rol rol);
    void actualizar(Rol rol);
    void eliminar(Rol rol);
    Rol encontrarPorId(Integer id);
    List<Rol> encontrarTodos();
}
