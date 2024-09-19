package cycledependecetest;

import cycledependece.CycleDependencyApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Общий класс тестов бинов с циклической зависимостью
 *
 * @author Alexey Gayntsev
 * @since 2024.09.15
 */
@SpringBootTest(classes = CycleDependencyApplication.class)
@RunWith(SpringRunner.class)
public abstract class CycleDependenceTest {
}
