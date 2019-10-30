package A6Question5;

import java.util.Iterator;
import java.util.LinkedList;

class Data {

    int key;
    int value;

    Data(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class MyHashMap {

    private LinkedList<Data>[] table = new LinkedList[100];

    public void put(Integer key, Integer value) {
        int index = hash(key);
        LinkedList list = table[index];

        if(list == null || list.isEmpty()) {
            Data data = new Data(key, value);
            LinkedList newList = new LinkedList<Data>();
            newList.add(data);
            table[index] = newList;
            return;
        }

        Iterator itr = list.iterator();
        while (itr.hasNext()) {
            Data data = (Data) itr.next();
            if (data.key == key) {
                data.key = value;
            }
        }
        list.addLast(new Data(key, value));
        table[index] = list;
    }

    public Integer get(Integer key) {
        int index = hash(key);
        LinkedList list = table[index];

        if (list == null || list.isEmpty()) {
            return -1;
        }

        Iterator itr = list.iterator();
        while (itr.hasNext()) {
            Data data = (Data) itr.next();
            if (data.key == key) {
                return data.value;
            }
        }
        return -1;
    }

    public void remove(Integer key) {
        int index = hash(key);
        LinkedList<Data> list = table[index];

        if (list == null || list.isEmpty()) {
            return;
        }
        for(int i = 0; i < list.size(); i++) {
            Data data = list.get(i);
            if(data.key == key) {
                list.remove(i);
                table[index] = list;
                return;
            }
        }
    }

    private int hash(int key) {
        int maxSize = table.length - 1;
        int index = key % maxSize;
        return index;
    }

}
