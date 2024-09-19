package proxiesWithoutSpringBoot;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * todo agayntsev
 *
 * @author Alexey Gayntsev
 * @since 2024.09.16
 */
@Aspect
@Component
public class AspectClass {

    @Around("execution(* proxiesWithoutSpringBoot.aopproxy..*.*(..))")
    public Object chronoAround(ProceedingJoinPoint joinPoint) throws Throwable {
        return joinPoint.proceed();

    }
}
