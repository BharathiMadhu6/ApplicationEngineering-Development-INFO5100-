package A6Question4;

import java.util.*;

public class CheckElements {

    public boolean check(int[] elements) {
        HashMap<Integer, Integer> countList = new HashMap<Integer, Integer>();

        for (int i = 0; i < elements.length; i++) {
            if(countList.containsKey(elements[i])) {
                Integer value = countList.get(elements[i]);
                value = value + 1;
                countList.put(elements[i], value);
            } else {
                countList.put(elements[i], 1);
            }
        }

        List<Integer> arr = new ArrayList<Integer>(countList.values());

         for (int i = 0; i < arr.size() - 1; i++) {
            for(int j = 1; j < arr.size(); j++){
                if(arr.get(i) != arr.get(j)) {
                    return true;
                }
            }
        }
            return false;
    }
}
