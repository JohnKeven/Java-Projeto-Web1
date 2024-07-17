package br.com.projetoweb.bo;

import br.com.projetoweb.dao.ClienteDAO;
import br.com.projetoweb.entity.Cliente;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Arena
 */
public class ClienteBO implements Serializable{
    ClienteDAO cliente = new ClienteDAO();

    public void salvar(Cliente client)throws Exception{
        try{
            cliente.save(client);
        } catch(Exception e){
            e.printStackTrace();
            throw new Exception("Erro ao cadastrar cliente");
        }
        
    }
    public void remover(Cliente client)throws Exception{
        try{
            cliente.remove(client);
        }catch(Exception e){
            e.printStackTrace();
            throw new Exception("Erro ao remover cliente");
        }
    }
    public List getAllCliente()throws Exception{
        try{
            return cliente.getAllClientes();
        } catch(Exception e){
            e.printStackTrace();
            throw new Exception("Erro ao listar clientes");
        }
    }
}
