/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoweb.beans;

import br.com.projetoweb.bo.ClienteBO;
import br.com.projetoweb.dao.ClienteDAO;
import br.com.projetoweb.entity.Cliente;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Arena
 */
@ManagedBean(name = "ClienteBean")
@SessionScoped
public class ClienteBean implements Serializable {
    private Cliente cliente = new Cliente();
    private int idCliente, idDependente, idEmpresa;
    private String nome, userLogin, senha;
    private ClienteBO teste = new ClienteBO();

    
    public String login() {
        ClienteDAO UserDAO = new ClienteDAO();
        if (UserDAO.login(userLogin, senha)) {
            return "HomeClient.xhtml?faces-redirect=true";
        }
        RequestContext.getCurrentInstance().update("growl");
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Login ou senha invalido!"));
        return "";
    }

    public void salvar() throws Exception {
        try {
            Cliente user = new Cliente();
            user.setIdEmpresa(idEmpresa);
            user.setNome(nome);
            user.setIdDependente(idDependente);
            user.setUserLogin(userLogin);
            user.setSenha(senha);
            ClienteBO clientebo = new ClienteBO();
            clientebo.salvar(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void remover() throws Exception {
        try {
            Cliente cliente = new Cliente();
            cliente.setIdCliente(idCliente);
            ClienteBO clientebo = new ClienteBO();
            clientebo.remover(cliente);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Cliente> getAllClientes() throws Exception {
        ClienteBO client = new ClienteBO();
        List<Cliente> listaClientes = client.getAllCliente();
        return listaClientes;
    } 

    public List<SelectItem> SelectClientes() throws Exception{
         ClienteBO client = new ClienteBO();
        List<Cliente> listaClientes = client.getAllCliente();
        List<SelectItem> listacombo = new ArrayList<SelectItem>();
        for (int i = 0; i < listaClientes.size(); i++) {
            listacombo.add(new SelectItem(listaClientes.get(i).getIdCliente(), listaClientes.get(i).getNome()));
        }
        return listacombo;
    }
    
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdDependente() {
        return idDependente;
    }

    public void setIdDependente(int idDependente) {
        this.idDependente = idDependente;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
