package fr.diginamic;

import entites.Client;
import entites.Emprunt;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConnexionJpa {

    public static void main(String[] args) {

        // Déclaration en dehors de try pour que je puisse fermer les deux dans "finally"
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {

            // Créer une instance d'EntityManagerFactory
            emf = Persistence.createEntityManagerFactory("demo");

            // Créer une instance d'EntityManager
            em = emf.createEntityManager();

            // Rechercher un emprunt avec l'identifiant 2
            Emprunt emprunt1 = em.find(Emprunt.class, 2);
            if (emprunt1 != null) {
                // Afficher les livres associés à l'emprunt
                System.out.println(emprunt1.getLivres());
            }

            // Rechercher un client avec l'identifiant 1
            Client client1 = em.find(Client.class, 1);
            if (emprunt1 != null) {
                // Afficher un client associe
                System.out.println(client1.toString());
            }

        } finally {
            // Fermer l'EntityManager et l'EntityManagerFactory s'ils ont été ouverts
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }

        }
    }
}
