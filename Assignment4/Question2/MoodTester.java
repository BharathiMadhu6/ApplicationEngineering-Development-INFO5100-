package Question2;

public class MoodTester {

    public static void main(String[] args) {

        PsychiatristObject psych = new PsychiatristObject();

        SadObject sad = new SadObject();
        HappyObject happy = new HappyObject();

        psych.examine(happy);
        psych.observe(happy);

        System.out.println();

        psych.examine(sad);
        psych.observe(sad);
    }
}
