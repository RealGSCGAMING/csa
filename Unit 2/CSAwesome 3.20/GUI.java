import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class GUI {

  private static JFrame frame = new JFrame("Movie Release Tracker");
  private static JPanel inputPanel = new JPanel();
  private static JPanel listPanel = new JPanel();
  private static JPanel infoPanel = new JPanel();

  public static void main(String[] args) {

    // this has been moved to Runner.java
    Runner.main(args);

  }

  // display the input form page
  public static void inputForm() {
    frame.add(inputPanel);
  }

  // display the movie list page
  public static void movieList() {

    for (int i = 0; i < Runner.movies.size(); i++) {
      JButton movieButton = new JButton();
      movieButton.setFont(new Font("Arial", Font.BOLD, 16));
      movieButton.setBackground(new Color(0, 153, 76));
      movieButton.setForeground(Color.WHITE);
      movieButton.setPreferredSize(new Dimension(200, 50));
      movieButton.setText(Runner.movies.get(i).getTitle());

      int movieIndex = i;

      movieButton.addActionListener(e -> {
        info(Runner.movies.get(movieIndex));
      });

      listPanel.add(movieButton);
    }

    frame.add(listPanel);
    // inputForm();
  }

  // display the movie info page
  public static void info(Movie m) {
    frame.remove(listPanel);
    fillInfo(m);
    frame.add(infoPanel);
  }

  // populates the info page with the movie's information
  private static void fillInfo(Movie m) {
    infoPanel.removeAll();

    JLabel titleLabel = new JLabel("Title: " + m.getTitle());
    titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
    titleLabel.setForeground(new Color(0, 102, 204));

    JLabel directorLabel = new JLabel("Director: " + m.getDirector());
    JLabel releaseDateLabel = new JLabel("Release Date: " + m.getReleaseDate());
    JLabel ratingLabel = new JLabel("Rating: " + m.getRating());
    JLabel incomeLabel = new JLabel("Income: " + m.getIncome());

    JButton editButton = new JButton("Edit");
    JButton backButton = new JButton("Back");

    infoPanel.add(titleLabel);
    infoPanel.add(directorLabel);
    infoPanel.add(releaseDateLabel);
    infoPanel.add(ratingLabel);
    infoPanel.add(incomeLabel);
    infoPanel.add(editButton);
    infoPanel.add(backButton);

    editButton.addActionListener(e -> {
      inputForm();
    });

    backButton.addActionListener(e -> {
      movieList();
    });
  }

  // create a movie object using string inputs (from inputForm)
  private static Movie createMovie(String title, String director, String release, String rating, String income) {

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

  // setup pages and GUI components
  public static void setup() {

    frame.setLayout(new BoxLayout(frame, BoxLayout.Y_AXIS));

    { // input panel
      inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
      frame.setSize(400, 450);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      // in FlowLayout, objects will be added in order
      frame.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 15));
      frame.getContentPane().setBackground(new Color(255, 255, 255));
      inputPanel.setBackground(new Color(255, 255, 255));

      // create Labels, TextFields, Buttons

      // Title
      JLabel titLabel = new JLabel("Configure Movie");
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

      JButton enterButton = new JButton("Save");
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
          Movie movie = createMovie(nameField.getText().trim(), directorField.getText().trim(),
              releaseField.getText().trim(), ratingField.getText().trim(), incomeField.getText().trim());
          System.out.println(movie);
          Runner.addMovieObject(movie);
          outputTextArea.setText("\"" + movie.getTitle() + "\" has been added.");
        } catch (Exception ee) {
          System.out.println("An error occured.\n" + ee.getMessage());
          outputTextArea
              .setText("An error occured. Make sure you fill in all the fields! Error info: " + ee.getMessage());
        }

      });
    }

    { // movie list
      listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
      listPanel.setBackground(new Color(255, 255, 255));

      JLabel titLabel = new JLabel("Movie Tracker");
      titLabel.setFont(new Font("Arial", Font.BOLD, 24));
      titLabel.setForeground(new Color(0, 102, 204));
      listPanel.add(titLabel);
    }

    // info page
    {
      infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));

      JLabel errorLabel = new JLabel("If you're seeing this, something went wrong. Oops!");
      infoPanel.add(errorLabel);
    }

    //

    // make the frame visible
    frame.setVisible(true);
  }
}