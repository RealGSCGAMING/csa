import java.util.ArrayList;

public class HorseFRQ {

    public static void main(String[] args) {
        ArrayList<Horse> horses = new ArrayList<Horse>();

        horses.add(new Horse("Trigger"));
        horses.add(null);
        horses.add(new Horse("Silver"));
        horses.add(new Horse("Lady"));
        horses.add(null);
        horses.add(new Horse("Patches"));
        horses.add(new Horse("Duke"));

        HorseBarn h = new HorseBarn(horses);

        System.out.println(h);

        System.out.println(h.findHorseSpace("Trigger"));
        System.out.println(h.findHorseSpace("Aha"));

        h.consolidate();
        System.out.println(h);
    }
}

class HorseBarn {

    private ArrayList<Horse> spaces;

    public HorseBarn(ArrayList<Horse> init) {
        spaces = init;
    }

    public int findHorseSpace(String name) {
        for (int i = 0; i < spaces.size(); i++) {
            Horse h = spaces.get(i);
            if (h != null && h.getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public void consolidate() {
        int i = 0;
        while (i < spaces.size()) {
            if (spaces.get(i) == null) {
                spaces.remove(i);
            } else {
                i++;
            }
        }
    }

    public String toString() {
        return spaces.toString();
    }
}

class Horse {
    String name;

    public Horse(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }
}