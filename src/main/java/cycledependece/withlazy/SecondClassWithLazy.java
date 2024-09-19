package cycledependece.withlazy;

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
@Profile("lazy")
public class SecondClassWithLazy {

    private ThirdClass thirdClass;

    public SecondClassWithLazy(ThirdClass thirdClass) {
        this.thirdClass = thirdClass;
    }

    public void say() {
        thirdClass.say();
    }
}
