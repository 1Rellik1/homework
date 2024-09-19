package cycledependece;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * todo agayntsev
 *
 * @author Alexey Gayntsev
 * @since 2024.09.15
 */
@Component
public class SayApplicationRunner implements ApplicationRunner {
    @Autowired
    private FirstClass firstClass;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        firstClass.say(1);
    }
}
