package frol.txobserver;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.persistence.PersistenceException;
import javax.transaction.RollbackException;

@RunWith(Arquillian.class)
public class TxObserverTest {
    @Deployment
    public static JavaArchive createDeployment() {
        JavaArchive jar = ShrinkWrap.create(JavaArchive.class)
                .addClass(UpdateListener.class)
                .addClass(FooEntity.class)
                .addClass(FooService.class)
                .addClass(UpdateObserver.class)
                .addPackages(true, "org.apache.deltaspike.core")
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
        return jar;
    }

    @Before
    public void before() {
        fooService.persist();
    }

    @Inject
    FooService fooService;

    @Test
    public void error_during_managed_flush() {

        Exception thrown = null;
        try {
            fooService.managedFlush();
        } catch (Exception e) {
            thrown = e;
        }

        assert thrown.getClass() == RollbackException.class;
        assert thrown.getMessage().equals("ARJUNA016053: Could not commit transaction.");
        assert thrown.getCause().getClass() == PersistenceException.class;
        assert thrown.getCause().getMessage().equals("error during managed flush");
        assert thrown.getCause().getCause().getClass() == RuntimeException.class;
        assert thrown.getCause().getCause().getCause().getClass() == IllegalStateException.class;
        assert thrown.getCause().getCause().getCause().getMessage().equals(
                "ARJUNA016082: Synchronizations are not allowed! Transaction status isActionStatus.RUNNING");
    }

    @Test
    public void no_error_during_explicit_flush() {
        fooService.explicitFlush();
    }
}
