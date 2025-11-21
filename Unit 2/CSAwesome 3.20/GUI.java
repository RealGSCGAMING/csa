import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class GUI {

  // frame and pages
  private static JFrame frame = new JFrame("Movie Release Tracker");
  private static JPanel inputPanel = new JPanel();
  private static JPanel listPanel = new JPanel();
  private static JPanel infoPanel = new JPanel();

  // global variables for the input form
  private static boolean formEdit = false;
  private static int editIndex;

  public static void main(String[] args) {

    // this has been moved to Runner.java
    Runner.main(args);

  }

  // display the input form page to add a new movie
  public static void inputForm() {
    clear();
    frame.add(inputPanel);
    formEdit = false;
    refresh();
  }

  // display the input form page to edit an existing movie
  public static void inputForm(int i) {
    clear();
    frame.add(inputPanel);
    editIndex = i;
    formEdit = true;
    refresh();
  }

  // display the movie list page
  public static void movieList() {
    clear();
    frame.add(listPanel);
    refresh();
  }

  // display the movie info page
  public static void info(int i) {
    clear();
    fillInfo(i);
    frame.add(infoPanel);
    refresh();
  }

  // removes all elements from the GUI
  private static void clear() {
    frame.remove(listPanel);
    frame.remove(infoPanel);
    frame.remove(inputPanel);
  }

  // updates the GUI (to be used after changing components)
  private static void refresh() {
    frame.setVisible(true);
    frame.repaint();
    frame.revalidate();
  }

  // populate the movie list page
  /*public static void configMovieListTemp() {

    listPanel.removeAll();
    listPanel.repaint();
    listPanel.revalidate();

    
    JLabel titLabel = new JLabel("Movie Tracker");
    titLabel.setFont(new Font("Arial", Font.BOLD, 24));
    titLabel.setForeground(new Color(0, 102, 204));
    listPanel.add(titLabel);

    JPanel dataPanel = new JPanel(new GridLayout(Runner.movies.size() + 1, 6, 5, 5));
    dataPanel.setBackground(new Color(240, 240, 240));

    
    
    for (int i = 0; i < Runner.movies.size(); i++) {
      JButton movieButton = new JButton();
      movieButton.setFont(new Font("Arial", Font.BOLD, 16));
      movieButton.setBackground(new Color(0, 153, 76));
      movieButton.setForeground(Color.WHITE);
      movieButton.setPreferredSize(new Dimension(200, 50));
      movieButton.setText(Runner.movies.get(i).getTitle());

      int movieIndex = i;

      movieButton.addActionListener(e -> {
        info(movieIndex); //info(Runner.movies.get(movieIndex));
      });

      listPanel.add(movieButton);
    }

    listPanel.repaint();
    listPanel.revalidate();
  }*/

  // populate the info page
  private static void fillInfo(int i) {

    Movie m = Runner.movies.get(i);

    infoPanel.removeAll();

    JLabel titleLabel = new JLabel("Title: " + m.getTitle());
    titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
    titleLabel.setForeground(new Color(0, 102, 204));

    JLabel directorLabel = new JLabel("Director: " + m.getDirector());
    JLabel releaseDateLabel = new JLabel("Release Date: " + m.getReleaseDate());
    JLabel ratingLabel = new JLabel("Rating: " + m.getRating() + "%");
    JLabel incomeLabel = new JLabel("Income: $" + m.getIncome() + " million");

    JButton editButton = new JButton("Edit");
    JButton backButton = new JButton("Back");
    JButton deleteButton = new JButton("DELETE");
    deleteButton.setBackground(new Color(255, 0, 0));

    infoPanel.add(titleLabel);
    infoPanel.add(directorLabel);
    infoPanel.add(releaseDateLabel);
    infoPanel.add(ratingLabel);
    infoPanel.add(incomeLabel);
    infoPanel.add(editButton);
    infoPanel.add(backButton);
    infoPanel.add(deleteButton);

    editButton.addActionListener(e -> {
      inputForm(i);
    });

    backButton.addActionListener(e -> {
      movieList();
    });

    deleteButton.addActionListener(e -> {
      Runner.movies.remove(i);
      configMovieList();
      movieList();
    });
  }

  // generate a movie object
  private static Movie createMovie(String title, String director, String release, String rating, String income) {

    //System.out.println(title);
    //System.out.println(director);

    int index1 = release.indexOf("/");
    int index2 = release.indexOf("/", index1 + 1);

    int month = Integer.parseInt(release.substring(0, index1));
    //System.out.println(month);
    int day = Integer.parseInt(release.substring(index1 + 1, index2));
    //System.out.println(day);
    int year = Integer.parseInt(release.substring(index2 + 1));
    //System.out.println(year);
    LocalDate releaseDate = LocalDate.of(year, month, day);

    int ratingNum = rating.equals("") ? 0 : Integer.parseInt(rating);
    System.out.println(rating);

    double incomeNum = income.equals("") ? 0.0 : Double.parseDouble(income);
    //System.out.println(income);

    Movie movie = new Movie(title, releaseDate, director, ratingNum, incomeNum);

    return movie;
  }

  // initial setup for pages
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

      JButton exitButton = new JButton("Back");
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
      inputPanel.add(exitButton);

      // add event listener for button click
      enterButton.addActionListener(e -> {

        outputLabel.setText("Loading...");

        try {
          Movie movie = createMovie(nameField.getText().trim(), directorField.getText().trim(),
              releaseField.getText().trim(), ratingField.getText().trim(), incomeField.getText().trim());
          //System.out.println(movie);
          if (formEdit) {
            Runner.editMovieObject(editIndex, movie);
            outputTextArea.setText("\"" + movie.getTitle() + "\" has been edited.");
            //System.out.println(Runner.movies);
          }
          else {
            Runner.addMovieObject(movie);
            outputTextArea.setText("\"" + movie.getTitle() + "\" has been added.");
          }
          
        } catch (Exception ee) {
          //System.out.println("An error occured.\n" + ee.getMessage());
          outputTextArea
              .setText("An error occured. Make sure you fill in all the fields! Error info: " + ee.getMessage());
        }

      });

      exitButton.addActionListener(e -> {
        configMovieList();
        movieList();
      });
    }

    { // movie list
      listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
      listPanel.setBackground(new Color(255, 255, 255));
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

  // populates the movie list page
  public static void configMovieList() {

    listPanel.removeAll();
    listPanel.repaint();
    listPanel.revalidate();
    /*listPanel.setLayout(new BorderLayout());

    JPanel dataPanel = new JPanel(new GridLayout(Runner.movies.size() + 1, 6, 5, 5)); 
    dataPanel.setBackground(new Color(240, 240, 240));

    JPanel headerJPanel = new JPanel();
    headerJPanel.setBackground(new Color(255, 255, 255));
    JLabel titLabel = new JLabel("Movie Tracker");
    titLabel.setFont(new Font("Arial", Font.BOLD, 24));
    titLabel.setForeground(new Color(0, 102, 204));
    headerJPanel.add(titLabel);
    listPanel.add(titLabel);

    String[] headers = {"Title", "Release Date", "Director", "Income", "Score", ""};
    for(String header : headers ) {
      JLabel label = new JLabel(header, SwingConstants.CENTER);
      label.setFont(new Font("Arial", Font.BOLD, 14));
      dataPanel.add(label);
    }*/

    JLabel titLabel = new JLabel("Movie Tracker");
    titLabel.setFont(new Font("Arial", Font.BOLD, 24));
    titLabel.setForeground(new Color(0, 102, 204));
    listPanel.add(titLabel);

    for (int i = 0; i < Runner.movies.size(); i++) {
      JButton movieButton = new JButton();
      movieButton.setFont(new Font("Arial", Font.BOLD, 16));
      movieButton.setBackground(new Color(0, 153, 76));
      movieButton.setForeground(Color.WHITE);
      movieButton.setPreferredSize(new Dimension(200, 50));
      movieButton.setText(Runner.movies.get(i).getTitle());

      int movieIndex = i;

      movieButton.addActionListener(e -> {
        info(movieIndex); //info(Runner.movies.get(movieIndex));
      });

      listPanel.add(movieButton);
    }

    JButton addButton = new JButton("Add Movie");
    addButton.setBackground(new Color(100, 100, 255));
    addButton.setForeground(new Color(255, 255, 255));
    listPanel.add(addButton);

    addButton.addActionListener(e -> {
      inputForm();
    });

    listPanel.repaint();
    listPanel.revalidate();
  }
}