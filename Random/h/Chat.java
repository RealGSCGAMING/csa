package h;

import java.util.ArrayList;

public class Chat {

    ArrayList<Hazemian> users = new ArrayList<Hazemian>();
    int lastIndex = -1;

    public Chat(int number) {
        setupChat(number);
    }

    public Chat() {
        setupChat(10);
    }

    private void setupChat(int number) {
        for (int i = 0; i < number; i++) {
            Hazemian h = new Hazemian();
            users.add(h);
        }
    }

    public void simulate() {

        int sender = -1;

        while (sender == lastIndex || sender == -1) {
            sender = (int) (Math.random() * users.size());
        }

        lastIndex = sender;

        users.get(sender).sendMessage();

    }

    public void addHazemian(Hazemian h) {
        users.add(h);
    }
}
