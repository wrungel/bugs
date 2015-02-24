package frol;


import javax.enterprise.concurrent.ManagedTask;
import javax.enterprise.concurrent.ManagedTaskListener;
import javax.enterprise.context.Dependent;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.logging.Logger;

@Dependent
@Transactional(Transactional.TxType.MANDATORY)
public class Jsr236ManagedTask implements Callable<String>, ManagedTask {
    static final Logger logger = Logger.getLogger(Jsr236WebService.class.getName());

    @Override
    public String call() {
        return "called";
    }
    

    @Override
    public ManagedTaskListener getManagedTaskListener() {
        return null;
    }
    
    private Map<String, String> execProps() {
        Map<String, String> execProps = new HashMap<>();
        execProps.put(ManagedTask.TRANSACTION, ManagedTask.USE_TRANSACTION_OF_EXECUTION_THREAD);
        execProps.put(ManagedTask.IDENTITY_NAME, "jsr236-test");
        execProps.put(ManagedTask.LONGRUNNING_HINT, "true");
        return execProps;
    }

    @Override
    public Map<String, String> getExecutionProperties() {
        logger.info("execProps() called");        
        return execProps();
    }
    
    
    
}
