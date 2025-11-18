import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;

// GUI Input Form for your class
// Fork this repl
// Copy your class into MyClass.java
// Add JLabels and JTextfields for your class attributes
// Uncomment code in actionPerformed() to write to a file and change the constructor call for your class.

public class MovieTrackerGUI {
  public static void main(String[] args) {
    // A JFrame is a window where we can design our UI
    JFrame frame = new JFrame("Movie Release Tracker");
    frame.setSize(960, 540); // 16 : 9 ratio
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // in FlowLayout, objects will be added in order
    frame.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 15));
    frame.getContentPane(). setBackground(new Color(245, 245, 245));
    

    // create Labels, TextFields, Buttons
    
    // Title
    JLabel titLabel = new JLabel("Add a New Movie");
    titLabel.setFont(new Font("Arial", Font.BOLD, 24));
    titLabel.setForeground(new Color(0, 102, 204));

    // Input fields
    JLabel nameLabel = new JLabel("Movie Title: ");
    JTextField nameField = new JTextField(25); 

    JLabel directorLabel = new JLabel("Director: ");
    JTextField directorField = new JTextField(25); 

    JLabel monthJLabel = new JLabel("Release Month (1-12): ")
    JTextField monthField = new JTextField(5);
    JLabel dayLabel = new JLabel("Day (1-31): ");
    JTextField dayField = new JTextField(5);
    JLabel yearJLabel = new JLabel("Year: ");
    JTextField yearField = new JTextField(8);

    JLabel ratingLabel = new JLabel("Box Office Income (millions): ");
    JTextField incomeField = new JTextField(12);

    JCheckBox releasedBox = new JCheckBox("Movie is already released");
    releasedBox.setFont(new Font("Arial", Font.PLAIN, 14));


    JButton enterButton = new JButton("ADD MOVIE");
    enterButton.setFont(new Font("Arial", Font.BOLD, 16));
    enterButton.setBackground(new Color(0, 153, 76));
    enterButton.setForeground(Color.WHITE);
    enterButton.setPreferredSize(new Dimension(200, 50));

    JLabel outputLabel = new JLabel();
    outputLabel.setFont(new Font("Arial", Font.PLAIN, 14));
    outputLabel.setForeground(Color.DARK_GRAY);
    outputLabel.setVerticalAlignment(SwingConstants);
    outputLabel.setPreferredSize();


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