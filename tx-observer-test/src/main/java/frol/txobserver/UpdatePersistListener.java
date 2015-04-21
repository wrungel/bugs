package frol.txobserver;


import org.apache.deltaspike.core.api.provider.BeanManagerProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.inject.spi.BeanManager;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class UpdatePersistListener {
    private static final Logger logger = LoggerFactory.getLogger(UpdatePersistListener.class);

    // Doesn't work:
    // @Inject
    //BeanManager beanManager; //Workaround WFLY-2387

    BeanManager getBeanManager() {
        // does'n work in CDIRunner:
//        InitialContext initialContext = null;
//        try {
//            initialContext = new InitialContext();
//            return (BeanManager) initialContext.lookup("java:comp/BeanManager");
//        } catch (NamingException e) {
//            throw new RuntimeException(e);
//        }

        return BeanManagerProvider.getInstance().getBeanManager();

    }

    @PreUpdate
    @PrePersist
    public void preUpdatePrePersist(Object object) {
        if (object instanceof FooEntity) {
            logger.info("event sending");
            getBeanManager().fireEvent(object);
            logger.info("event sent");
        }
    }
}
