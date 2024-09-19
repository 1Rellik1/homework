package proxiesWithoutSpringBoot.aopproxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * todo agayntsev
 *
 * @author Alexey Gayntsev
 * @since 2024.09.15
 */
@Component
public class ClassToBeProxiedForAopWithoutInterface {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClassToBeProxiedForAopWithoutInterface.class);

    public void say() {
        LOGGER.debug("say smth");
    }
}
