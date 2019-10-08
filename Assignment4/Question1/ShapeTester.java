package Question1;


public class ShapeTester {

    public static void main(String[] args) {
        Shape s = new Shape();
        Rectangle r = new Rectangle(2.0,3.0);
        Circle c = new Circle(4.0);
        Square sq = new Square(4.0);

        System.out.println("Area of the rectangle is : "+ r.getArea());
        System.out.println("Perimeter of the rectangle is : "+ r.getPerimeter());
        System.out.println("Area of the circle is : "+ c.getArea());
        System.out.println("Perimeter of the circle is :"+ c.getPerimeter());
        System.out.println("Area of the square is : "+ sq.getArea());
        System.out.println("Perimeter of the square is : "+ sq.getPerimeter());
        r.draw();
        c.draw();
        s.draw();
        sq.draw();
    }
}
