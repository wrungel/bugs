package ejb;

import lib.A;
import org.jboss.ws.api.annotation.WebContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.jws.WebService;


@Stateless(name = MyWebservice.name)
@WebService(targetNamespace = "http://v1.example.com/")
@WebContext(contextRoot = "MyWebservice/v2")
public class MyWebservice {
    /**
     * Name of Stateless-Bean and Namespace of XML-Types.
     */
    public static final String name = "MyWebservice-V2";

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Inject private Provider<A> a;

    public String foo() {
        String result = "[" + this.hashCode() + "]: totalMemory = " + Runtime.getRuntime().totalMemory() / (1024*1024) + "MByte";
        a.get();
        logger.info(result);
        return result;
    }

}
