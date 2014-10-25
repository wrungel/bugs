package frol;

import javax.persistence.*;

import static javax.persistence.CascadeType.*;

@Entity
public class Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @OneToOne(optional = false, mappedBy = "parent", cascade = ALL)
    private Child child;


    public Long getId() {
        return id;
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

}
