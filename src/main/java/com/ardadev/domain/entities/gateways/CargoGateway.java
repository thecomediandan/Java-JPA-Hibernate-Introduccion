package com.ardadev.domain.entities.gateways;

import com.ardadev.domain.entities.Cargo;

import java.util.List;

public interface CargoGateway {
    void guardar(Cargo cargo);
    void actualizar(Cargo cargo);
    void eliminar(Cargo cargo);
    Cargo encontrarPorId(Integer id);
    List<Cargo> encontrarTodos();
}
