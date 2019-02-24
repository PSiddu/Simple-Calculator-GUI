/* Name: Siddu Palaparthi */
/* Date: February 20, 2019 */
/*This program is my version of a simple 4-function GUI calculator. For accurate calculations, I made sure that all the
 * number variables are doubles. I hope to improve on this in the future by adding more functionality than simple
 * 2 number calculations.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 

public class calculator extends JFrame implements ActionListener {
  
  //variables related to actual calculator functionality
  double n1, n2, ans;
  int nn1, nn2;
  String num1, num2;
  int cond = 1;
  
  //variables related to the button creation
  int rows = 4;
  int cols = 3;
  
  int rows2 = 5;
  int cols2 = 1;
  
  JTextField screen;
  
  //the physical creation of the numbers grid (J-Buttons)
  JButton btn1[] [] = new JButton [rows] [cols];
  JButton clear, add, minus, multiply, divide;
  
  CardLayout cardLayout = new CardLayout ();
  
  JPanel calcscreen = new JPanel();
  
  
  public calculator() {
    
    int numvariable = 9;
    
    //CREATION OF the first button array for numbers: (on a panel so that entire numpad can be treated as single entity to set bounds and screen)
    Panel numpad = new Panel (new GridLayout (rows, cols));
    for (int x = 0 ; x < rows ; x++)
    {
      int pixeladd1 = x+80;
      for (int y = 0 ; y < cols ; y++)
      {
        int pixeladd2 = y+90;
        
        btn1 [x] [y] = new JButton (""+numvariable);
        
        if (numvariable == -1) {
          btn1 [x] [y] = new JButton (".");}
        else if (numvariable == -2) {
          btn1 [x] [y] = new JButton ("=");}
        
        
        numvariable = numvariable - 1;
        btn1 [x] [y].addActionListener(this);
        
        
        btn1 [x] [y].setActionCommand ("" + (x * 10 + y));
        //btn1 [x] [y].setForeground (Color.black);
        btn1 [x] [y].setBackground (new Color(211,211,211));
        btn1 [x] [y].setBounds((35 + pixeladd1), (107 + pixeladd2), 10, 10);
        btn1[x] [y].setFont(new Font("Arial", Font.PLAIN, 36));
        numpad.add (btn1 [x] [y]);
        numpad.setBackground (new Color(211,211,211));
      }
    }
    
    //setting bounds and adding numpad to the program screen
    numpad.setBounds(25, 175, 300, 300);
    add (numpad);
    calcscreen.add(numpad);
    
    //CREATION OF all other buttons:
    
    //clearing the screen text and resetting the calculator
    clear = new JButton ("C");
    clear.setBounds(400, 200-25, 50, 50);
    clear.setBackground (new Color(211,211,211));
    clear.addActionListener(this);
    clear.setActionCommand ("clear");
    clear.setFont(new Font("Arial", Font.PLAIN, 18));
    calcscreen.add(clear);
    
    //button to perform addition
    add = new JButton ("+");
    add.setBounds(400, 260-25, 50, 50);
    add.setBackground (new Color(211,211,211));
    add.addActionListener(this);
    add.setActionCommand ("add");
    add.setFont(new Font("Arial", Font.PLAIN, 24));
    calcscreen.add(add);
    
    //button to perform subtraction
    minus = new JButton ("-");
    minus.setBounds(400, 320-25, 50, 50);
    minus.setBackground (new Color(211,211,211));
    minus.addActionListener(this);
    minus.setActionCommand ("minus");
    minus.setFont(new Font("Arial", Font.PLAIN, 24));
    calcscreen.add(minus);
    
    //button to perform multiplication
    multiply = new JButton ("×");
    multiply.setBounds(400, 380-25, 50, 50);
    multiply.setBackground (new Color(211,211,211));
    multiply.addActionListener(this);
    multiply.setActionCommand ("multiply");
    multiply.setFont(new Font("Arial", Font.PLAIN, 24));
    calcscreen.add(multiply);
    
    //button to perform division
    divide = new JButton ("÷");
    divide.setBounds(400, 440-25, 50, 50);
    divide.setBackground (new Color(211,211,211));
    divide.addActionListener(this);
    divide.setActionCommand ("divide");
    divide.setFont(new Font("Arial", Font.PLAIN, 24));
    calcscreen.add(divide);
    
    //screen where typed numbers and calculation results appear
    screen = new JTextField ();
    screen.setEditable(false);
    screen.setBackground(new Color(240,255,255));
    screen.setBounds(20, 20, 490, 100);
    screen.setFont(new Font("Arial", Font.PLAIN, 24));
    calcscreen.add(screen);
    
    /////
    //CREATING AND INITIALISING COMPONENTS:
    /////
    
    //Layout must be set as null to set bounds manually
    calcscreen.setLayout(null);
    calcscreen.setBackground(new Color (240,255,240));
    
    //Adds each of the cards to the big JPanel
    //cards.add(calcscreen);
    
    /////
    //setting window attributes
    /////
    
    //Set the size of the JFrame
    setSize(540, 530);
    
    //Puts title on top of JFrame
    setTitle("Calculator GUI");
    
    //makes it so that you can't full screen the app. (THIS IS IMPORTANT BECAUSE THE PROGRAM WILL LOOK WEIRD IF IT IS FULL-SCREENED)
    setResizable(false);
    
    //Adds the card with all of the components to the J-Frame. Multiple cards can be used when coding multiple screens.
    getContentPane().add(calcscreen);
    
    //Makes J-Frame visible
    setVisible(true);
  }
  
  //the ActionPerformed part of the program, where all of the effects of the buttons being pressed are implemented
  public void actionPerformed(ActionEvent e) {
    
    if ((e.getActionCommand ().equals ("add"))) {
      //condition variable to indicate what is happening in the program
      cond = 2;
      
      //to give the visual effect of the button being held down
      add.setBackground (new Color(139,139,131));
      
      //resetting screen for the next number
      screen.setText("");
      
      /*My calculator is very simple and therefore doesn't work with complicated input. Thus, the other buttons
       * vanish so that there are no errors (ex. cannot do 2*2*2 = 8, only two numbers at a time.)*/
      add.setVisible(false);
      minus.setVisible(false);
      multiply.setVisible(false);
      divide.setVisible(false);
    }
    
    else if ((e.getActionCommand ().equals ("minus"))) {
      cond = 3;
      minus.setBackground (new Color(139,139,131));
      screen.setText("");
      
      add.setVisible(false);
      minus.setVisible(false);
      multiply.setVisible(false);
      divide.setVisible(false);
    }
    else if ((e.getActionCommand ().equals ("multiply"))) {
      cond = 4;
      multiply.setBackground (new Color(139,139,131));
      screen.setText("");
      
      add.setVisible(false);
      minus.setVisible(false);
      multiply.setVisible(false);
      divide.setVisible(false);
    }
    else if ((e.getActionCommand ().equals ("divide"))) {
      cond = 5;
      divide.setBackground (new Color(139,139,131));
      screen.setText("");
      
      add.setVisible(false);
      minus.setVisible(false);
      multiply.setVisible(false);
      divide.setVisible(false);
    }
    
    /*ActionPerformed for "equals" button, ActionCommand is 32 because it is a part of the numpad button array, so
     * 32 happens to be the parsed string value for the equal button.*/
    else if ((e.getActionCommand ().equals ("32"))) {
      
      /*these if statements change what the equal button performs based on the cond value, which tells us
       * which operation the user wants to perform with the two inputted numbers*/
      if (cond == 2) {
        
        //setting button color back to normal
        add.setBackground (new Color(211,211,211));
        
        ans = n1 + n2;
      }
      else if (cond == 3) {
        minus.setBackground (new Color(211,211,211));
        ans = n1 - n2;
      }
      else if (cond == 4) {
        multiply.setBackground (new Color(211,211,211));
        ans = n1*n2;
      }
      else if (cond == 5) {
        divide.setBackground (new Color(211,211,211));
        ans = n1 / n2;
      }
      screen.setText(""+ans);
      cond = 1;
    }
    
    //resets the program and erases the screen, so that the next calculation can be done.
    else if ((e.getActionCommand ().equals ("clear"))) {
      screen.setText("");
      num1 = "";
      num2 = "";
      n1 = 0;
      n2 = 0;
      nn1 = 0;
      nn2 = 0;
      ans=0;
      
      //brings back the buttons taken away so that they may be used for the next calculation
      add.setVisible(true);
      minus.setVisible(true);
      multiply.setVisible(true);
      divide.setVisible(true);
    }
    else {
      
      //this part of my program is how the buttons in the numpad button array are processed together.
      int j = Integer.parseInt (e.getActionCommand ());
      int row = j / 10;
      int column = j % 10;
      
      //wordnum is the string that you want to type into the calculator screen
      String wordnum = (btn1 [row] [column].getText());
      
      //wordnum2 is the previous value of the string typed into the calculator screen before the new string was added/typed
      String wordnum2 = (screen.getText());
      
      //this line adds wordnum after wordnum2 after wordnum is typed, giving the user the effect that they are typing.
      screen.setText(wordnum2 + wordnum);
      
      //For making num1 equal to the first number typed, and anything after the operation button is pressed down equal to num2
      if (cond == 1) {
        num1 = (screen.getText());
      }
      
      else {
        num2 = (screen.getText());
        n1 = Double.parseDouble(num1);
        n2 = Double.parseDouble(num2);
      }
    }
  }
  
  /////
  //MAIN METHOD
  /////
  public static void main(String args[]) 
  {
    
    //Constructor is called and run
    new calculator(); 
  }
}
