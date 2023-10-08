package seminars.third.tdd;

public class MoodAnalyser {

    public String analyseMood(String message) {
        System.out.println("Create test");

        if ("test failing".contains(message)) {
            return "Make the test pass";
        } else if ("test pass".contains(message)) {
            return "refactor your cod";
        }
        return "Create test";
    }
}
