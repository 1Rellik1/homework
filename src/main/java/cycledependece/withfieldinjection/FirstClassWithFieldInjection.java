package cycledependece.withfieldinjection;

import cycledependece.FirstClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * todo agayntsev
 *
 * @author Alexey Gayntsev
 * @since 2024.09.15
 */
@Component
@Profile("field")
public class FirstClassWithFieldInjection implements FirstClass {
    private static final Logger LOGGER = LoggerFactory.getLogger(FirstClassWithFieldInjection.class);

    @Autowired
    private SecondClassWithFieldInjection secondClassWithFieldInjection;

    public void say(int i) {
        if (i == 1) {
            secondClassWithFieldInjection.say();
        } else {
            LOGGER.info("Say smth");
        }
    }

}
