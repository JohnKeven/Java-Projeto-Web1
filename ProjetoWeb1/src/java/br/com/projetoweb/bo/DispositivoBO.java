package br.com.projetoweb.bo;

import br.com.projetoweb.dao.DispositivoDAO;
import br.com.projetoweb.entity.Dispositivo;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Arena
 */
public class DispositivoBO implements Serializable{
    DispositivoDAO dispositivo = new DispositivoDAO();

    public void salvar(Dispositivo disp) throws Exception {
        try {
            dispositivo.save(disp);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Erro ao cadastrar dispositivo");
        }
    }

    public void remover(Dispositivo disp) throws Exception {
        try {
            dispositivo.remove(disp);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Erro ao remover dispositivo");
        }
    }

    public List getAllDispositivos() throws Exception {
        try {
            return dispositivo.getAllDispositivos();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Erro ao listar dispositivos");
        }
    }
}
