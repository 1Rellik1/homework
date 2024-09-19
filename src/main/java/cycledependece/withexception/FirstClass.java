package cycledependece.withexception;

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
@Profile("!setter && !lazy && !field")
public class FirstClass implements cycledependece.FirstClass {
    private static final Logger LOGGER = LoggerFactory.getLogger(FirstClass.class);


    private SecondClass secondClass;

    public FirstClass(SecondClass secondClass) {
        this.secondClass = secondClass;
    }

    public void say(int i) {
        if (i == 1) {
            secondClass.say();
        } else {
            LOGGER.info("Say smth");
        }
    }
}
