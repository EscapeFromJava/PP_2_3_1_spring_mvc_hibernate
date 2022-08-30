package web.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import web.model.User;

import javax.persistence.EntityManagerFactory;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

@Component
public class Util {

    @Bean
    public static EntityManagerFactory getEntityManagerFactory() {
        EntityManagerFactory entityManagerFactory = null;
        try {
            FileReader fileReader = new FileReader("C:\\Users\\PUDGE\\IdeaProjects\\Kata\\PP_2_3_1_spring_mvc_hibernate\\src\\main\\resources\\database.properties");
            Properties dataBaseProperties = new Properties();
            dataBaseProperties.load(fileReader);

            Configuration configuration = new Configuration();
            Properties properties = new Properties();

            properties.put(Environment.DRIVER, dataBaseProperties.getProperty("driver"));
            properties.put(Environment.URL, dataBaseProperties.getProperty("url"));
            properties.put(Environment.USER, dataBaseProperties.getProperty("username"));
            properties.put(Environment.PASS, dataBaseProperties.getProperty("password"));
            properties.put(Environment.DIALECT, dataBaseProperties.getProperty("dialect"));
            properties.put(Environment.SHOW_SQL, true);
            properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
            properties.put(Environment.HBM2DDL_AUTO, "update");
            configuration.setProperties(properties);
            configuration.addAnnotatedClass(User.class);
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            entityManagerFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (HibernateException | IOException e) {
            throw new RuntimeException(e);
        }
        return entityManagerFactory;
    }
}
