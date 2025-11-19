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

    JLabel monthJLabel = new JLabel("Release Month (1-12): ");
    JTextField monthField = new JTextField(5);
    JLabel dayLabel = new JLabel("Day (1-31): ");
    JTextField dayField = new JTextField(5);
    JLabel yearJLabel = new JLabel("Year: ");
    JTextField yearField = new JTextField(8);

    JLabel ratingLabel = new JLabel("Rating % (0-100): ");
    JTextField ratingField = new JTextField(10);

    JLabel incomeLabel = new JLabel("Income (millions): ");
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
    outputLabel.setVerticalAlignment(SwingConstants.TOP);
    outputLabel.setPreferredSize(new Dimension(200, 50));

    JTextArea outputTextArea = new JTextArea(10, 60);
    outputTextArea.setEditable(false);
    outputTextArea.setLineWrap(true);
    outputTextArea.setWrapStyleWord(true);
    JScrollPane scroll = new JScrollPane(outputLabel);



    // add components to JFrame 
    frame.add(titLabel);
    frame.add(nameLabel);
    frame.add(nameField);
    frame.add(directorLabel);
    frame.add(directorField);
    frame.add(monthJLabel);
    frame.add(monthField);
    frame.add(dayLabel);
    frame.add(dayField);
    frame.add(yearJLabel);
    frame.add(yearField);
    frame.add(ratingLabel);
    frame.add(ratingField);
    frame.add(incomeLabel);
    frame.add(incomeField);
    frame.add(releasedBox);
    frame.add(enterButton);
    frame.add(scroll);

    
    // add event listener for button click
    enterButton.addActionListener(e -> {
    try {
        String title = nameField.getText().trim();
        System.out.println(title);
        String director = directorField.getText().trim();
        System.out.println(director);
        int month = Integer.parseInt(monthField.getText().trim());
        System.out.println(month);
        int day = Integer.parseInt(dayField.getText().trim());
        System.out.println(day);
        int year = Integer.parseInt(yearField.getText().trim());
        System.out.println(year);

        LocalDate releaseDate = LocalDate.of(year, month, day);
        //Date releaseDate = new Date(month, day, year);

        int rating = ratingField.getText().isEmpty() ? 0 : Integer.parseInt(ratingField.getText().trim());
        System.out.println(rating);
        double income = incomeField.getText().isEmpty() ? 0.0 : Double.parseDouble(incomeField.getText().trim());
        System.out.println(income);
        boolean released = releasedBox.isSelected();

        Movie movie = new Movie(title, releaseDate, director, rating, income);
        //movie.released = released;

        System.out.println(movie);

        outputTextArea.append(movie.toString() + "\n\n");

    } catch (Exception ee) {
      System.out.println("An error occured.\n" + ee.getMessage());
    }}); // end of actionlistener
    
    // make the frame visible
    frame.setVisible(true);
  }
}

