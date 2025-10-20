package h;

import java.util.ArrayList;

public class Chat {

    public Chat(int number) {

        ArrayList<Hazemian> users = new ArrayList<Hazemian>();

        for (int i = 0; i < number; i++) {
            Hazemian h = new Hazemian();
            users.add(h);
        }

        System.out.println((users.get(0)).getLevel());
    }
}
