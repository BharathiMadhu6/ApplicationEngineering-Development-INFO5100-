package Question1;

public class Circle extends Shape {

    public double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        area = Math.round(Math.PI * radius * radius * 100.0) / 100.0;
        return area;
    }

    public double getPerimeter() {
        perimeter = Math.round(2 * radius * Math.PI * 100.0) / 100.0;
        return perimeter;
    }

    public void draw() {
        System.out.println("Drawing Circle \n");
    }
}
