package us.ossowitz.springcourse;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");

        Music musicBean = context.getBean("musicBean", Music.class);

        System.out.println(musicBean.getSong());

        context.close();

    }
}
