package com.ardadev.domain.entities.gateways;

import com.ardadev.domain.entities.Pais;

import java.util.List;

public interface PaisGateway {
    void guardar(Pais pais);
    void actualizar(Pais pais);
    void eliminar(Pais pais);
    Pais encontrarPorId(Integer id);
    List<Pais> encontrarTodos();
    Pais encontrarPorNombre(String nombre);
    String encontrarNombrePorId(Integer id);
}
