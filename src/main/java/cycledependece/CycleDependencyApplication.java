package cycledependece;

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
public class CycleDependencyApplication {
    public static void main(final String[] args) {
        SpringApplication.run(CycleDependencyApplication.class, args);
        System.exit(0);
    }
}
