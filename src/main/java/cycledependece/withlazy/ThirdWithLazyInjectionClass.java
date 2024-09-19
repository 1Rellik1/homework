package cycledependece.withlazy;

import cycledependece.FirstClass;
import cycledependece.ThirdClass;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * todo agayntsev
 *
 * @author Alexey Gayntsev
 * @since 2024.09.15
 */
@Component
@Profile("lazy")
public class ThirdWithLazyInjectionClass implements ThirdClass {

    private FirstClass firstClass;

    public ThirdWithLazyInjectionClass(@Lazy FirstClass firstClass) {
        this.firstClass = firstClass;
    }

    public void say() {
        firstClass.say(0);
    }
}
