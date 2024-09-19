package proxiesWithSpringBoot.aopproxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import proxiesWithSpringBoot.ProxyInterface;

/**
 * todo agayntsev
 *
 * @author Alexey Gayntsev
 * @since 2024.09.15
 */
@Component
@Qualifier()
public class ClassToBeProxiedForAopWithInterface implements ProxyInterface {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClassToBeProxiedForAopWithInterface.class);

    public void say() {
        LOGGER.debug("say smth");
    }
}
