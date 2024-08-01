package entites;

import jakarta.persistence.*;

// L'annotation @Entity spécifie que la classe doit être traitée comme une table
// L'annotation @Table indique le nom de la table dans la base de données.
@Entity
@Table (name = "livre")
public class Livre {

    // L'annotation @Id spécifie la clé primaire d'une entité.
    // GenerationType.IDENTITY indique auto-increment dans la base de données.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Déclaration des autres colonnes
    @Column (name = "TITRE", length = 255)
    private String title;


    @Column (name = "AUTEUR", length = 50)
    private String author;

    // Le constructeur par défaut (sans paramethes) requis par JPA pour créer une instance d'entité.
    // Il est souvent utilisé lors de la récupération de données de la base de données.
    public Livre() {
    }

    // Constructeur supplémentaire avec des paramètres pour initialiser l'entité avec des valeurs données.
    // Cela peut être utile lors de la création de nouvelles instances de l'entité à enregistrer dans la base de données.
    public Livre(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    // getters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    // setters
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
