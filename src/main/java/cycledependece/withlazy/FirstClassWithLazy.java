package cycledependece.withlazy;

import cycledependece.FirstClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class FirstClassWithLazy implements FirstClass {
    private static final Logger LOGGER = LoggerFactory.getLogger(FirstClassWithLazy.class);


    private SecondClassWithLazy secondClassWithLazy;

    public FirstClassWithLazy(SecondClassWithLazy secondClassWithLazy) {
        this.secondClassWithLazy = secondClassWithLazy;
    }

    public void say(int i) {
        if (i == 1) {
            secondClassWithLazy.say();
        } else {
            LOGGER.info("Say smth");
        }
    }
}
