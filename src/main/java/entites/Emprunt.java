package entites;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

// L'annotation @Entity indique que cette classe est une entité JPA, mappée à une table de la base de données.
// L'annotation @Table spécifie le nom de la table associée dans la base de données.
@Entity
@Table(name = "emprunt")
public class Emprunt {

    // L'annotation @Id spécifie la clé primaire de cette entité.
    // GenerationType.IDENTITY indique que la valeur est générée automatiquement par la base de données (auto-increment).
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", length = 10, nullable = false)
    private int id;

    // Déclaration des autres colonnes de la table
    @Column(name = "DATE_DEBUT")
    private Timestamp dateDebut;

    @Column(name = "DATE_FIN")
    private Timestamp dateFin;

    @Column(name = "DELAI", length = 10)
    private int delai;

    // Relation ManyToOne avec l'entité Client
    @ManyToOne
    @JoinColumn(name = "ID_CLIENT")
    private Client client;

    // Relation ManyToMany avec l'entité Livre
    @ManyToMany
    @JoinTable(
            name = "COMPO",
            joinColumns = @JoinColumn(name = "ID_EMP", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "ID_LIV", referencedColumnName = "ID")
    )
    private Set<Livre> livres;

    // Constructeurs

    // Bloc d'initialisation pour initialiser la collection livres
    {
        livres = new HashSet<>();
    }

    // Le constructeur par défaut (sans paramètres) est requis par JPA pour créer une instance de l'entité.
    public Emprunt() {
    }

    // Constructeur supplémentaire avec des paramètres pour initialiser l'entité avec des valeurs fournies.
    public Emprunt(Timestamp dateDebut, Timestamp dateFin) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;

        // Calcul du délai en jours
        long millisecondsDiff = dateFin.getTime() - dateDebut.getTime();
        this.delai = (int) TimeUnit.MILLISECONDS.toDays(millisecondsDiff);
    }

    // Getters et Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getDate_debut() {
        return dateDebut;
    }

    public void setDate_debut(Timestamp date_debut) {
        this.dateDebut = date_debut;
    }

    public Timestamp getDate_fin() {
        return dateFin;
    }

    public void setDate_fin(Timestamp date_fin) {
        this.dateFin = date_fin;
    }

    public int getDelai() {
        return delai;
    }

    public void setDelai(int delai) {
        this.delai = delai;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Set<Livre> getLivres() {
        return livres;
    }

    public void setLivres(Set<Livre> livres) {
        this.livres = livres;
    }

    // La méthode toString fournit une représentation sous forme de chaîne de l'objet Emprunt.
    @Override
    public String toString() {
        return "Emprunt{" +
                "id=" + id +
                ", date_debut='" + dateDebut + '\'' +
                ", date_fin='" + dateFin + '\'' +
                ", delai=" + delai +
                '}';
    }
}
