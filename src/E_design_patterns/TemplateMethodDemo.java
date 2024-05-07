package E_design_patterns;

import java.util.AbstractList;
import java.util.List;

abstract class Shape {
    // template method
    public void printInfo() {
        System.out.println(getDescription());
        System.out.println("area: " + getArea());
        System.out.println("perimeter: " + getPerimeter());
    }

    // default implementation, can be overridden by subclasses (but doesn't have to be)
    public String getDescription() {
        return "a shape";
    }

    // must be overridden by subclasses
    public abstract double getArea();
    public abstract double getPerimeter();
}

class Rectangle extends Shape {
    private final int length, width;

    Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double getArea() {
        return length * width;
    }

    @Override
    public double getPerimeter() {
        return 2 * length + 2 * width;
    }
}

class Circle extends Shape {
    private final int radius;

    Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public String getDescription() {
        return "a circle";
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}

public class TemplateMethodDemo {
    public static void main(String[] args) {
        Shape s1 = new Circle(10);
        s1.printInfo();
        System.out.println();
        Shape s2 = new Rectangle(4, 5);
        s2.printInfo();
    }

    public List<String> fizzBuzz(int n) {
        return new AbstractList<>() {
            @Override
            public String get(int index) {
                index++;

                if (index % 3 == 0 && index % 5 == 0) {
                    return "FizzBuzz";
                } else if (index % 3 == 0) {
                    return "Fizz";
                } else if (index % 5 == 0) {
                    return "Buzz";
                } else {
                    return String.valueOf(index);
                }
            }

            @Override
            public int size() {
                return n;
            }
        };
    }
}
