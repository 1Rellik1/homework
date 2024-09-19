package proxiesWithSpringBoot.transactionproxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import proxiesWithSpringBoot.ProxyInterface;

/**
 * todo agayntsev
 *
 * @author Alexey Gayntsev
 * @since 2024.09.15
 */
@Component
public class ClassToBeProxiedForTransactionWithInterface implements ProxyInterface {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClassToBeProxiedForTransactionWithInterface.class);

    @Transactional
    public void say() {
        LOGGER.debug("say smth");
    }
}
