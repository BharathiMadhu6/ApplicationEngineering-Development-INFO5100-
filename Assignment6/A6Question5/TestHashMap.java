package A6Question5;

public class TestHashMap {

    public static void main(String[] args) {
        MyHashMap hashMapImp = new MyHashMap();
        hashMapImp.put(1, 10);
        hashMapImp.put(2, 2);
        System.out.println(hashMapImp.get(1));
        System.out.println(hashMapImp.get(3));
        hashMapImp.put(2, 1);
        System.out.println(hashMapImp.get(2));
        hashMapImp.remove(2);
        System.out.println(hashMapImp.get(2));
        System.out.println(hashMapImp.get(2));
        System.out.println(hashMapImp.get(2));
        hashMapImp.remove(1);
        System.out.println(hashMapImp.get(1));
        hashMapImp.put(3, 35);
        System.out.println(hashMapImp.get(3));
        hashMapImp.remove(3);
        System.out.println(hashMapImp.get(3));
    }
}

