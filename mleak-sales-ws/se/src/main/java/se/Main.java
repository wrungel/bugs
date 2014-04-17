package se;

import lib.ProjectionsImpl;
import org.jboss.weld.environment.se.bindings.Parameters;
import org.jboss.weld.environment.se.events.ContainerInitialized;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class Main {

    /// [1]
    @Inject
    private Provider<ProjectionsImpl> projectionsProvider;

    public void foo(@Observes ContainerInitialized event, @Parameters List<String> parameters) throws InterruptedException {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            projectionsProvider.get();
            System.out.println(i);
            Thread.sleep(500);
        }
    }
}
