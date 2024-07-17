package br.com.projetoweb.beans;

import br.com.projetoweb.bo.ClienteBO;
import br.com.projetoweb.bo.EmpresaBO;
import br.com.projetoweb.entity.Cliente;
import br.com.projetoweb.entity.Empresa;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author Arena
 */
@ManagedBean(name = "EmpresaBean")
@SessionScoped
public class EmpresaBean {
    private Cliente responsavel = new Cliente();
    private int idEmpresa;
    private String nome;

    public void salvar() throws Exception {
        try {
            Empresa empresa = new Empresa();
            empresa.setNomeEmpresa(nome);
            empresa.setIdResponsavel(responsavel);
            EmpresaBO empresabo = new EmpresaBO();
            empresabo.salvar(empresa);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void remover() throws Exception {
        try {
            Empresa empresa = new Empresa();
            empresa.setIdEmpresa(idEmpresa);
            EmpresaBO empresabo = new EmpresaBO();
            empresabo.remover(empresa);
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 

   public List<Empresa> getAllEmpresas() throws Exception {
        EmpresaBO emp = new EmpresaBO();
        List<Empresa> listaEmpresas = emp.getAllEmpresas();
        return listaEmpresas;
    } 
    
     public List<SelectItem> SelectEmpresas() throws Exception{
        EmpresaBO empresa = new EmpresaBO();
        List<Empresa> listaEmpresas = empresa.getAllEmpresas();
        List<SelectItem> listacombo = new ArrayList<SelectItem>();
        for (int i = 0; i < listaEmpresas.size(); i++) {
            listacombo.add(new SelectItem(listaEmpresas.get(i).getIdEmpresa(), listaEmpresas.get(i).getNomeEmpresa()));
        }
        return listacombo;
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

    public Cliente getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Cliente responsavel) {
        this.responsavel = responsavel;
    }

    public Cliente getCliente() {
        return responsavel;
    }

    public void setCliente(Cliente cliente) {
        this.responsavel = cliente;
    }
    
    
}
