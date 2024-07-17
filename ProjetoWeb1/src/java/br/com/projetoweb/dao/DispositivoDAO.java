package br.com.projetoweb.dao;

import br.com.projetoweb.entity.Dispositivo;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Arena
 */
public class DispositivoDAO implements Serializable{

    EntityManagerFactory emf;
    EntityManager em;

    public DispositivoDAO() {
        emf = Persistence.createEntityManagerFactory("ProjetoWeb1PU");
        em = emf.createEntityManager();
    }

    public void save(Dispositivo dispositivo) {
        em.getTransaction().begin();
        em.merge(dispositivo);
        em.getTransaction().commit();
        emf.close();
    }

    public void remove(Dispositivo dispositivo) {
        em.getTransaction().begin();
        Query q = em.createNativeQuery("Delete from dispositivo where id_dispositivo =" + dispositivo.getIdDispositivo());
        q.executeUpdate();
        em.getTransaction().commit();
        emf.close();
    }

    public List<Dispositivo> getAllDispositivos() {
        em.getTransaction().begin();
        Query consulta = em.createQuery("Select dispositivo from Dispositivo dispositivo");
        List<Dispositivo> listadispositivos = consulta.getResultList();
        em.close();
        return listadispositivos;
    }
}
