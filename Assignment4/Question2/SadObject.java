package Question2;

public class SadObject extends MoodyObject {

    protected String getMood() {
        return "I feel sad today! \n";
    }

    protected void expressFeelings() {
        System.out.println("'wah' 'boo hoo' 'weep' 'sob' 'weep'");
    }

    public String toString() {
        String msg = "Subject cries a lot";
        return msg;
    }
}
