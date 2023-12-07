import java.awt.*;

public class Shape implements IPrototype
{
    protected int x, y;
    protected Color color;

    public Shape(Shape shape)
    {
        this.x = shape.x;
        this.y = shape.y;
        this.color = shape.color;
    }

    public Shape(int x, int y, Color color)
    {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    //overwriting toString just for debugging/showcase purposes
    @Override
    public String toString()
    {
        return "I am just a shape";
    }

    @Override
    public Shape Clone()
    {
        return new Shape(this);
    }
}
