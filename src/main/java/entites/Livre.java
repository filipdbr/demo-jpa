package entites;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

// L'annotation @Entity indique que cette classe est une entité JPA
// L'annotation @Table spécifie le nom de la table associée dans la base de données
@Entity
@Table(name = "livre")
public class Livre {

    // Attributs

    // L'annotation @Id spécifie la clé primaire de cette entité
    // GenerationType.IDENTITY indique que la valeur est générée automatiquement par la base de données (auto-increment)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    // Déclaration des autres colonnes de la table
    @Column(name = "TITRE", length = 255)
    private String title;
    @Column(name = "AUTEUR", length = 50)
    private String author;

    // Relation ManyToMany avec l'entité Emprunt
    @ManyToMany(mappedBy = "livres")
    Set<Emprunt> emprunts;

    // Constructeurs

    // bloc d'initialisation d'instance
    {
        emprunts = new HashSet<>();
    }

    // Le constructeur vide par défaut est requis par JPA pour créer une instance de l'entité
    public Livre() {
    }

    // Constructeur supplémentaire avec des paramètres pour initialiser l'entité avec des valeurs fournies
    public Livre(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    // Méthodes

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    // Setters

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    // La méthode toString fournit une représentation sous forme de chaîne de l'objet Livre.
    @Override
    public String toString() {
        return "Livre{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
