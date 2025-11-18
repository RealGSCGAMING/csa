import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// GUI Input Form for your class
// Fork this repl
// Copy your class into MyClass.java
// Add JLabels and JTextfields for your class attributes
// Uncomment code in actionPerformed() to write to a file and change the constructor call for your class.

public class GUIExample {
  public static void main(String[] args) {
    // A JFrame is a window where we can design our UI
    JFrame frame = new JFrame("Input Form");
    frame.setSize(500, 500);
    // in FlowLayout, objects will be added in order
    frame.setLayout(new FlowLayout(FlowLayout.LEFT));

    // create Labels, TextFields, Buttons
    JLabel firstNameLabel = new JLabel("Enter first name");
    JTextField firstNameField = new JTextField(10); // size = 10
    JLabel lastNameLabel = new JLabel("Enter last name");
    JTextField lastNameField = new JTextField(10);
    
    JButton enterButton = new JButton("Enter");
    JLabel outputLabel = new JLabel();

    // add components to JFrame in this order
    frame.add(firstNameLabel);
    frame.add(firstNameField);
    frame.add(lastNameLabel);
    frame.add(lastNameField);
    frame.add(enterButton);
    frame.add(outputLabel);
    
    // add event listener for button click
    enterButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) 
    {
      // Create an object of your class with the form inputs
      MyClass c = new MyClass(firstNameField.getText(),
   lastNameField.getText() );
      // print out in label using c.toString()
      outputLabel.setText("You entered "
                          + c);
      // Uncomment to write to the file output.txt
      /*
       try {
      FileWriter file = new FileWriter("output.txt", true); // true appends
      file.write(c  + "\n" );
      file.close();
     
    } catch (IOException ex) {
      System.out.println("An I/O error occurred.");
      ex.printStackTrace();
    }
       */
      
    }}); // end of actionlistener
    
    // make the frame visible
    frame.setVisible(true);
  }
}

// Copy in your own class here and rename the file
class MyClass
{
  private String firstname;
  private String lastname;

  public MyClass()
  {
    firstname = "";
    lastname = "";
  }

  public MyClass(String f, String l)
  {
    firstname = f;
    lastname = l;
  }

  public String getFirstname()
  {
    return firstname;
  }
  public String getLastname()
  {
    return lastname;
  }
  public String toString()
  {
    return "Firstname: " + firstname +
      " \nLastname: " + lastname;
  }
    
}