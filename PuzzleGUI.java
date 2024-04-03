import javax.swing.*;
import java.awt.*;

public class PuzzleGUI extends JFrame {//Displays the GUI
   public PuzzleGUI(){
     setSize(600,500);//Sets the size of the GUI
     setLayout(new GridLayout(1,2));//Sets the amount of rows and columns the GUI will have
     setLocation(600,300);//Sets the location that the GUI will pop up in when the program runs
     setTitle("Find All Possible Matches");//Sets the title on top of the GUI
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Creats a button on top of the GUI that lets the user exit the tab
     setVisible(true);//Makes the GUI visible for the user to see
   }
}
