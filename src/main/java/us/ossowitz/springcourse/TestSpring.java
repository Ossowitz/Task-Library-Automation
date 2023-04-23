package us.ossowitz.springcourse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(SpringConfig.class);
        var computer = context.getBean("computer", Computer.class);
        System.out.println(computer.toString());
    }
}
