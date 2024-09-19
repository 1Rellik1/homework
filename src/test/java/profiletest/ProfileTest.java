package profiletest;

import org.junit.Test;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import profiles.DevOrTestProfileClass;
import profiles.DevProfileClass;
import profiles.NotDevProfileClass;
import profiles.ProfilesApplication;
import profiles.TestProfileClass;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

/**
 * Тест создания бинов с различными профилями.
 *
 * @author Alexey Gayntsev
 * @since 2024.09.15
 */
public class ProfileTest {
    private final ApplicationContextRunner contextRunner = new ApplicationContextRunner();

    @Test
    public void testDevProfile() {
        contextRunner.withUserConfiguration(ProfilesApplication.class).withPropertyValues("spring.profiles.active=dev").run(context -> assertAll(
                () -> assertThat(context).hasSingleBean(DevProfileClass.class),
                () -> assertThat(context).hasSingleBean(DevOrTestProfileClass.class),
                () -> assertThat(context).doesNotHaveBean(NotDevProfileClass.class),
                () -> assertThat(context).doesNotHaveBean(TestProfileClass.class)));

    }

    @Test
    public void testTestProfile() {
        contextRunner.withUserConfiguration(ProfilesApplication.class).withPropertyValues("spring.profiles.active=test").run(context -> assertAll(
                () -> assertThat(context).doesNotHaveBean(DevProfileClass.class),
                () -> assertThat(context).hasSingleBean(DevOrTestProfileClass.class),
                () -> assertThat(context).hasSingleBean(NotDevProfileClass.class),
                () -> assertThat(context).hasSingleBean(TestProfileClass.class)));

    }

    @Test
    public void testWithoutProfile() {
        contextRunner.withUserConfiguration(ProfilesApplication.class).run(context -> assertAll(
                () -> assertThat(context).doesNotHaveBean(DevProfileClass.class),
                () -> assertThat(context).doesNotHaveBean(DevOrTestProfileClass.class),
                () -> assertThat(context).hasSingleBean(NotDevProfileClass.class),
                () -> assertThat(context).doesNotHaveBean(TestProfileClass.class)));

    }
}
