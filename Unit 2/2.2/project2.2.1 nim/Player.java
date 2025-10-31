public class Player {
    private String name;
    private int score;
    private boolean bot;

    // initialize variables
    public Player() {
        this.name = "";
        this.score = 0;
        this.bot = false;
    }

    // sets player name
    public void setName(String name) {
        this.name = name == null ? "" : name.trim();
    }

    // gets player name
    public String getName() {
        return name;
    }

    // gets player score
    public int getScore() {
        return score;
    }

    public void incrementScore() {
        this.score++;
    }

    // increases player score
    public void setType(boolean isBot) {
        this.bot = isBot;
    }

    // set player type (bot/human)
    public boolean isBot() {
        return bot;
    }
}
