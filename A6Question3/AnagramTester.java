package A6Question3;

import java.util.Arrays;

public class AnagramTester {

    public boolean isAnagram(String string1, String string2) {
        string1 = string1.toLowerCase();
        string2 = string2.toLowerCase();

        if(string1.equalsIgnoreCase(string2)) {
            return true;
        }

        String sString = reArrange(string1);
        String tString = reArrange(string2);

        if (sString.equalsIgnoreCase(tString)) {
            return true;
        }
        else {
            return false;
        }
    }

    public String reArrange(String a) {
        char[] s1 = a.toCharArray();
        char temp;
        for (int i = 0; i < s1.length; i++) {
            for (int j = i + 1; j < s1.length; j++) {
                if(s1[j] < s1[i]) {
                    temp = s1[i];
                    s1[i] = s1[j];
                    s1[j] = temp;
                }
            }
        }
        String result = Arrays.toString(s1);
        return result;
    }

}



