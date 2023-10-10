import java.awt.*;
import java.util.ArrayList;

/**

 Say you have an object, and you want to create an exact copy of it.
 How would you do it? First, you have to create a new object of the same class.
 Then you have to go through all the fields of the original object and copy their values over to the new object.

 The Prototype pattern delegates the cloning process to the actual objects that are being cloned.
 The pattern declares a common interface for all objects that support cloning.
 This interface lets you clone an object without coupling your code to the class of that object.
 Usually, such an interface contains just a single clone method.

 https://refactoring.guru/design-patterns/prototype

 **/

public class Main
{
    private static ArrayList<Shape> originalShapes = new ArrayList<>();

    public static void main(String[] args)
    {
        System.out.println("---Prototype---");

        //creating a new Rectangle Object // this probably isn't on the client side
        Rectangle myRect = new Rectangle(10, 5, Color.red, 25, 35);
        //creating a new Circle Object // this probably isn't on the client side
        Circle myCircle = new Circle(15, 6, Color.blue, 7);

        //"rectangleCopy" contains an exact copy of the "myRect" object
        Rectangle rectangleCopy = (Rectangle) myRect.Clone();
        //printing the properties of the cloned rectangle to see if they match with the original one
        System.out.println("Rectangle copy: " + rectangleCopy.toString());

        //"circleCopy" contains an exact copy of the "myCircle" object
        Circle circleCopy = (Circle) myCircle.Clone();
        //printing the properties of the cloned circle to see if they match with the original one
        System.out.println("Circle copy: " + circleCopy.toString());

        System.out.println("------");

        //adding the original shapes into the shape list for the second usecase test
        originalShapes.add(myRect);
        originalShapes.add(myCircle);

        SecondTest();

        System.out.println("------");

    }

    private static void SecondTest()
    {
        //Prototype rocks because it lets you produce a copy of an object without knowing anything about its type.
        ArrayList<Shape> shapeCopies = new ArrayList<>();

        //For instance, we don't know the exact elements in the
        // shapes array. All we know is that they are all
        // shapes. But thanks to polymorphism, when we call the
        // `clone` method on a shape the program checks its real
        // class and runs the appropriate clone method defined
        // in that class. That's why we get proper clones
        // instead of a set of simple Shape objects.
        for (Shape originalShape: originalShapes)
        {
            shapeCopies.add(originalShape.Clone());
        }
        System.out.println("Shapes copied to new List: ");
        for (Shape shapeCopy: shapeCopies)
        {
            System.out.println(shapeCopy.toString());
        }
    }
}