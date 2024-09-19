package cycledependecetest;

import cycledependece.FirstClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Тест циклической зависимости при внедрении в поля класса.
 * Работает так как зависимость внедряется уже после того, как класс создан.
 *
 * @author Alexey Gayntsev
 * @since 2024.09.15
 */
@ActiveProfiles("field")
public class CycleDependenceWithFieldInjectionTest extends CycleDependenceTest {

    @Autowired
    private FirstClass firstClass;

    @Test
    public void circularDependencyFail() {
        assertThat(firstClass).isNotNull();
        firstClass.say(1);
    }
}
