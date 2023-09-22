package com.ardadev.domain.entities.gateways;

import com.ardadev.domain.entities.DetalleNomina;

import java.util.List;

public interface DetalleNominaGateway {
    void guardar(DetalleNomina detalleNomina);
    void actualizar(DetalleNomina detalleNomina);
    void eliminar(DetalleNomina detalleNomina);
    DetalleNomina encontrarPorId(Integer id);
    List<DetalleNomina> encontrarTodos();
}
