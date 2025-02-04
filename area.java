class Shape {
    
    // area of a Circle
    public double calculateArea(double radius) {
        return Math.PI * radius * radius;
    }

    // area of a Rectangle
    public double calculateArea(double length, double breadth) {
        return length * breadth;
    }

    // area of a Triangle
    public double calculateAreatri(double base, double height) {
        return 0.5 * base * height;
    }

    public static void main(String[] args) {
        Shape shape = new Shape();

        double circleArea = shape.calculateArea(5.0);
        System.out.println("Area of Circle: " + circleArea);

        double rectangleArea = shape.calculateArea(4.0, 6.0);
        System.out.println("Area of Rectangle: " + rectangleArea);

        double triangleArea = shape.calculateAreatri(3.0, 8.0);
        System.out.println("Area of Triangle: " + triangleArea);
    }
}
