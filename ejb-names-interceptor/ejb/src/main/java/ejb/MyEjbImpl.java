package ejb;

import lib.Contextual;
import lib.MyEjbRemoteInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;

@Contextual
@Stateless
public class MyEjbImpl implements MyEjbRemoteInterface {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String foo(Long bar) {
        logger.debug("called");
        return "foo";
    }
}
