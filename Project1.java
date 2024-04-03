import javax.swing.*;
import java.awt.*;
import java.util.StringTokenizer;

public class Project1 {
    public static void main(String args[]){
        TextFileInput inFile = new TextFileInput("P1input.txt");//Allows the program to process the file using TexFileInput
        String[] solutions = transfer(inFile);//Places the text from the text file into a string
        PuzzleGUI gui = new PuzzleGUI();//Makes a variable for the GUI so that it pops up when it is used in the program
        print(gui,solutions);//Passes the GUI and the list of solutions

    }
    public static String[] transfer (TextFileInput inputFile) {
        String words[] = new String[100];//String to put in values from the text file
        int i = 0;
        String line = inputFile.readLine();//Reads the first line from our text file into a variable
        while (line != null) {//Reads every line of our text file until the entire text file has been read
        StringTokenizer myTokens = new StringTokenizer(line, ","); // Uses a tokenizer to break apart any texts with commas(,)
            while(myTokens.hasMoreTokens()) {//Loops to find every word
                words[i] = myTokens.nextToken();//Puts the word into the array
                i++;
            }
            line = inputFile.readLine();//skips to the next line
        }
        inputFile.close();//Closes the text file
        return words;//Returns the array of each word that was inside of the text file
    }
    public static void print(PuzzleGUI gui, String solutions[]){
        int score = 0;
        String Letters = solutions[0];//String for our letters that the user will use 
        Container myContentPane = gui.getContentPane();//Creates a container inside of the GUI 
        TextArea myTextArea = new TextArea();
        TextArea answers = new TextArea();
        myContentPane.add(myTextArea);//Puts the text area into the content pane
        myContentPane.add(answers);//Puts the text area into the content pane
        myTextArea.setEditable(false);//Makes it so that the user cant edit the GUI
        myTextArea.append(Letters);
        while(true){//Keeps looping until the loop is broken
            String userInput = JOptionPane.showInputDialog("Spell a word with the letters on the left. Type 'STOP' to end");
            //Puts up a window that asks the user for input and puts it into a variable
            if(userInput.equalsIgnoreCase("stop")){//If the user types in "stop" the loop breaks and stops asking the user
                break;
            }
            boolean y = false;//Variable to keep the users input to see if it is on the solutions list after it passes all of the tests
            for(int j = 0; j < userInput.length();j++){//Loop to check the characters of the users input
                if(userInput.length() < 5){//Puts up a message that the users input is too short and breaks the loop
                    JOptionPane.showMessageDialog(null,"The word has to  be atleast 5 letters long");
                    y = true;
                    break;
                }
                if(!Letters.contains(String.valueOf(userInput.charAt(j)))){//Puts up a message if the user uses a letter that they arent supposed to and breaks the loop
                    JOptionPane.showMessageDialog(null,"Invalid input! You must use only the letters given on the left");
                    y = true;
                    break;
                }
            }
            for(int i = 0; i <= 23;i++){//loop to check if the users input is in the solutions list
                if(userInput.equalsIgnoreCase(solutions[i])){//Puts the users input on the answers text area if it is on the solutions list and increases the score
                    answers.append(solutions[i]);
                    answers.append("\n");
                    score++;
                    y = true;
                }
            }  

            if(y == false){//Puts a message saying that the word is not on the solutions list even after passing all of the tests
                JOptionPane.showMessageDialog(null, "That word is not in the solutions list. Try again!");
            }

        }
        answers.append("Score: " + score);//Puts up the score once the user input is "stop"
    }
}