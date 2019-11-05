package A7Question1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadAndWriteString {

    public static void main(String[] args) {
        StringThings stringThings = new StringThings();
        try {
            FileWriter writer = new FileWriter("OriginalFile.txt");
            writer.write("What a crazy life. hi hello blaah. how are you. \nHello Bharathi \n hello Dileep \n nothing");
            writer.close();
            BufferedReader reader = new BufferedReader(new FileReader("OriginalFile.txt"));
            FileWriter writer1 = new FileWriter("ReversedFile.txt");

            String line;
            while ((line = reader.readLine()) != null) {
                String[] sentences = line.split("\\.\\s+");
                String reversedLine = "";
                for(String sentence: sentences) {
                    String reversedSentence = stringThings.reverseTheSentence(sentence);
                    reversedSentence += '.';
                    reversedLine += reversedSentence;
                }
                reversedLine += '\n';
                writer1.write(reversedLine);
            }
            writer1.close();
            BufferedReader reader1 = new BufferedReader(new FileReader("ReversedFile.txt"));
            System.out.println("Please check reversed file for Reversed Content");
            } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
