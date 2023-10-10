import java.awt.*;

public class Rectangle extends Shape
{

    private int width, height;

    public Rectangle(Rectangle rectangle)
    {
        super(rectangle);
        this.width = rectangle.width;
        this.height = rectangle.height;
    }

    public Rectangle(int x, int y, Color color, int width, int height)
    {
        super(x, y, color);
        this.width = width;
        this.height = height;
    }

    //overwriting toString just for debugging/showcase purposes
    @Override
    public String toString()
    {
        return "I am a rectangle with the properties: " + "x: " + x +" y: " + y + " color: " + color + " width:" + width + " height: " + height;
    }

    @Override
    public Shape Clone()
    {
        return new Rectangle(this);
    }
}
