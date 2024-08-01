package entites;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "ID")
    private int id;

    @Column (name = "NOM", length = 50)
    private String nom;

    @Column (name = "PRENOM", length = 50)
    private String prenom;

    @OneToMany (mappedBy = "client") // mapped by this class
    private Set<Emprunt> emprunts;

    // constructeur par defaut
    public Client() {
    }

    // constructeur supplémentaire avec des paramètres
    public Client(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    // getters & setters

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

    // La méthode toString

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }
}
