package proxiesWithSpringBoot;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.stereotype.Component;

/**
 * todo agayntsev
 *
 * @author Alexey Gayntsev
 * @since 2024.09.15
 */
@Component
public class ProxyHelper {

    public Object createProxy(Object object){
        ProxyFactory factory = new ProxyFactory(object);
        return factory.getProxy();
    }
}
