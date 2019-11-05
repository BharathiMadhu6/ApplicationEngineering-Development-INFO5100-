package A7Question2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

public class EncodeDecode {

    public static void main(String[] args) {
        try {
            // assuming the given file contains a single line
            BufferedReader reader = new BufferedReader(new FileReader("encode.txt"));
            String s = reader.readLine();
            reader.close();
            String decodedString = decodeString(s);
            FileWriter writer1 = new FileWriter("decoded.txt");
            writer1.write(decodedString);
            System.out.println(decodedString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String decodeString(String inputString) {

        String result = "";
        if (inputString == null || inputString == "") {
            return null;
        }

        Stack stack = new Stack();
        char[] characters = inputString.toCharArray();
        for (Character element : characters) {

            if (Character.isDigit(element) || Character.isLetter(element) || element == '[') {
                stack.push(element);
            }

            if (element == ']') {
                // pop until opening + 1
                String innerString = "";
                String multipledInnerString = "";
                int index = 0;
                String character = "";
                while (!stack.isEmpty() && index != -1) {
                    Object subString = stack.pop();
                    if(subString instanceof String) {
                        character = (String) subString;
                    } else if (subString instanceof Character) {
                        character = Character.toString((Character) subString);
                    }
                    if(character.equals("[")) {
                        index = -1;
                    } else {
                        innerString = character + innerString;
                    }
                }

                if (!stack.isEmpty()) {
                    Character numberChar = (Character) stack.pop();
                    if (Character.isDigit(numberChar)) {
                        int number = Character.getNumericValue(numberChar);
                        for (int i = 0; i < number; i++) {
                            multipledInnerString = multipledInnerString + innerString;
                        }
                    } else {
                        multipledInnerString = innerString;
                    }
                }
                stack.push(multipledInnerString);
            }
        }
        // check whether stack is empty
        // result = stacks left over elements + result
        while(!stack.isEmpty()) {
            Object subString = stack.pop();
            if(subString instanceof String) {
                result = (String) subString + result;
            } else if (subString instanceof Character) {
                result = (Character) subString + result;
            }
        }
        return result;
    }
}
