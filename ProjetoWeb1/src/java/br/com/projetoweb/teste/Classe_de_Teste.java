package br.com.projetoweb.teste;

import br.com.projetoweb.dao.ClienteDAO;
import br.com.projetoweb.dao.DispositivoDAO;
import br.com.projetoweb.dao.EmpresaDAO;
import br.com.projetoweb.dao.UsuarioDAO;
import br.com.projetoweb.entity.Cliente;
import br.com.projetoweb.entity.Empresa;
import br.com.projetoweb.entity.UsuarioADM;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Arena
 */
public class Classe_de_Teste {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ClienteDAO dao = new ClienteDAO();
        UsuarioDAO userdao = new UsuarioDAO();
        EmpresaDAO empresa = new EmpresaDAO();
        DispositivoDAO disp = new DispositivoDAO();
    }
}
