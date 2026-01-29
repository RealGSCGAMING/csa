public class PlayerNames {

    static Player[] players = {new Player("Alex"), new Player("Aiden"),
        new Player("Bobbie"), new Player(""),
        new Player("Chris"), new Player("") };

    public static void main(String[] args) {
        

    isDuplicate("Bobbie");
    }

    public static boolean isDuplicate(String newName) {
        boolean duplicate = false;

        for (Player p : players) {
            if (newName.equals(p.getName())) {
                duplicate = true;
                break;
            }
        }

        return duplicate;
    }

    public static boolean checkForDups() {

        for (int i = 0; i < players.length; i++) {
            for (int j = i + 1; j < players.length; j++) {
                if (players[i].getName().equals(players[j].getName()) && !(players[i].getName().equals(""))) return true;
            }
        }
        return false;
    }
}

class Player {
    public Player(String h) {

    }
}