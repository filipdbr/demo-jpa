package fr.diginamic;

import entites.Client;
import entites.Emprunt;
import entites.Livre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ConnexionJpa {

    public static void main(String[] args) {

        // Déclaration en dehors de try pour que je puisse fermer les deux dans "finally"
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {

            // Variable contenant une requête SQL
            final String SEARCH_QUERY = "SELECT e FROM Emprunt e WHERE e.client.id = :clientId";

            // Créer une instance d'EntityManagerFactory
            emf = Persistence.createEntityManagerFactory("demo");

            // Créer une instance d'EntityManager
            em = emf.createEntityManager();

            // Rechercher un emprunt avec l'identifiant 2
            Emprunt emprunt1 = em.find(Emprunt.class, 2);
            if (emprunt1 != null) {
                // Afficher les livres associés à l'emprunt
                System.out.println("Recherche terminée avec succès : " + emprunt1.getLivres());
            }

            // Rechercher un client avec l'identifiant 1
            Client client1 = em.find(Client.class, 1);
            if (client1 != null) {
                // Afficher le client associé
                System.out.println("Recherche terminée avec succès : " + client1.toString());
            }

            // Trouver tous les emprunts pour ce client
            TypedQuery<Emprunt> query = em.createQuery(SEARCH_QUERY, Emprunt.class);
            query.setParameter("clientId", client1.getId());
            List<Emprunt> emprunts = query.getResultList();

            // Affichage des resultats
            System.out.println("Les emprunts de " + client1.getNom() + " " + client1.getPrenom() + ":");
            for (Emprunt emprunt : emprunts) {
                System.out.println(emprunt);
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
