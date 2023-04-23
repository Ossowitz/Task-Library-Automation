package us.ossowitz.springcourse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestSpring {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(SpringConfig.class);

        var computer = context.getBean("computer", Computer.class);
        System.out.println(computer.toString());

        var musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        System.out.println(musicPlayer.getSomeName());
        System.out.println(musicPlayer.getValue());
    }
}
