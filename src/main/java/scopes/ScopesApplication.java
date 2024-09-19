package scopes;

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
public class ScopesApplication {
    public static void main(final String[] args) {
        SpringApplication.run(ScopesApplication.class, args);
    }
}
