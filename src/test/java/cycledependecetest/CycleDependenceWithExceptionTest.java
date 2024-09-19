package cycledependecetest;

import cycledependece.CycleDependencyApplication;
import cycledependece.withlazy.FirstClassWithLazy;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.UnsatisfiedDependencyException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Тест падает с ошибкой при поднятии контекста, так как бины имеют цикличскую зависимость при внедрении через конструктор
 *
 * @author Alexey Gayntsev
 * @since 2024.09.15
 */
public class CycleDependenceWithExceptionTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(CycleDependenceWithExceptionTest.class);


    @Test
    public void circularDependencyFail() {
        ApplicationContext context = null;
        try {
            context = new AnnotationConfigApplicationContext(CycleDependencyApplication.class);
        } catch (UnsatisfiedDependencyException e) {
            assertThat(e.getLocalizedMessage())
                    .contains("Requested bean is currently in creation: Is there an unresolvable circular reference");
            LOGGER.error("Can`t create context. Circular reference");
        }
        assertThat(context).isNull();
    }
}
