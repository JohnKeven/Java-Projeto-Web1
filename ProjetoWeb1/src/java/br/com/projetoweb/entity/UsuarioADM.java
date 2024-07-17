package br.com.projetoweb.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Arena
 */
@Entity
@Table(name = "UsuarioADM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioADM.LoginControl", query = "SELECT u FROM UsuarioADM u where u.userLogin =:userLogin and u.senha =:senha"),
    @NamedQuery(name = "UsuarioADM.findAll", query = "SELECT u FROM UsuarioADM u"),
    @NamedQuery(name = "UsuarioADM.findById", query = "SELECT u FROM UsuarioADM u WHERE u.id = :id"),
    @NamedQuery(name = "UsuarioADM.findByUserLogin", query = "SELECT u FROM UsuarioADM u WHERE u.userLogin = :userLogin"),
    @NamedQuery(name = "UsuarioADM.findBySenha", query = "SELECT u FROM UsuarioADM u WHERE u.senha = :senha"),
    @NamedQuery(name = "UsuarioADM.findByNome", query = "SELECT u FROM UsuarioADM u WHERE u.nome = :nome")})
public class UsuarioADM implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "user_login")
    private String userLogin;
    @Basic(optional = false)
    @Column(name = "senha")
    private String senha;
    @Basic(optional = false)
    @Column(name = "Nome")
    private String nome;

    public UsuarioADM() {
    }

    public UsuarioADM(Integer id) {
        this.id = id;
    }

    public UsuarioADM(Integer id, String userLogin, String senha, String nome) {
        this.id = id;
        this.userLogin = userLogin;
        this.senha = senha;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioADM)) {
            return false;
        }
        UsuarioADM other = (UsuarioADM) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.projetoweb.entity.UsuarioADM[ id=" + id + " ]";
    }
    
}
