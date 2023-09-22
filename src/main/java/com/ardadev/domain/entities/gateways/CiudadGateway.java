package com.ardadev.domain.entities.gateways;

import com.ardadev.domain.entities.Ciudad;

import java.util.List;

public interface CiudadGateway {
    void guardar(Ciudad ciudad);
    void actualizar(Ciudad ciudad);
    void eliminar(Ciudad ciudad);
    Ciudad encontrarPorId(Integer id);
    List<Ciudad> encontrarTodos();
}
