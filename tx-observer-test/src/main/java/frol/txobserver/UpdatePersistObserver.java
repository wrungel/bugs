package frol.txobserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;

public class UpdatePersistObserver {
    private static final Logger logger = LoggerFactory.getLogger(UpdatePersistObserver.class);

    public void AFTER_COMPLETION(@Observes(during = TransactionPhase.AFTER_COMPLETION) FooEntity foo) {
        logger.info("AFTER_COMPLETION event received");
    }

    public void AFTER_SUCCESS(@Observes(during = TransactionPhase.AFTER_SUCCESS) FooEntity foo) {
        logger.info("AFTER_SUCCESS event received");
    }

    public void BEFORE_COMPLETION(@Observes(during = TransactionPhase.BEFORE_COMPLETION) FooEntity foo) {
        logger.info("BEFORE_COMPLETION event received");
    }

    public void AFTER_FAILURE(@Observes(during = TransactionPhase.AFTER_FAILURE) FooEntity foo) {
        logger.info("AFTER_FAILURE event received");
    }

    public void IN_PROGRESS(@Observes(during = TransactionPhase.IN_PROGRESS) FooEntity foo) {
        logger.info("IN_PROGRESS event received");
    }
}
