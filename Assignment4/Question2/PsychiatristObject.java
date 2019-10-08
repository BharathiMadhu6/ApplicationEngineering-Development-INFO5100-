package Question2;

public class PsychiatristObject {

    public void examine(MoodyObject moodyObj) {
        System.out.println("How are you feeling today?");
        moodyObj.queryMood();
        moodyObj.expressFeelings();
    }

    public void observe(MoodyObject moodyObj) {
        System.out.println("Observation : "+ moodyObj.toString());
    }
}
