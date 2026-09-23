
import java.awt.Color;

public class DrawableRectangle extends DrawableShape{

    protected double height;
    
    protected double width;

    public DrawableRectangle(double x, double y, Color color, double width, double height){
        super(x, y, color);
        
        this.height = height;

        this.width = width;
    }

    public double getHeight(){
        return height;
    }

    public double getWidth(){
        return width;
    }

    public double area(){
        return height * width;
    }

    public void draw(){
        StdDraw.setPenColor(color);
        StdDraw.filledRectangle(x, y, width / 2, height / 2);
    }

    public static void main(String[] args) {
        DrawableRectangle r = new DrawableRectangle(1, 2, Color.RED, 2.5, 2.5);
        r.draw();
        System.out.println(r.area());

        DrawableRectangle e = new DrawableRectangle(0.25, 0.1, Color.BLACK, 0.5, 0.5);
        e.draw();
        System.out.println(e.area());
    }

}