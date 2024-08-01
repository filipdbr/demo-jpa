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
    private Timestamp date_debut;

    @Column(name = "DATE_FIN")
    private Timestamp date_fin;

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

    // Bloc d'initialisation pour initialiser la collection livres
    {
        livres = new HashSet<>();
    }

    // Constructeurs

    // Le constructeur par défaut (sans paramètres) est requis par JPA pour créer une instance de l'entité.
    public Emprunt() {
    }

    // Constructeur supplémentaire avec des paramètres pour initialiser l'entité avec des valeurs fournies.
    public Emprunt(Timestamp date_debut, Timestamp date_fin) {
        this.date_debut = date_debut;
        this.date_fin = date_fin;

        // Calcul du délai en jours
        long millisecondsDiff = date_fin.getTime() - date_debut.getTime();
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
        return date_debut;
    }

    public void setDate_debut(Timestamp date_debut) {
        this.date_debut = date_debut;
    }

    public Timestamp getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Timestamp date_fin) {
        this.date_fin = date_fin;
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
                ", date_debut='" + date_debut + '\'' +
                ", date_fin='" + date_fin + '\'' +
                ", delai=" + delai +
                '}';
    }
}
