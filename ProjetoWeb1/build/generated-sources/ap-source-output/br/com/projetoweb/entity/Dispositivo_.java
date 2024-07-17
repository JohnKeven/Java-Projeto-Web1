package br.com.projetoweb.entity;

import br.com.projetoweb.entity.Cliente;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-06T13:55:07")
@StaticMetamodel(Dispositivo.class)
public class Dispositivo_ { 

    public static volatile SingularAttribute<Dispositivo, Float> altitude;
    public static volatile SingularAttribute<Dispositivo, Float> velocidade;
    public static volatile SingularAttribute<Dispositivo, Cliente> idCliente;
    public static volatile SingularAttribute<Dispositivo, Integer> idDispositivo;
    public static volatile SingularAttribute<Dispositivo, Float> latitude;
    public static volatile SingularAttribute<Dispositivo, String> nomeDispositivo;
    public static volatile SingularAttribute<Dispositivo, Float> longitude;

}