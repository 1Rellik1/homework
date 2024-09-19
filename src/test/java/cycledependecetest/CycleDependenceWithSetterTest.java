package cycledependecetest;

import cycledependece.FirstClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

/**
 * Тест циклической зависимости при внедрении в поля класса.
 * Работает так как зависимость внедряется уже после того, как класс создан.
 *
 * @author Alexey Gayntsev
 * @since 2024.09.15
 */
@ActiveProfiles("setter")
public class CycleDependenceWithSetterTest extends CycleDependenceTest {

    @Autowired
    private FirstClass firstClass;

    @Test
    public void circularDependencyFail() {
        firstClass.say(1);
    }
}
