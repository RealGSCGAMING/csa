package h;

public class Texts {

    static String[] begTexts = {
        "can someone donate me",
        "im poor pls donate",
        "smite is impossible for me",
        "someone send me robux",
        "Can I have some Robux",
        "Any good samaritan have a spare 25 robux?",
        "Could u dono me bro",
        "bobux pls",
        "donate me",
        "not tryna beg but can someone donate me lol"
    };

    static String[] lowTexts = {
        "what yall doing",
        "hi im new here",
        "Holy active chat",
        "attachment.gif",
        "Wwwwwww bro",
        //"does anyone know how i can raise more",
        "so close to leveling up",
        "absolute aura",
        "are any mods online?",
        "I have a question",
        //"67",
        "Guys check media"
    };

    static String[] mediumTexts = {
        "Anyone know a good game?",
        "how's it going",
        "togif.gif",
        "@Moderator ban this guy",
        "Free feenix",
        ":sob:",
        "Heyyy guys",
        "so many white roles",
        "should i sleep or stay on hazems server",
        "is there any drama"
    };

    static String[] highTexts = {
        "does anyone remember Hazemian0004",
        "Yo",
        "image.jpg",
        "Heyyyyyy",
        "First to reply gets 10 robux",
        "Ew newgens",
        "READ THE RULES",
        "scripting is so hard"
    };
    
    public static String getText(int type) {
        if (type == 0) {
            return begTexts[(int) (Math.random() * begTexts.length)];
        }
        else if (type == 1) {
            return lowTexts[(int) (Math.random() * lowTexts.length)];
        }
        else if (type == 2) {
            return mediumTexts[(int) (Math.random() * mediumTexts.length)];
        }
        else if (type == 3) {
            return highTexts[(int) (Math.random() * highTexts.length)];  
        }
        else {
            return "no";
        }
    }

}
