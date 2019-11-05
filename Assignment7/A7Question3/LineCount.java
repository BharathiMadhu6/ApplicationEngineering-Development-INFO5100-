package A7Question3;

import java.io.BufferedReader;
import java.io.FileReader;

public class LineCount {

    public static void main(String[] args) {
        int length = args.length;
        for (int i = 0; i < length; i++) {
            try {
                int count = 0;
                BufferedReader reader = new BufferedReader(new FileReader(args[i]));
                while (reader.readLine() != null) {
                    count++;
                }
                reader.close();
                System.out.println("Number of lines in "+args[i]+" is : " + count);
            } catch(Exception e) {
                System.out.println("Exception in file "+ args[i] +" " + e.getMessage());
                continue;
            }
        }
    }
}
