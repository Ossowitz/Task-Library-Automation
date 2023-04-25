package us.ossowitz.springcourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:musicPlayer.properties")
@ComponentScan("us.ossowitz.springcourse")
public class SpringConfig {

    @Bean
    public ClassicalMusic classicalMusicBean() {
        return new ClassicalMusic();
    }

    @Bean
    public RockMusic rockMusicBean() {
        return new RockMusic();
    }

    @Bean
    public MusicPlayer musicPlayerBean() {
        return new MusicPlayer(classicalMusicBean(), rockMusicBean());
    }
}
