package cycledependecetest;

import cycledependece.FirstClass;
import org.junit.Test;
import org.springframework.beans.factory.BeanCurrentlyInCreationException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Тест падает с ошибкой при поднятии контекста, так как бины имеют цикличскую зависимость при внедрении через конструктор
 *
 * @author Alexey Gayntsev
 * @since 2024.09.15
 */
public class CycleDependenceWithExceptionTest extends CycleDependenceTest {
    @Autowired
    private FirstClass firstClass;

    @Test
    public void circularDependencyFail() {
        try {
            firstClass.say(1);
        } catch (BeanCurrentlyInCreationException e) {
            System.out.println("fail");
        }

    }
}
