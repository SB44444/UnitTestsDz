package seminars.third.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class TestDrivenDevelopment {

    //3.5. Red-Green-Refactor

    @Test
    public void testStep1AnalyseMood() {
        MoodAnalyser moodAnalyser = new MoodAnalyser();
        String message = "test failing";
        String mess = moodAnalyser.analyseMood(message);
        assertEquals("Make the test pass", mess);
    }

    @Test
    public void testStep2AnalyseMood() {
        MoodAnalyser moodAnalyser = new MoodAnalyser();
        String message = "test pass";
        String mess = moodAnalyser.analyseMood(message);
        assertEquals("refactor your cod", mess);
    }

    @Test
    public void testStep3AnalyseMood() {
        MoodAnalyser moodAnalyser = new MoodAnalyser();
        String message = "refactor your cod";
        String mess = moodAnalyser.analyseMood(message);
        assertEquals("Create test", mess);
    }
}