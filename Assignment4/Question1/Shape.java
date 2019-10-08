package Question1;

public class Shape {

    public String name;
    public double perimeter;
    public double area;

    public void draw(){
        System.out.println("Drawing Shape \n");
    }

    public double getArea(){
        return area;
    }

    public double getPerimeter(){
        return perimeter;
    }
}
