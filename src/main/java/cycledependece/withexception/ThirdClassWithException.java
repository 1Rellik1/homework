package cycledependece.withexception;

import cycledependece.FirstClass;
import cycledependece.ThirdClass;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * todo agayntsev
 *
 * @author Alexey Gayntsev
 * @since 2024.09.15
 */
@Component
@Profile("!setter && !lazy && !field")
public class ThirdClassWithException implements ThirdClass {

    private FirstClass firstClass;

    public ThirdClassWithException(FirstClass firstClass) {
        this.firstClass = firstClass;
    }

    public void say() {
        firstClass.say(0);
    }
}
