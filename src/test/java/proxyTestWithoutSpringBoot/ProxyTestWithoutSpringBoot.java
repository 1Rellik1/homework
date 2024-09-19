package proxyTestWithoutSpringBoot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import proxiesWithoutSpringBoot.Config;
import proxiesWithoutSpringBoot.ProxyInterface;
import proxiesWithoutSpringBoot.aopproxy.ClassToBeProxiedForAopWithoutInterface;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.util.ClassUtils.CGLIB_CLASS_SEPARATOR;


/**
 * Тест создания прокси без использования Spring Boot.
 * По умолчанию для классов с интерфейсами используется JDk proxy, в противном случае cglib.
 *
 * @author Alexey Gayntsev
 * @since 2024.09.15
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Config.class)
public class ProxyTestWithoutSpringBoot {


    @Autowired
    private ClassToBeProxiedForAopWithoutInterface classWithoutInterface;
    @Autowired
    private ProxyInterface classToBeProxiedForAopWithInterface;

    @Autowired
    private ClassToBeProxiedForAopWithoutInterface classWithoutInterface1;
    @Autowired
    private ProxyInterface classToBeProxiedForTransactionWithInterface;

    @Test
    public void createProxyTest() {

        assertThat(classWithoutInterface.getClass().getName()).contains(CGLIB_CLASS_SEPARATOR);
        assertThat(classToBeProxiedForAopWithInterface.getClass().getName()).doesNotContain(CGLIB_CLASS_SEPARATOR);

        assertThat(classWithoutInterface1.getClass().getName()).contains(CGLIB_CLASS_SEPARATOR);
        assertThat(classToBeProxiedForTransactionWithInterface.getClass().getName()).doesNotContain(CGLIB_CLASS_SEPARATOR);
    }
}
