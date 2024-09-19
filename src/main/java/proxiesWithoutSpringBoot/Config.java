package proxiesWithoutSpringBoot;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * todo agayntsev
 *
 * @author Alexey Gayntsev
 * @since 2024.09.16
 */
@ComponentScan
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class Config {
}
