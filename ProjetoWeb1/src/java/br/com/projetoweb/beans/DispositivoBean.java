package br.com.projetoweb.beans;

import br.com.projetoweb.bo.DispositivoBO;
import br.com.projetoweb.entity.Cliente;
import br.com.projetoweb.entity.Dispositivo;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author Arena
 */
@ManagedBean(name = "DispositivoBean")
@SessionScoped
public class DispositivoBean {

    private int idDispositivo; /*talvez n precise se for autoincrement*/
    private Cliente idCliente = new Cliente();
    private float altitude, longitude, latitude, velocidade;
    private String nomeDispositivo;
    private Dispositivo disp = new Dispositivo();
    public void salvar() throws Exception {
        try {
            Dispositivo dispositivo = new Dispositivo();
            dispositivo.setIdCliente(idCliente); //Com selectonemenu
            dispositivo.setNomeDispositivo(nomeDispositivo);
            dispositivo.setAltitude(altitude);
            dispositivo.setLatitude(latitude);
            dispositivo.setLongitude(longitude);
            dispositivo.setVelocidade(velocidade);
            DispositivoBO dispositivobo = new DispositivoBO();
            dispositivobo.salvar(dispositivo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void remover() throws Exception {
        try {
            Dispositivo dispositivo = new Dispositivo();
            dispositivo.setIdDispositivo(idDispositivo);
            DispositivoBO dispositivobo = new DispositivoBO();
            dispositivobo.remover(dispositivo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Dispositivo> getAllDispositivos() throws Exception {
        DispositivoBO disp = new DispositivoBO();
        List<Dispositivo> listaDispositivos = disp.getAllDispositivos();
        return listaDispositivos;
    } 
    
    public List<SelectItem> SelectDispositivos() throws Exception{
        DispositivoBO dispositivo = new DispositivoBO();
        List<Dispositivo> listaDispositivos = dispositivo.getAllDispositivos();
        List<SelectItem> listacombo = new ArrayList<SelectItem>();
        for (int i = 0; i < listaDispositivos.size(); i++) {
            listacombo.add(new SelectItem(listaDispositivos.get(i).getIdDispositivo(), listaDispositivos.get(i).getNomeDispositivo()));
        }
        return listacombo;
    }
    public int getIdDispositivo() {
        return idDispositivo;
    }

    public void setIdDispositivo(int idDispositivo) {
        this.idDispositivo = idDispositivo;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public float getAltitude() {
        return altitude;
    }

    public void setAltitude(float altitude) {
        this.altitude = altitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(float velocidade) {
        this.velocidade = velocidade;
    }

    public String getNomeDispositivo() {
        return nomeDispositivo;
    }

    public void setNomeDispositivo(String nomeDispositivo) {
        this.nomeDispositivo = nomeDispositivo;
    }

    public Dispositivo getDisp() {
        return disp;
    }

    public void setDisp(Dispositivo disp) {
        this.disp = disp;
    }
    
}
