package entites;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

// L'annotation @Entity indique que cette classe est une entité JPA, mappée à une table de la base de données.
// L'annotation @Table spécifie le nom de la table associée dans la base de données.
@Entity
@Table(name = "client")
public class Client {

    // Attributs

    // L'annotation @Id spécifie la clé primaire de cette entité.
    // GenerationType.IDENTITY indique que la valeur est générée automatiquement par la base de données (auto-increment).
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    // Déclaration des autres colonnes de la table
    @Column(name = "NOM", length = 50)
    private String nom;

    @Column(name = "PRENOM", length = 50)
    private String prenom;

    // Relation OneToMany avec l'entité Emprunt
    // La relation est mappée par l'attribut "client" dans l'entité Emprunt
    @OneToMany(mappedBy = "client")
    private Set<Emprunt> emprunts;


    // Constructeurs

    // Bloc d'initialisation pour initialiser la collection emprunts
    {
        emprunts = new HashSet<>();
    }

    // Constructeur par défaut (sans paramètres) requis par JPA pour créer une instance de l'entité.
    public Client() {
    }

    // Constructeur supplémentaire avec des paramètres pour initialiser l'entité avec des valeurs fournies.
    public Client(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    // Méthodes

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Set<Emprunt> getEmprunts() {
        return emprunts;
    }

    public void setEmprunts(Set<Emprunt> emprunts) {
        this.emprunts = emprunts;
    }

    // La méthode toString fournit une représentation sous forme de chaîne de l'objet Client.
    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }
}
