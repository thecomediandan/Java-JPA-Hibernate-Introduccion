package com.ardadev.domain.entities.gateways;

import com.ardadev.domain.entities.Departamento;

import java.util.List;

public interface DepartamentoGateway {
    void guardar(Departamento departamento);
    void actualizar(Departamento departamento);
    void eliminar(Departamento departamento);
    Departamento encontrarPorId(Integer id);
    List<Departamento> encontrarTodos();
}
