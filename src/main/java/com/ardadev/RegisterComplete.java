package com.ardadev;

import com.ardadev.domain.entities.*;
import com.ardadev.infrastructure.driven_adapter.dao.*;
import com.ardadev.infrastructure.helper.JPAUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class RegisterComplete {
    public static void main(String[] args) {
        Pais pais = new Pais("BOLIVIA");
        Departamento departamento = new Departamento("LA PAZ");
        Ciudad ciudad = new Ciudad("EL ALTO");
        TipoDocumento tipoDocumento = new TipoDocumento("CEDULA DE IDENTIDAD");
        Rol rol = new Rol("USER");
        Cargo cargo = new Cargo("DESARROLLADOR DE SOFTWARE");
        Nomina nomina = new Nomina("NOMINA DE PAGOS DE SUELDOS 2023", 1);
        Usuario usuario = new Usuario(
                "DANIEL",
                "QUISPE KUNO",
                "9230005",
                "danqk@outlook.com",
                "isuabndfpisasdfe",
                "VILLA DOLORES, EL ALTO",
                120000000.0,
                Activo.ACTIVO
        );
        DetalleNomina detalleNomina = new DetalleNomina(30);
        usuario.addDetalleNominaList(detalleNomina);
        detalleNomina.calcularNetoPagar();

        tipoDocumento.addUsuarioList(usuario);
        cargo.addUsuariosCollection(usuario);
        ciudad.addUsuarioList(usuario);

        departamento.addCiudadList(ciudad);

        pais.addDepartamentoList(departamento);
        nomina.addDetalleNominaList(detalleNomina);

        EntityManager em = JPAUtils.getEntityManager();
        CargoDao cargoDao = new CargoDao(em);
        CiudadDao ciudadDao = new CiudadDao(em);
        DepartamentoDao departamentoDao = new DepartamentoDao(em);
        DetalleNominaDao detalleNominaDao = new DetalleNominaDao(em);
        NominaDao nominaDao = new NominaDao(em);
        PaisDao paisDao = new PaisDao(em);
        RolDao rolDao = new RolDao(em);
        TipoDocumentoDao tipoDocumentoDao = new TipoDocumentoDao(em);
        UsuarioDao usuarioDao = new UsuarioDao(em);

        EntityTransaction tx = em.getTransaction();
        // Empezando transacción de llenado de tablas
        tx.begin();
        cargoDao.guardar(cargo);
        ciudadDao.guardar(ciudad);
        departamentoDao.guardar(departamento);
        detalleNominaDao.guardar(detalleNomina);
        nominaDao.guardar(nomina);
        paisDao.guardar(pais);
        tipoDocumentoDao.guardar(tipoDocumento);
        usuarioDao.guardar(usuario);
        rolDao.guardar(rol);
        tx.commit();

        UsuariosHasRoles usuariosHasRoles = new UsuariosHasRoles();
        usuariosHasRoles.setActivo(Activo.ACTIVO);

        rol.addUsuariosHasRolesList(usuariosHasRoles);
        usuario.addUsuariosHasRolesList(usuariosHasRoles);

        usuariosHasRoles.getUsuariosHasRolesPK().setRolId(rol.getId());
        usuariosHasRoles.getUsuariosHasRolesPK().setUsuarioId(usuario.getId());

        UsuariosHasRolesDao usuariosHasRolesDao = new UsuariosHasRolesDao(em);
        // Empezando transacción de llenado de la tabla de relacion UsuarioHasRoles
        tx.begin();
        usuariosHasRolesDao.guardar(usuariosHasRoles);

        rolDao.actualizar(rol);
        usuarioDao.actualizar(usuario);
        tx.commit();
        em.close();
    }
}
