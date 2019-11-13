package ru.ifmo.se.s267880.pip.lab3;

import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.Serializable;
import java.util.List;

@Named("app")
@ApplicationScoped
public class AppBean implements Serializable {
    private EditorBean editor = new EditorBean();
    private EntityManagerFactory checkHitQueryManagerFactory;
    private EntityManager checkHitQueryManager;

    public AppBean() {
        checkHitQueryManagerFactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
        checkHitQueryManager = checkHitQueryManagerFactory.createEntityManager();
    }

    @PreDestroy
    public void destroy() {
        checkHitQueryManager.close();
        checkHitQueryManagerFactory.close();
    }

    public EditorBean getEditor() {
        return editor;
    }

    public void addGeneratedQueriesToDB() {
        checkHitQueryManager.getTransaction().begin();
        editor.generateQueries().forEach(checkHitQueryManager::persist);
        checkHitQueryManager.getTransaction().commit();
    }

    public List<CheckingHitQuery> getAllQueries() {
        return (List<CheckingHitQuery>)checkHitQueryManager.createQuery("Select c from CheckingHitQuery c").getResultList();
    }

    public void deleteAllQueries() {
        checkHitQueryManager.getTransaction().begin();
        checkHitQueryManager.createNativeQuery("Delete From CheckingHitQuery").executeUpdate();
        checkHitQueryManager.getTransaction().commit();
    }
}
