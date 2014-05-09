package lib;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@Contextual
public class MyInterceptor {
    private final Logger logger = LoggerFactory.getLogger(MyInterceptor.class);


    @AroundInvoke
    public Object execute(InvocationContext ctx) throws Exception {
        logger.info("Intercepted " + ctx.getTarget().getClass().getName() + "." + ctx.getMethod().getName());
        return ctx.proceed();
    }
}
