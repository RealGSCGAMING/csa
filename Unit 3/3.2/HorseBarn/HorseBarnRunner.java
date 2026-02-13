package HorseBarn;

import java.util.ArrayList;

/*
 * Activity 3.2.4
 */
public class HorseBarnRunner {
    public static void main(String[] args) {
        /* your code here */
        HorseBarn barn = new HorseBarn();
        ArrayList<Horse> barnSpaces = barn.getSpaces();

        try {
            barnSpaces.get(0);
        } catch (Exception e) {
            System.out.println("There are no horses");
            return;
        }

        for (Horse h : barnSpaces) {

            /*
             * You cannot change the size of an ArrayList while traversing it in an enhanced
             * for loop.
             * if (h.getName().equals("Patches"))
             * barnSpaces.remove(h);
             */

            System.out.println(h);
        }

        int i = 0;
        while (i < barnSpaces.size()) {
            Horse h = barnSpaces.get(i);
            if (h.getName().equals("Patches")) {
                System.out.println("Bye bye " + barnSpaces.remove(i));
            } else if (h.getName().equals("Lady")) {
                System.out.println("Bye bye " + barnSpaces.remove(i));
            } else {
                i++;
            }
        }

        // Find average weight
        int weightSum = 0;
        for (Horse h : barnSpaces) {
            if (h != null)
                weightSum += h.getWeight();
        }
        double weightAvg = (double) weightSum / barnSpaces.size();
        System.out.println("Average weight" + weightAvg);

        // Find horses above the average weight
        System.out.println("Horses above average weight:");
        for (Horse h : barnSpaces) {
            if (h != null && h.getWeight() > weightAvg) {
                System.out.println(h.getName() + ", " + h.getWeight());
            }
        }

        // Find the minimum and maximum weight
        int minWeight = barnSpaces.get(0).getWeight();
        int maxWeight = 0;
        for (Horse h : barnSpaces) {
            if (h != null) {
                if (h.getWeight() > maxWeight)
                    maxWeight = h.getWeight();
                if (h.getWeight() < minWeight)
                    minWeight = h.getWeight();
            }
        }

        System.out.println("Max weight " + maxWeight);
        System.out.println("Min weight " + minWeight);

        int j = 0;
        while (j < barnSpaces.size()) {
            Horse h = barnSpaces.get(j);
            if (h != null) {
                System.out.println(h.getName());
                if (h.getName().equals("Duke")) {
                    barnSpaces.set(j, new Horse("Princess", 1445));
                }
                if (h.getName().equals("Silver")) {
                    barnSpaces.add(j + 1, new Horse("Chief", 1505));
                }
                if (h.getName().equals("Buddy")) {
                    barnSpaces.add(j, new Horse("Gypsy", 1335));
                    j++;
                    barnSpaces.add(j, new Horse("Magic", 1425));
                    j++;
                }
                j++;
            }
        }

        System.out.println(barnSpaces);

        ArrayList<Horse> randomHorses = RandomPermutation.next(barnSpaces);
        System.out.println(randomHorses);

        for (int n = 0; n < randomHorses.size() - 1; n += 2) {
            System.out.println(randomHorses.get(n) + " and " + randomHorses.get(n + 1));
        }
        if (randomHorses.size() % 2 != 0)
            System.out.println(randomHorses.get(randomHorses.size() - 1) + " has no partner");

    }
}