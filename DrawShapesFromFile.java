import java.util.Scanner;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;

public class DrawShapesFromFile{


    public static DrawableShape[] readFile(String filename){

        File file = new File(filename);
        
        try(Scanner scan = new Scanner(file)){
            int numberOfShapes = scan.nextInt();
            DrawableShape[] shapes = new DrawableShape[numberOfShapes];


            for (int i = 0; i < numberOfShapes; i++){
                String shapeType = scan.next();
                double x = scan.nextDouble();
                double y = scan.nextDouble();
                String colorname = scan.next();

                Color color;
                if(colorname.equals("red")){
                    color = Color.RED;
                } else if(colorname.equals("blue")){
                    color = Color.BLUE;
                } else{
                    color = Color.GREEN;
                }

                if(shapeType.equals("c")){
                    double radius = scan.nextDouble();
                    shapes[i] = new DrawableCircle(x ,y, color, radius);
                } 
                else if (shapeType.equals("r")){
                    double width = scan.nextDouble();
                    double height = scan.nextDouble();
                    shapes[i] = new DrawableRectangle(x ,y, color, width, height);
                }
                
            }

            return shapes;

        } catch (FileNotFoundException error){
            return new DrawableShape[0];
        }

    }

    public static void main(String[] args){
        DrawableShape[] shapes = readFile(args[0]);
    
        for(DrawableShape shape: shapes){
            shape.draw();
        }

    }

}