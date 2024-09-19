package cycledependecetest;

import cycledependece.FirstClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

/**
 * Тест циклической зависимости при использовании аннотации @Lazy.
 * Работает так как сначала внедряется прокси, а уже при использовании сам бин
 *
 * @author Alexey Gayntsev
 * @since 2024.09.15
 */
@ActiveProfiles("lazy")
public class CycleDependenceWithLazyTest extends CycleDependenceTest {

    @Autowired
    private FirstClass firstClass;

    @Test
    public void circularDependencyFail() {
        firstClass.say(1);
    }
}
