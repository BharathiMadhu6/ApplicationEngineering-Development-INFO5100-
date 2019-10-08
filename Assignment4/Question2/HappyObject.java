package Question2;

public class HappyObject extends MoodyObject{

    protected String getMood() {
        String mood = "I feel happy today! \n";
        return mood;
    }

    protected void expressFeelings() {
        System.out.println("hehehe...hahahah...HAHAHAHAHA!!!");
    }

    public String toString() {
        String msg = "Subject laughs a lot";
        return msg;
    }
}
