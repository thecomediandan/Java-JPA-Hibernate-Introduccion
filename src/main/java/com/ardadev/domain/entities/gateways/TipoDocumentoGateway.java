package com.ardadev.domain.entities.gateways;

import com.ardadev.domain.entities.Pais;
import com.ardadev.domain.entities.TipoDocumento;

import java.util.List;

public interface TipoDocumentoGateway {
    void guardar(TipoDocumento tipoDocumento);
    void actualizar(TipoDocumento tipoDocumento);
    void eliminar(TipoDocumento tipoDocumento);
    TipoDocumento encontrarPorId(Integer id);
    List<TipoDocumento> encontrarTodos();
}
