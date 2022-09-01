package web.config;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import web.model.User;

import javax.persistence.EntityManagerFactory;
import java.util.Properties;

@Component
@PropertySource("classpath:database.properties")
public class DBConfig {

    @Value("${driver}")
    private String driver;
    @Value("${url}")
    private String url;
    @Value("${dbUsername}")
    private String username;
    @Value("${dbPassword}")
    private String password;
    @Value("${hibernate.dialect}")
    private String dialect;
    @Value("${hibernate.show_sql}")
    private String showSql;
    @Value("${hibernate.hbm2ddl.auto}")
    private String hbm2ddl;

    @Bean
    public EntityManagerFactory getEntityManagerFactory() {

        Properties properties = new Properties();
        properties.put(Environment.DRIVER, driver);
        properties.put(Environment.URL, url);
        properties.put(Environment.USER, username);
        properties.put(Environment.PASS, password);
        properties.put(Environment.DIALECT, dialect);
        properties.put(Environment.SHOW_SQL, showSql);
        properties.put(Environment.HBM2DDL_AUTO, hbm2ddl);

        Configuration configuration = new Configuration();
        configuration.setProperties(properties);
        configuration.addAnnotatedClass(User.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

        return configuration.buildSessionFactory(serviceRegistry);
    }
}
