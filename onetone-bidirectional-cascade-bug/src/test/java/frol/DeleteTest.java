package frol;


import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DeleteTest {
    @Test
    public void deleteTest() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("onetone");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Parent a = new Parent();
        Child b = new Child();
        a.setChild(b);
        b.setParent(a);

        em.persist(a);
        em.flush();

        em.clear();
        a = em.find(Parent.class, a.getId());

        em.remove(a);
        em.flush(); // fails hier with: org.hibernate.PropertyValueException: not-null property references a null or transient value : frol.Child.parent

        em.clear();

        Long bId = a.getChild().getId();
        a = em.find(Parent.class, a.getId());
        assert a == null;
        b = em.find(Child.class, bId);
        assert b == null;


    }
}
