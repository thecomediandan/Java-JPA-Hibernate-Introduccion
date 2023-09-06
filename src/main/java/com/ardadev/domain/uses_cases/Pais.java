package com.ardadev.domain.uses_cases;

import com.ardadev.domain.entities.gateways.PaisGateway;

import java.util.List;

public class Pais {
    private final PaisGateway paisGateway;
    public Pais(PaisGateway paisGateway){
        this.paisGateway = paisGateway;
    }

    public void guardar(com.ardadev.domain.entities.Pais pais) {
        paisGateway.guardar(pais);
    }
    public void actualizar(com.ardadev.domain.entities.Pais pais) {
        paisGateway.actualizar(pais);
    }
    public void eliminar(com.ardadev.domain.entities.Pais pais) {
        paisGateway.eliminar(pais);
    }

    public com.ardadev.domain.entities.Pais encontrarPorId(Integer id) {
        return paisGateway.encontrarPorId(id);
    }
    public List<com.ardadev.domain.entities.Pais> encontrarTodos() {
        return paisGateway.encontrarTodos();
    }
}
