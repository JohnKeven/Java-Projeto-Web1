package br.com.projetoweb.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.metamodel.SingularAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Arena
 */
@Entity
@Table(name = "Cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.LoginControl", query = "SELECT c FROM Cliente c where c.userLogin =:userLogin and c.senha =:senha"),
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByIdCliente", query = "SELECT c FROM Cliente c WHERE c.idCliente = :idCliente"),
    @NamedQuery(name = "Cliente.findByIdDependente", query = "SELECT c FROM Cliente c WHERE c.idDependente = :idDependente"),
    @NamedQuery(name = "Cliente.findByUserLogin", query = "SELECT c FROM Cliente c WHERE c.userLogin = :userLogin"),
    @NamedQuery(name = "Cliente.findBySenha", query = "SELECT c FROM Cliente c WHERE c.senha = :senha"),
    @NamedQuery(name = "Cliente.findByNome", query = "SELECT c FROM Cliente c WHERE c.nome = :nome"),
    @NamedQuery(name = "Cliente.findByIdEmpresa", query = "SELECT c FROM Cliente c WHERE c.idEmpresa = :idEmpresa")})
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cliente")
    private Integer idCliente;
    @Column(name = "id_dependente")
    private Integer idDependente;
    @Basic(optional = false)
    @Column(name = "user_login")
    private String userLogin;
    @Basic(optional = false)
    @Column(name = "senha")
    private String senha;
    @Basic(optional = false)
    @Column(name = "Nome")
    private String nome;
    @Column(name = "id_empresa")
    private Integer idEmpresa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idResponsavel")
    private Collection<Empresa> empresaCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "cliente1")
    private Cliente cliente;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Cliente cliente1;
    @OneToMany(mappedBy = "idCliente")
    private Collection<Dispositivo> dispositivoCollection;

    public Cliente() {
    }

    public Cliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Cliente(Integer idCliente, String userLogin, String senha, String nome) {
        this.idCliente = idCliente;
        this.userLogin = userLogin;
        this.senha = senha;
        this.nome = nome;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdDependente() {
        return idDependente;
    }

    public void setIdDependente(Integer idDependente) {
        this.idDependente = idDependente;
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

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    @XmlTransient
    public Collection<Empresa> getEmpresaCollection() {
        return empresaCollection;
    }

    public void setEmpresaCollection(Collection<Empresa> empresaCollection) {
        this.empresaCollection = empresaCollection;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente1() {
        return cliente1;
    }

    public void setCliente1(Cliente cliente1) {
        this.cliente1 = cliente1;
    }

    @XmlTransient
    public Collection<Dispositivo> getDispositivoCollection() {
        return dispositivoCollection;
    }

    public void setDispositivoCollection(Collection<Dispositivo> dispositivoCollection) {
        this.dispositivoCollection = dispositivoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.projetoweb.entity.Cliente[ idCliente=" + idCliente + " ]";
    }
}
