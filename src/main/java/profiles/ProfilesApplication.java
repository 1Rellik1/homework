package profiles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * todo agayntsev
 *
 * @author Alexey Gayntsev
 * @since 2024.09.15
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ProfilesApplication {
    public static void main(final String[] args) {
        SpringApplication.run(ProfilesApplication.class, args);
    }
}
