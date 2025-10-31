package h;

public class Hazemian {

    int level;
    String name;

    private static int calculateLevel() {
        if ((int) (Math.random() * 3) == 1) {
            return (int) (Math.random() * 100) + 10;
        } else {
            return (int) (Math.random() * 10);
        }
    }

    public void sendMessage() {
        Message m = new Message(this);

        System.out.println(name + " (Level " + level + ")\n" + m.getContent() + "\n");
    }

    // primitive information
    public int getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    // constructors
    public Hazemian(int level, String name) {
        this.level = level;
        this.name = name;

        //System.out.println(name);
        //System.out.println(level);
    }

    public Hazemian(int level) {
        this(level, "Hazemian" + (int) (Math.random() * 9999));
    }

    public Hazemian(String name) {
        this(calculateLevel(), name);
    }

    public Hazemian() {
        this(calculateLevel(), "Hazemian" + (int) (Math.random() * 9999));
    }
}
