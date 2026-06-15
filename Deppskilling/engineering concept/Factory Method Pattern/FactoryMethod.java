interface Shape {
    void draw();
}
class Circle implements Shape {
    public void draw() {
        System.out.println("Drawing Circle");
    }
}
class Rectangle implements Shape {
    public void draw() {
        System.out.println("Drawing Rectangle");
    }
}
class ShapeFactory {
    public Shape getShape(String type) {
        if(type.equalsIgnoreCase("Circle")) {
            return new Circle();
        }
        return new Rectangle();
    }
}
public class FactoryMethod {
    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();
        Shape shape = factory.getShape("Circle");
        shape.draw();
    }
}