package Question1;


public class Rectangle extends Shape {

    public double width;
    public double height;

    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getPerimeter() {
        perimeter = Math.round(2 * (width + height) * 100.0) / 100.0;
        return perimeter;
    }

    public double getArea() {
        area = Math.round(width * height * 100.0) / 100.0;
        return area;
    }

    public void draw() {
        System.out.println("Drawing Rectangle \n");
    }
}
