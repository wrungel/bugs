package frol.txobserver;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.UUID;

@Transactional
public class FooService {

    @PersistenceContext(unitName = "default")
    EntityManager em;

    private static final Long ID = 1L;

    public void persist() {
        if (em.find(FooEntity.class, ID) == null)
            em.persist(new FooEntity(ID));
    }

    public void managedFlush() {
        em.find(FooEntity.class, ID).setName(UUID.randomUUID().toString());
    }

    public void explicitFlush() {
        em.find(FooEntity.class, ID).setName(UUID.randomUUID().toString());
        em.flush();
    }
}
