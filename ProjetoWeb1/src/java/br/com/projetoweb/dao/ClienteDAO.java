package br.com.projetoweb.dao;

import br.com.projetoweb.entity.Cliente;
import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Arena
 */
public class ClienteDAO implements Serializable{

    EntityManagerFactory emf;
    EntityManager em;

    public ClienteDAO() {
        emf = Persistence.createEntityManagerFactory("ProjetoWeb1PU");
        em = emf.createEntityManager();
    }

    public void save(Cliente cliente) {
        em.getTransaction().begin();
        em.merge(cliente);
        em.getTransaction().commit();
        emf.close();
    }

    public void remove(Cliente cliente) {
        em.getTransaction().begin();
        Query q = em.createNativeQuery("Delete from cliente where id_cliente =" + cliente.getIdCliente());
        q.executeUpdate();
        em.getTransaction().commit();
        emf.close();
    }
    
    public List<Cliente> getAllClientes(){
        em.getTransaction().begin();
        Query consulta = em.createQuery("Select cliente from Cliente cliente");
        List<Cliente> listaclientes = consulta.getResultList();
        em.close();
        return listaclientes;
    }    
    
     public boolean login(String userlogin, String password){
        try{
            Cliente c = em.createNamedQuery("Cliente.LoginControl", Cliente.class).setParameter("userLogin", userlogin).setParameter("senha", password).getSingleResult();
            if(c != null){
                return true;
            }
            return false;
        }catch(Exception e){
            return false;
        }
    }
}
