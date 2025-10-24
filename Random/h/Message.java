package h;

public class Message {

    private int userLevel;
    //private String userName;
    private String content;

    public Message(Hazemian h) {
        userLevel = h.getLevel();
        //userName = h.getName();
        content = generateMessage();
    }

    public String getContent() {
        return content;
    }

    private String generateMessage() {

        if (userLevel <= 2) {
            int random = (int) (Math.random() * 2);
            if (random == 1) {
                return Texts.getText(0);
            } else {
                return Texts.getText(1);
            }
        }

        else if (userLevel <= 5) {
            int random = (int) (Math.random() * 4);
            if (random == 1) {
                return Texts.getText(0);
            } else {
                return Texts.getText(1);
            }
        }

        else if (userLevel <= 10) {
            int random = (int) (Math.random() * 9);
            if (random == 1) {
                return Texts.getText(0);
            } else {
                return Texts.getText(1);
            }
        }

        else if (userLevel <= 25) {
            int random = (int) (Math.random() * 49);
            if (random == 1) {
                return Texts.getText(0);
            } else if (random <= 20) {
                return Texts.getText(1);
            } else {
                return Texts.getText(2);
            }
        }

        else if (userLevel <= 50) {
            int random = (int) (Math.random() * 1);
            if (random == 1) {
                return Texts.getText(2);
            } else {
                return Texts.getText(3);
            }
        }

        else if (userLevel <= 75) {
            int random = (int) (Math.random() * 3);
            if (random == 1) {
                return Texts.getText(2);
            } else {
                return Texts.getText(3);
            }
        }

        else {
            return Texts.getText(3);
        }
    }
}
