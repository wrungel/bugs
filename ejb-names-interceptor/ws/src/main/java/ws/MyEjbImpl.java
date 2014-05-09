package ws;

import lib.Contextual;
import org.jboss.ws.api.annotation.WebContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.jws.WebService;


@Stateless
@Contextual
@WebService(targetNamespace = "http://v1.example.com/")
@WebContext(contextRoot = "MyWebservice/v2")
public class MyEjbImpl {
    /**
     * Name of Stateless-Bean and Namespace of XML-Types.
     */
    public static final String name = "MyWebservice-V2";

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public String foo(Long bar) {
        logger.debug("called");
        return "";
    }

}
