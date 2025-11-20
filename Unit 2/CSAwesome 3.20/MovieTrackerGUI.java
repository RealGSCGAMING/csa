import javax.swing.*;
import java.awt.*;
//import java.awt.event.*;
//import java.io.FileWriter;
//import java.io.IOException;
import java.time.LocalDate;

// GUI Input Form for your class
// Fork this repl
// Copy your class into MyClass.java
// Add JLabels and JTextfields for your class attributes
// Uncomment code in actionPerformed() to write to a file and change the constructor call for your class.

public class MovieTrackerGUI {

  private static JFrame frame = new JFrame("Movie Release Tracker");
  private static JPanel inputPanel = new JPanel();

  
  public static void main(String[] args) {
    setup();
    inputForm();
  }

  public static void inputForm() {
    frame.add(inputPanel);
  }

  private static Movie addMovie(String title, String director, String release, String rating, String income) {

    System.out.println(title);
      System.out.println(director);

      int index1 = release.indexOf("/");
      int index2 = release.indexOf("/", index1 + 1);

      int month = Integer.parseInt(release.substring(0, index1));
      System.out.println(month);
      int day = Integer.parseInt(release.substring(index1 + 1, index2));
      System.out.println(day);
      int year = Integer.parseInt(release.substring(index2 + 1));
      System.out.println(year);
      LocalDate releaseDate = LocalDate.of(year, month, day);

      int ratingNum = rating.equals("") ? 0 : Integer.parseInt(rating);
      System.out.println(rating);

      double incomeNum = income.equals("") ? 0.0 : Double.parseDouble(income);
      System.out.println(income);

      Movie movie = new Movie(title, releaseDate, director, ratingNum, incomeNum);

      return movie;
  }

  public static void setup() {

    // A JFrame is a window where we can design our UI
    inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
    frame.setSize(400, 450);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // in FlowLayout, objects will be added in order
    frame.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 15));
    frame.getContentPane().setBackground(new Color(255, 255, 255));
    inputPanel.setBackground(new Color(255, 255, 255));
    

    // create Labels, TextFields, Buttons
    
    // Title
    JLabel titLabel = new JLabel("Add a New Movie");
    titLabel.setFont(new Font("Arial", Font.BOLD, 24));
    titLabel.setForeground(new Color(0, 102, 204));

    // Input fields
    JLabel nameLabel = new JLabel("Title: ");
    JTextField nameField = new JTextField(25); 

    JLabel directorLabel = new JLabel("Director: ");
    JTextField directorField = new JTextField(25);
    
    JLabel releaseJLabel = new JLabel("Release Date (mm/dd/yy): ");
    JTextField releaseField = new JTextField(5);

    JLabel ratingLabel = new JLabel("Rating % (0-100): ");
    JTextField ratingField = new JTextField(10);

    JLabel incomeLabel = new JLabel("Income (millions): ");
    JTextField incomeField = new JTextField(12);

    JButton enterButton = new JButton("ADD MOVIE");
    enterButton.setFont(new Font("Arial", Font.BOLD, 16));
    enterButton.setBackground(new Color(0, 153, 76));
    enterButton.setForeground(Color.WHITE);
    enterButton.setPreferredSize(new Dimension(200, 50));

    JLabel outputLabel = new JLabel();
    outputLabel.setFont(new Font("Arial", Font.PLAIN, 14));
    outputLabel.setBackground(Color.DARK_GRAY);
    outputLabel.setVerticalAlignment(SwingConstants.TOP);
    outputLabel.setPreferredSize(new Dimension(200, 50));
    outputLabel.setText("Enter movie info.");

    JTextArea outputTextArea = new JTextArea();
    outputTextArea.setFont(new Font("Arial", Font.PLAIN, 14));
    outputTextArea.setBackground(Color.LIGHT_GRAY);
    outputTextArea.setPreferredSize(new Dimension(200, 50));
    outputTextArea.setLineWrap(true);
    outputTextArea.setWrapStyleWord(true);
    outputTextArea.setEditable(false);
    outputTextArea.setText("Enter movie info.");

    JScrollPane scroll = new JScrollPane(outputTextArea);



    // add components to panel 
    inputPanel.add(titLabel);
    inputPanel.add(nameLabel);
    inputPanel.add(nameField);
    inputPanel.add(directorLabel);
    inputPanel.add(directorField);
    inputPanel.add(releaseJLabel);
    inputPanel.add(releaseField);
    inputPanel.add(ratingLabel);
    inputPanel.add(ratingField);
    inputPanel.add(incomeLabel);
    inputPanel.add(incomeField);
    inputPanel.add(enterButton);
    inputPanel.add(scroll);

    
    // add event listener for button click
    enterButton.addActionListener(e -> {

      outputLabel.setText("Loading...");

      try {
        Movie movie = addMovie(nameField.getText().trim(), directorField.getText().trim(), releaseField.getText().trim(), ratingField.getText().trim(), incomeField.getText().trim());
        System.out.println(movie);
        outputTextArea.setText("\"" + movie.getTitle() + "\" has been added.");
      } catch (Exception ee) {
        System.out.println("An error occured.\n" + ee.getMessage());
        outputTextArea.setText("An error occured. Make sure you fill in all the fields! Error info: " + ee.getMessage());
      }
      
      
    });
    
    // make the frame visible
    frame.setVisible(true);
  }
}