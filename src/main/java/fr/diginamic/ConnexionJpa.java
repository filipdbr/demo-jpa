package fr.diginamic;

import entites.Livre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConnexionJpa {

    public static void main(String[] args) {

        // création d'instance de Entity Manager Factory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo");

        // création d'instance de Entity Manager
        EntityManager em = emf.createEntityManager();

        // verification de connection
        em.getTransaction().begin();
        System.out.println("Great success: the connection is established!");

        Livre livre = em.find(Livre.class, 2);

        System.out.println("\nVous avez loué: " + livre);

        em.getTransaction().commit();
        em.close();

    }
}
