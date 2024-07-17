package br.com.projetoweb.entity;

import br.com.projetoweb.entity.Cliente;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-06T13:55:07")
@StaticMetamodel(Empresa.class)
public class Empresa_ { 

    public static volatile SingularAttribute<Empresa, String> nomeEmpresa;
    public static volatile SingularAttribute<Empresa, Integer> idEmpresa;
    public static volatile SingularAttribute<Empresa, Cliente> idResponsavel;

}