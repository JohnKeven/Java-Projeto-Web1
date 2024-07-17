package br.com.projetoweb.bo;

import br.com.projetoweb.dao.EmpresaDAO;
import br.com.projetoweb.entity.Empresa;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Arena
 */
public class EmpresaBO implements Serializable{
    EmpresaDAO empresa = new EmpresaDAO();

    public void salvar(Empresa emp) throws Exception {
        try {
            empresa.save(emp);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Erro ao cadastrar empresa");
        }
    }
    public void remover(Empresa emp) throws Exception {
        try {
            empresa.remove(emp);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Erro ao remover empresa");
        }
    }
    public List getAllEmpresas() throws Exception {
        try {
            return empresa.getAllEmpresas();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Erro ao listar empresas");
        }
    }
}
