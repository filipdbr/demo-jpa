package entites;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table (name = "emprunt")
public class Emprunt {

    // Id par défaut puisque c'est auto-increment
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "ID", length = 10, nullable = false)
    private int id;

    @Column (name = "DATE_DEBUT")
    private String date_debut;

    @Column (name = "DATE_FIN")
    private String date_fin;

    @Column (name = "DELAI", length = 10)
    private int delai;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENT")
    private Client client;

    @ManyToMany
    @JoinTable(
        name = "compo",
        joinColumns = @JoinColumn(name = "ID_EMPRUNT"),
        inverseJoinColumns = @JoinColumn(name = "ID_LIVRE")
    )

    private Set<Livre> livres;

    // Le constructeur par défaut (sans paramethes)
    public Emprunt() {

    }

    // constructeur supplémentaire avec des paramètres
    public Emprunt(String date_debut, int delai,int id_client) {
        this.date_debut = date_debut;
        this.date_fin = date_debut + 30;
        this.delai = delai;
    }

    // getters & getters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(String date_debut) {
        this.date_debut = date_debut;
    }

    public String getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(String date_fin) {
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

    // toString


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

