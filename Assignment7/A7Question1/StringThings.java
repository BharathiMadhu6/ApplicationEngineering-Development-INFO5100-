package A7Question1;

public class StringThings {
    public String reverseTheSentence(String sentence) {
        String[] splitString = sentence.split("\\s");
        String reversedString = "";
        for (int i = splitString.length - 1; i >= 0; i--) {
            reversedString = reversedString + " " + splitString[i];
        }
        return reversedString;
    }
}
