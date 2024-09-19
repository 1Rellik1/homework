package cycledependece.withexception;

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
public class SecondClass {

    private ThirdClass thirdClass;

    public SecondClass(ThirdClass thirdClass) {
        this.thirdClass = thirdClass;
    }

    public void say() {
        thirdClass.say();
    }
}
