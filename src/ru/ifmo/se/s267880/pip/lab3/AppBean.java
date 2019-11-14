package ru.ifmo.se.s267880.pip.lab3;

import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Named("app")
@ApplicationScoped
public class AppBean implements Serializable {
    private EditorBean editor = new EditorBean();
    private EntityManagerFactory checkHitQueryManagerFactory;
    private EntityManager checkHitQueryManager;
    private CheckingHitQuery displayingQuery = null;
    private LinkedList<CheckingHitQuery> allQueries = null;

    public AppBean() {
        checkHitQueryManagerFactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
        checkHitQueryManager = checkHitQueryManagerFactory.createEntityManager();
        allQueries = new LinkedList<>(checkHitQueryManager.createQuery("Select c from CheckingHitQuery c").getResultList());
        Collections.reverse(allQueries);
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
        editor.generateQueries().forEach(query -> {
            allQueries.addFirst(query);
            checkHitQueryManager.persist(query);
        });
        checkHitQueryManager.getTransaction().commit();
    }

    public List<CheckingHitQuery> getAllQueries() {
        return allQueries;
    }

    public void deleteAllQueries() {
        checkHitQueryManager.getTransaction().begin();
        checkHitQueryManager.createNativeQuery("Delete From CheckingHitQuery").executeUpdate();
        allQueries.clear();
        displayingQuery = null;
        checkHitQueryManager.getTransaction().commit();
    }

    public CheckingHitQuery getDisplayingQuery() {
        return displayingQuery;
    }

    public void setDisplayingQuery(CheckingHitQuery displayingQuery) {
        this.displayingQuery = displayingQuery;
    }
}
