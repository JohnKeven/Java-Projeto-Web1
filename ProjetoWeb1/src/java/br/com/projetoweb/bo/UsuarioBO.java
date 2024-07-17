package br.com.projetoweb.bo;

import br.com.projetoweb.dao.UsuarioDAO;
import br.com.projetoweb.entity.UsuarioADM;
import java.io.Serializable;

/**
 *
 * @author Arena
 */
public class UsuarioBO implements Serializable{
    UsuarioDAO UsuarioDAO = new UsuarioDAO(); 
    
    public void salvar(UsuarioADM usuario)throws Exception{
        try{
            UsuarioDAO.save(usuario);
        } catch(Exception e){
            e.printStackTrace();
            throw new Exception("Erro ao cadastrar cliente");
        }
    }
    public void remover(UsuarioADM usuario)throws Exception{
        try{
            UsuarioDAO.remove(usuario);
        }catch(Exception e){
            e.printStackTrace();
            throw new Exception("Erro ao remover cliente");
        }
    } 
     public void getAllUserADM()throws Exception{
        try{
            UsuarioDAO.getAllUserADM();
        }catch(Exception e){
            e.printStackTrace();
            throw new Exception("Erro ao listar usuarios");
        }
    } 
}
