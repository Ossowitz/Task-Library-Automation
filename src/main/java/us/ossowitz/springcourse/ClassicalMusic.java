package us.ossowitz.springcourse;

public class ClassicalMusic implements Music {

    public void doMyInit() {
        System.out.println("Do my initialization");
    }

    public void doMyDestroy() {
        System.out.println("Do my destruction");
    }

    @Override
    public String getSong() {
        return "Hungarian Rhapsody";
    }
}
