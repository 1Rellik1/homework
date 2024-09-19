package cycledependece.withsetter;

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
@Profile("setter")
public class FirstClassWithSetter implements FirstClass {
    private static final Logger LOGGER = LoggerFactory.getLogger(FirstClassWithSetter.class);

    private SecondClassWithSetter secondClassWithSetter;

    public void say(int i) {
        if (i == 1) {
            secondClassWithSetter.say();
        } else {
            LOGGER.info("Say smth");
        }
    }

    @Autowired
    public void setSecondClassWithSetter(SecondClassWithSetter secondClassWithSetter) {
        this.secondClassWithSetter = secondClassWithSetter;
    }
}
