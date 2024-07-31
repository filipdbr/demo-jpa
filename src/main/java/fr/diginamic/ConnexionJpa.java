package fr.diginamic;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConnexionJpa {

    // création d'instance de Entity Manager Factory
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo");

    // création d'instance de Entity Manager
    EntityManager em = emf.createEntityManager();

}
