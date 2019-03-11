public class Circle extends Shape {

    //attributes
    private double radius;

    //constructors
    public Circle(double radius){
        this.radius = radius;
    }

    public Circle(double radius, String color){
        super(color);
        this.radius = radius;
    }

    //getter
    public double getRadius(){
        return radius;
    }

    /**
     * Returns the area of the circle by using the formula radius*radius*PI
     *
     * @return area of circle
     */
    public double getArea(){
        return radius * radius * Math.PI;
    }

    /**
     * Returns the perimeter of the circle by using the formula 2*radius*PI
     *
     * @return perimeter of circle
     */
    public double getPerimeter(){
        return 2 * radius * Math.PI;
    }

    @Override
    public String toString(){
        return "Shape: Circle, radius:" + radius;
    }

}
