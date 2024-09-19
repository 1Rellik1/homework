package proxyTestWithSpringBoot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import proxiesWithSpringBoot.ProxyApplication;
import proxiesWithSpringBoot.ProxyHelper;
import proxiesWithSpringBoot.ProxyInterface;
import proxiesWithSpringBoot.aopproxy.ClassToBeProxiedForAopWithoutInterface;
import proxiesWithSpringBoot.transactionproxy.ClassToBeProxiedForTransactionWithInterface;
import proxiesWithSpringBoot.transactionproxy.ClassToBeProxiedForTransactionWithoutInterface;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.util.ClassUtils.CGLIB_CLASS_SEPARATOR;


/**
 * Тест создания прокси с использования Spring Boot.
 * По умолчанию для всех классов используется cglib.
 *
 * @author Alexey Gayntsev
 * @since 2024.09.15
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProxyApplication.class)
public class ProxyTestWithDefaultProfile {
    @Autowired
    private ProxyHelper proxyHelper;

    @Autowired
    private ProxyInterface classToBeProxiedForTransactionWithInterface;
    @Autowired
    private ClassToBeProxiedForTransactionWithoutInterface classToBeProxiedForTransactionWithoutInterface;
    @Autowired
    private ClassToBeProxiedForAopWithoutInterface classToBeProxiedForAopWithoutInterface;
    @Autowired
    private ProxyInterface classToBeProxiedForAopWithInterface;


    @Test
    public void createProxyTest() {
        Object proxiedClassWithoutInterface = proxyHelper.createProxy(new ClassToBeProxiedForTransactionWithoutInterface());
        Object proxiedClassWithInterface = proxyHelper.createProxy(new ClassToBeProxiedForTransactionWithInterface());
        //Созданные вручную прокси, так как создается новый экземпляр ProxyFactory,
        // то не используется настройка setProxyTargetClass(true) из Spring Boot
        assertThat(proxiedClassWithoutInterface.getClass().getName()).contains(CGLIB_CLASS_SEPARATOR);
        assertThat(proxiedClassWithInterface.getClass().getName()).doesNotContain(CGLIB_CLASS_SEPARATOR);

        //При использовании @EnableTransactionManagement вместе со Spring boot автоматически используется CGLIB
        assertThat(classToBeProxiedForTransactionWithInterface.getClass().getName()).contains(CGLIB_CLASS_SEPARATOR);
        assertThat(classToBeProxiedForTransactionWithoutInterface.getClass().getName()).contains(CGLIB_CLASS_SEPARATOR);

        //Spring boot использует cglib по умолчанию
        assertThat(classToBeProxiedForAopWithoutInterface.getClass().getName()).contains(CGLIB_CLASS_SEPARATOR);
        assertThat(classToBeProxiedForAopWithInterface.getClass().getName()).contains(CGLIB_CLASS_SEPARATOR);

    }
}
