import java.awt.*;

public class Shape implements PrototypeI
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

    @Override
    public Shape Clone()
    {
        return new Shape(this);
    }
}
