package cycledependece.withsetter;

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
@Profile("setter")
public class SecondClassWithSetter {


    private ThirdClass thirdClass;

    public void say() {
        thirdClass.say();
    }


    @Autowired
    public void setThirdClass(ThirdClass thirdClass) {
        this.thirdClass = thirdClass;
    }
}
