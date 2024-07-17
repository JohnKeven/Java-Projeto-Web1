package br.com.projetoweb.entity;

import br.com.projetoweb.entity.Cliente;
import br.com.projetoweb.entity.Dispositivo;
import br.com.projetoweb.entity.Empresa;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-06T13:55:07")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile SingularAttribute<Cliente, String> userLogin;
    public static volatile SingularAttribute<Cliente, String> senha;
    public static volatile SingularAttribute<Cliente, Cliente> cliente;
    public static volatile SingularAttribute<Cliente, Integer> idDependente;
    public static volatile SingularAttribute<Cliente, Cliente> cliente1;
    public static volatile SingularAttribute<Cliente, Integer> idCliente;
    public static volatile CollectionAttribute<Cliente, Dispositivo> dispositivoCollection;
    public static volatile CollectionAttribute<Cliente, Empresa> empresaCollection;
    public static volatile SingularAttribute<Cliente, String> nome;
    public static volatile SingularAttribute<Cliente, Integer> idEmpresa;

}