package br.com.projetoweb.dao;

import br.com.projetoweb.entity.UsuarioADM;
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
public class UsuarioDAO implements Serializable{
    EntityManagerFactory emf;
    EntityManager em;

    public UsuarioDAO() {
        emf = Persistence.createEntityManagerFactory("ProjetoWeb1PU");
        em = emf.createEntityManager();
    }

    public void save(UsuarioADM usuario) {
        em.getTransaction().begin();
        em.merge(usuario);
        em.getTransaction().commit();
        emf.close();
    }

    public void remove(UsuarioADM usuario) {
        em.getTransaction().begin();
        Query q = em.createNativeQuery("Delete from UsuarioADM where id =" + usuario.getId());
        q.executeUpdate();
        em.getTransaction().commit();
        emf.close();
    } 
    
    public List<UsuarioADM> getAllUserADM(){
        em.getTransaction().begin();
        Query consulta = em.createQuery("Select usuario from UsuarioADM usuario");
        List<UsuarioADM> listaclientes = consulta.getResultList();
        em.close();
        return listaclientes;
    }    
    
    public boolean login(String userlogin, String password){
        try{
            UsuarioADM u = em.createNamedQuery("UsuarioADM.LoginControl", UsuarioADM.class).setParameter("userLogin", userlogin).setParameter("senha", password).getSingleResult();
            if(u != null){
                return true;
            }
            return false;
        }catch(Exception e){
            return false;
        }
    }
}
