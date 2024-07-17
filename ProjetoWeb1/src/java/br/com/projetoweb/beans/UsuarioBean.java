package br.com.projetoweb.beans;

import br.com.projetoweb.bo.UsuarioBO;
import br.com.projetoweb.dao.UsuarioDAO;
import br.com.projetoweb.entity.UsuarioADM;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Arena
 */
@ManagedBean(name = "UsuarioBean")
@SessionScoped
public class UsuarioBean implements Serializable {

    private int id;
    private String user_login, senha, nome;

    public String login() {
        UsuarioDAO UserDAO = new UsuarioDAO();
        if (UserDAO.login(user_login, senha)) {
            return "Home.xhtml?faces-redirect=true";
        }
        RequestContext.getCurrentInstance().update("growl");
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Login ou senha invalido!"));
        return "";
    }

    public void salvar() throws Exception {
        try {
            UsuarioADM user = new UsuarioADM();
            user.setId(id);
            user.setNome(nome);
            user.setUserLogin(user_login);
            user.setSenha(senha);
            UsuarioBO UserBO = new UsuarioBO();
            UserBO.salvar(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void remover() throws Exception {
        try {
            UsuarioADM usuario = new UsuarioADM();
            usuario.setId(id);
            UsuarioBO usuariobo = new UsuarioBO();
            usuariobo.remover(usuario);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_login() {
        return user_login;
    }

    public void setUser_login(String user_login) {
        this.user_login = user_login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
