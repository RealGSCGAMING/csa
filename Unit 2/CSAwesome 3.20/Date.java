
// this class has been replaced with LocalDate

public class Date {

    // instance variables
    private int month;
    private int day;
    private int year;

    // constructors
    public Date() {
        generate();
    }

    public Date(int m, int d, int y) {
        month = m;
        day = d;
        year = y;
    }

    // functional methods

    // generates a random date
    private void generate() {
        month = (int) (Math.random() * 11) + 1;
        day = (int) (Math.random() * 29) + 1;
        year = (int) (Math.random() * 200) + 1900;
    }

    // returns formatted date
    public String toString() {
        return month + "/" + day + "/" + year;
    }

    // get methods
    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getYear() {
        return year;
    }

    // set methods
    public void setMonth(int m) {
        month = m;
    }

    public void setDay(int d) {
        day = d;
    }

    public void setYear(int y) {
        year = y;
    }

}
