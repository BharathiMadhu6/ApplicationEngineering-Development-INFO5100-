package A5Question5;

import A5Question5.Cat.Cat;
import A5Question5.Dog.Dog;

public class PetRunner {

    public static void main(String[] args) {
        Dog dog = new Dog("Spotty","Madhu","Brown and White","Small");
        Cat cat = new Cat("Garfield","Latha","Black","Long");
        dog.setSex(2);
        System.out.println(dog.toString());
        dog.setBoardStart(10,27,2011);
        dog.setBoardEnd(10,29,2011);
        boolean dogStatus = dog.boarding(10,28,2011);
        System.out.println("\nDOG Boarding status : " +dogStatus+"\n");
        cat.setSex(3);
        System.out.println(cat.toString());
        cat.setBoardEnd(12,3,2012);
        cat.setBoardStart(12,25,2010);
        boolean catStatus = cat.boarding(10,30,2011);
        System.out.println("\nCAT Boarding status : " +catStatus);

    }
}
