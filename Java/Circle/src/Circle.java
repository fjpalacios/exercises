
class Circle {

    static double pi = 3.1415926;
    int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    public static double area(int radius) {
        return pi * Math.pow(radius, 2);
    }

    public static double perimeter(int radius) {
        return 2 * pi * radius;
    }

}
