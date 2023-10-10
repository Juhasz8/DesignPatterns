import java.awt.*;

public class Circle extends Shape
{
    private int radius;

    public Circle(Circle circle)
    {
        super(circle);
        this.radius = circle.radius;
    }

    public Circle(int x, int y, Color color, int radius)
    {
        super(x, y, color);
        this.radius = radius;
    }

    //overwriting toString just for debugging/showcase purposes
    @Override
    public String toString()
    {
        return "I am a circle with the properties: " + "x: " + x +" y: " + y + " color: " + color + " radius: " + radius;
    }

    @Override
    public Shape Clone()
    {
        return new Circle(this);
    }
}
