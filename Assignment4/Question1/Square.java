package Question1;

public class Square extends Shape {

    public double side;

    Square(double side) {
        this.side = side ;
    }

    public double getArea() {
        area = Math.round(side * side * 100.0) / 100.0;
        return area;
    }

    public double getPerimeter() {
        perimeter = Math.round(side * 4 * 100.0) / 100.0;
        return perimeter;
    }

    public void draw() {
        System.out.println("Drawing Square \n");
    }

}
