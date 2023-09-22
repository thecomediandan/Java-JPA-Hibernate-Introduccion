package com.ardadev.domain.entities.gateways;

import com.ardadev.domain.entities.Nomina;

import java.util.List;

public interface NominaGateway {
    void guardar(Nomina nomina);
    void actualizar(Nomina nomina);
    void eliminar(Nomina nomina);
    Nomina encontrarPorId(Integer id);
    List<Nomina> encontrarTodos();
}
