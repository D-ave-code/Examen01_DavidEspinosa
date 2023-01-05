package com.distribuida.config;


import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Produces;
import lombok.Data;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;


@ApplicationScoped
public class DbConfig {
    @Inject
    @ConfigProperty(name="db.user")
    String dbUser;
    @Inject
    @ConfigProperty(name="db.password")
    String dbPassword;
    @Inject
    @ConfigProperty(name="db.url")
    String dbUrl;

    private Jdbi jdbi;

    @PostConstruct
    public  void init(){
    System.out.println("*********************postcosnt");
    /*API DE CONFIGURACION PRIMERA OPCION en cualquier clase*/
    /* Config config =  ConfigProvider.getConfig();
    String user = config.getValue("db.user", String.class);
    String password = config.getValue("db.password", String.class);
    String url = config.getValue("db.url", String.class);
    System.out.println(user);
    System.out.println(password);
    System.out.println(url);*/
    /*FIN*/
    /*SEGUNDA OPCION solo componentes cdi*/
    System.out.println("op2"+dbUser);
    System.out.println("op2"+dbPassword);
    System.out.println("op2"+dbUrl);

        jdbi = Jdbi.create(dbUrl,dbUser,dbPassword);


}
@ApplicationScoped
@Produces
public Handle test(){

    return jdbi.open();
}

}
