package ejb;

import lib.A;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Provider;

@Stateless
@Remote(MyEjbRemoteInterface.class)
public class MyEjb implements MyEjbRemoteInterface {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /// [1]
    @Inject
    private Provider<A> a;

    @Override
    public String foo() {
        String result = "[" + this.hashCode() + "]: totalMemory = " + Runtime.getRuntime().totalMemory() / (1024*1024) + "MByte";
        a.get();
        logger.info(result);
        return result;
    }
}
