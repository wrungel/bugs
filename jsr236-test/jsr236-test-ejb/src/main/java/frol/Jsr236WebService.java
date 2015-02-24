/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frol;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.enterprise.concurrent.ContextService;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.concurrent.ManagedTask;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Logger;

/**
 *
 * @author frol
 */
@WebService(serviceName = "Jsr236WebService")
@Stateless
public class Jsr236WebService {
    
    private static final Logger logger = Logger.getLogger(Jsr236WebService.class.getSimpleName());
    
    @Inject 
    private Jsr236ManagedTask jsr236ManagedTask;
    
    @Resource
    private ManagedExecutorService executor;
    
    @Resource
    private ContextService contextService;
        

    private Map<String, String> execProps() {
        Map<String, String> execProps = new HashMap<>();
        execProps.put(ManagedTask.TRANSACTION, ManagedTask.USE_TRANSACTION_OF_EXECUTION_THREAD);
        return execProps;
    }
    
    
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        
        Future<String> future = executor.submit(
                contextService.createContextualProxy(jsr236ManagedTask, execProps(), Callable.class));

        try {
            return future.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
