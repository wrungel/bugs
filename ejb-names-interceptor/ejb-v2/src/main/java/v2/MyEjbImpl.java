package v2;

import lib.Contextual;
import org.jboss.ws.api.annotation.WebContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.jws.WebService;


@Stateless
@Contextual
@WebService(targetNamespace = "http://frol.example.com/")
@WebContext(contextRoot = "MyWebservice/v2")
public class MyEjbImpl {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public String v2() {
        logger.debug("v2 called");
        return "v2";
    }

}
