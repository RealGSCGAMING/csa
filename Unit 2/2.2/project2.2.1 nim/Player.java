public class Player {
    private String name;
    private int score;
    private boolean bot;

    public Player() {
        this.name = "";
        this.score = 0;
        this.bot = false;
    }

    public void setName(String name) {
        this.name = name == null ? "" : name.trim();
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void incrementScore() {
        this.score++;
    }

    public void setType(boolean isBot) {
        this.bot = isBot;
    }

    public boolean isBot() {
        return bot;
    }
}
