package br.com.projetoweb.dao;

import br.com.projetoweb.entity.Empresa;
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
public class EmpresaDAO implements Serializable{
    
    EntityManagerFactory emf;
    EntityManager em;

    public EmpresaDAO() {
        emf = Persistence.createEntityManagerFactory("ProjetoWeb1PU");
        em = emf.createEntityManager();
    }

    public void save(Empresa empresa) {
        em.getTransaction().begin();
        em.merge(empresa);
        em.getTransaction().commit();
        emf.close();
    }

    public void remove(Empresa empresa) {
        em.getTransaction().begin();
        Query q = em.createNativeQuery("Delete from empresa where id_empresa =" + empresa.getIdEmpresa());
        q.executeUpdate();
        em.getTransaction().commit();
        emf.close();
    }
    
    public List<Empresa> getAllEmpresas(){
        em.getTransaction().begin();
        Query consulta = em.createQuery("Select empresa from Empresa empresa");
        List<Empresa> listaempresa = consulta.getResultList();
        em.close();
        return listaempresa;
    }
}
