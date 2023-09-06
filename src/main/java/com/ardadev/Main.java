package com.ardadev;

import com.ardadev.domain.entities.Departamento;
import com.ardadev.infrastructure.driven_adapter.dao.PaisDao;
import com.ardadev.infrastructure.helper.JPAUtils;
import com.ardadev.domain.entities.Pais;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

// JPA es una especificación pero tiene sus implementaciones
// con Hibernate, EclipseLink, OpenJPA, etc
// Java 20
// Librerias:
// org.hibernate:hibernate-entitymanager:5.6.15.Final // implementacion de JPA
// com.h2database:h2:2.1.214 // para la base de datos h2, pero podemos usar cualquier otra
// el drive de h2 es org.h2.Driver
// mysql:mysql-connector-java:8.0.30 // nosotros usaremos la base de datos en mysql
// com.mysql.jdbc.Driver esta descontinuada usaremos com.mysql.cj.jdbc.Driver
// instalamos los siguientes plugins de ayuda Database Navigator, Hibernate Inspector, JPA Buddy

// Ciclo de Vida de JPA
// Transient: Cuando instanciamos una entidad (new)
// Managed: Cuando abrimos la transaccion del Entity Manager y utilizamos el metodo persist(), en vez o despues de este estado podemos usar merge() para actualizar o modificar los datos haciendo un select
//      Detached: Cuando usamos los metodos del Entity Manager clear, detach o close para desaclopar la entidad
//      Removed: Una vez administrado podemos eliminar la entidad
// BD: Cuando llegamos a persistir o usar la base de datos con commit(guardado forsozo), flush(comparamos la base de datos y si hay error nos lo dice y no persiste la entidad), find, query
public class Main {
    public static void main(String[] args) {
        // con new estamos en estado transient
        //Departamento departamento = new Departamento();
        //departamento.setNombre("Potosi");

        EntityManager em = JPAUtils.getEntityManager();
        PaisDao paisDao = new PaisDao(em);
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        // Con persist estamos en estado managed
        System.out.println(paisDao.encontrarNombrePorId(1));
        //Manera de agregar un departamento y asignarle la clave foranea de Pais
        //departamento.setPais(paisDao.encontrarPorId(1));
        //em.persist(departamento);
        tx.commit(); // Con commit, flush, find, query accedemos cambios a la base de datos
        em.flush(); // Con flush sincronizamos la base de datos
        em.close(); //  cerramos la conexion con la base de datos, ademas volvemos a pasar a estado transient
        // tambien pasamos a estado transient coin clear, detach para desacoplar la entidad
    }

}