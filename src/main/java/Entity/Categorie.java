package Entity;

import javax.persistence.*;

@Entity
@Table(name="categorie")
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    public Categorie(){

    }
    public Categorie( String name ){
        this.setName(name);
    }
    public Categorie(long id, String name ){
        this.setName(name);
        this.setId(id);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
