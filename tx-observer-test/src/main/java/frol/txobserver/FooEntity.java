package frol.txobserver;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;

@Entity
@EntityListeners(UpdateListener.class)
public class FooEntity {

    @Id
    private Long id;

    private String name;

    public FooEntity(Long id) {this.id = id;}

    protected FooEntity() {}

    public void setName(String name) {
        this.name = name;
    }
}
