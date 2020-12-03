/**
A class of rectangles.
*/
public class Rectangle implements Measurable
{
    private double myWidth;
    private double myHeight;

    public Rectangle (double width, double height)
    {
        myWidth = width;
        myHeight = height;
    }


    public double getPerimeter ()
    {
        return 2 * (myWidth + myHeight);
    }


    public double getArea ()
    {
        return myWidth * myHeight;
    }
}