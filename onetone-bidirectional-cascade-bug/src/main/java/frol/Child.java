package frol;

import javax.persistence.*;

@Entity
public class Child {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @OneToOne(optional=false)
    @JoinColumn(nullable=false)
    private Parent parent;

    public Long getId() {
        return id;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }
}
