import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables  
  JPanel mainPanel;
  
  JLabel firstLabel;
  JLabel secondLabel;

  JTextField fahrenheitDisplay;
  JTextField celsiusDisplay;

  JButton fToCButton;
  JButton cToFButton;


  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Title");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);
 
    //initialize the main JPanel
    mainPanel = new JPanel();

    //disable any layout helpers
    mainPanel.setLayout(null);

    //create the labels
    firstLabel = new JLabel("Degrees Fahrenheit");
    secondLabel = new JLabel("Degrees Celsius");

    //layout the labels by setting the coordinate and size 
    firstLabel.setBounds(30,20,150,20);
    secondLabel.setBounds(30,50,150,20);

    //initialize the input/output text fields
    fahrenheitDisplay = new JTextField();
    celsiusDisplay = new JTextField();

    //set the location and size 
    fahrenheitDisplay.setBounds(190, 20, 50, 20);
    celsiusDisplay.setBounds(190, 50, 50, 20);

    //initialize the buttons
    fToCButton = new JButton("F -> C");
    cToFButton = new JButton("C -> F");

    //set the size and location of the buttons
    fToCButton.setBounds(250, 20, 100, 20);
    cToFButton.setBounds(250, 50, 100, 20);

    //add an action listener to the buttons
    fToCButton.addActionListener(this);
    cToFButton.addActionListener(this);

    //set the action command on the buttons
    fToCButton.setActionCommand("fToC");
    cToFButton.setActionCommand("cToF");

    //add the buttons to the panel
    mainPanel.add(fToCButton);
    mainPanel.add(cToFButton);

    //add the text fields to the panel
    mainPanel.add(fahrenheitDisplay);
    mainPanel.add(celsiusDisplay);

    //add the labels to the main main panel 
    mainPanel.add(firstLabel);
    mainPanel.add(secondLabel);

    //add the panel to the window
    frame.add(mainPanel);

  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();

    if(command.equals("fToC")){

      //get the number from textfield 1 and change it into a double
      String firstText = fahrenheitDisplay.getText();
      double fahrenheit = Double.parseDouble(firstText);

      //formula to change fahrenheit into celsius
      double celsius = (fahrenheit - 32) * 5/9;

      celsiusDisplay.setText(" " + celsius);

    }else if(command.equals("cToF")){
      
      //get the number from textfield 2 and change it into a double
      String secondText = celsiusDisplay.getText();
      double degreesC = Double.parseDouble(secondText);

      //formula to change celsius into fahrenheit
      double degreesF = degreesC * 9/5 + 32;

      fahrenheitDisplay.setText(" " + degreesF);

    }

  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
