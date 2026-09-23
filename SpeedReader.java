/**
 * Program to implement RSVP speed reader using StdDraw library.
 *
 * This assignment originally created by Peter-Michael Osera at University of Pennsylvania.
 * 
 * @author Chris Murphy
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SpeedReader {

    /*
    This method is responsible for updating the text in the window for the speed reader.
    You will need to change the parameters as you complete this part of the assignment.
     */
    public static void show(String filename, int rate){

        File file = new File(filename);

        // this sets up the window... don't forget to call it!

        // this represents the number to be displayed in the window
        
    

        try(Scanner scan = new Scanner(file)){
            setup();

            while(scan.hasNext()){
                
            
                if(StdDraw.isMousePressed()){
                String word = scan.next();


                if (word.length() % 2 == 0){
                    int index = word.length() / 2;
                    char redLetter = word.charAt(index);
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.text(46.25, 50, word);
                    StdDraw.setPenColor(StdDraw.RED);
                    StdDraw.text(50, 50, String.valueOf(redLetter));
                }
                else if (word.length() % 2 == 1){
                    int index = word.length() / 2;
                    char redLetter = word.charAt(index);
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.text(50, 50, word);
                    StdDraw.setPenColor(StdDraw.RED);
                    StdDraw.text(50, 50, String.valueOf(redLetter));
                }

                StdDraw.show();
                StdDraw.pause(60000 / rate);
                StdDraw.clear();

                }

            }

        } catch (FileNotFoundException error){
            System.out.println("Error reading file");
        }

         // this is an infinite loop but it's fine for now!

            // increment the number to display on each iteration of the loop
            

            // this places the text in the center of the screen
            // the coordinate (50, 50) is used for the center of the text
            

            // this displays the text
            

            // this causes the program to wait for 500ms
            

            // this removes everything that is being displayed
            

        

    }

    /*
    This method sets up the window for the speed reader.
    You should not need to change anything here!
    Please speak to the Instructor if you think any change is necessary.
     */
    private static void setup() {
        // this creates a window of 800x600 pixels
        StdDraw.setCanvasSize(800, 400);

        // this sets the scale of the x- and y-axis to be from 0 to 100
        StdDraw.setXscale(0, 100);
        StdDraw.setYscale(0, 100);

        // this enables animation so that things don't appear jittery
        StdDraw.enableDoubleBuffering();

        // this sets the drawing color to black
        StdDraw.setPenColor(StdDraw.BLACK);

        // this sets the text font to be fixed-width
        StdDraw.setFont(new java.awt.Font("COURIER", java.awt.Font.BOLD, 100));
    }


    public static void main(String[] args) {
        // modify this code as needed in order to pass arguments to the show() method
        
        if(args.length != 2){
            System.out.println("Please specify the file name and wpm");
            return;
        }
        
        int rate;
        
        try{
            rate = Integer.parseInt(args[1]);
        } catch (NumberFormatException error){
            System.out.println("Please specify a positive wpm");
            return;
        }

        if (rate <= 0){
            System.out.println("Please specify a positive wpm");
            return;
        }

        show(args[0], rate);
    }
    
}
