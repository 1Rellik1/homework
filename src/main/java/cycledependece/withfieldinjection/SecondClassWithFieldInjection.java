package cycledependece.withfieldinjection;

import cycledependece.ThirdClass;
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
public class SecondClassWithFieldInjection {
    @Autowired
    private ThirdClass thirdClass;

    public void say() {
        thirdClass.say();
    }

}
