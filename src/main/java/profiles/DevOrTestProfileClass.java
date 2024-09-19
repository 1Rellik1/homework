package profiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * todo agayntsev
 *
 * @author Alexey Gayntsev
 * @since 2024.09.15
 */
@Profile({"test", "dev"})
@Component
public class DevOrTestProfileClass {
}
