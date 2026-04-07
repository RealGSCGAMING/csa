import java.util.Scanner;

public class BSideLabel {

    public static final int STICKER = 330;
    public static final int LICENSED = 385;
    public static final int SHIRT = 3850;
    public static final int SHIPPING = 3000;

    public static final boolean COUPON = true;
    public static final boolean TENSO = true;
    public static final boolean TARIFF = true;

    public static final double CONVERSION = 159.77;

    public static int presetStickers = -1;
    public static int presetShirts = -1;

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        clearConsole();

        System.out.println("Welcome to the B SIDE LABEL price calculator");

        while (true) {
            System.out.println();

            // INPUTS

            int amountStickers, amountShirts, amountLicensedStickers;

            // All items
            System.out.println("How many items are in your cart");
            int totalItems = getIntInput();
            if (totalItems <= 0) {
                System.out.println("You can't buy nothing!");
                continue;
            }

            // Shirts
            if (presetShirts == -1) {
                System.out.println("How many of them are shirts");
                amountShirts = getIntInput(totalItems);
            } else {
                amountShirts = presetShirts;
            }

            // Licensed stickers
            System.out.println("How many of them are licensed stickers");
            amountLicensedStickers = getIntInput(totalItems - amountShirts);

            // Other stickers
            amountStickers = totalItems - (amountShirts + amountLicensedStickers);

            // PRICE CALCULATION

            // Stickers
            int stickerCost = 0;
            if (amountStickers > 0) {

                // Check if using the birthday coupon
                if (COUPON && amountStickers >= 4) {

                    int paidStickers = 0;
                    int freeStickers = 0;
                    int amountTemp = amountStickers + amountLicensedStickers;

                    // Every 4th sticker is free, up to 5 times
                    while (freeStickers < 5 && amountTemp >= 4) {
                        amountTemp -= 4;
                        freeStickers += 1;
                        paidStickers += 3;
                    }

                    // Licensed stickers are totaled seperately
                    paidStickers += amountTemp - amountLicensedStickers;

                    System.out.println("\nBirthday coupon:");
                    System.out.println("FREE stickers: " + freeStickers);
                    System.out.println("Paid stickers: " + paidStickers);
                    System.out.println("Licensed stickers: " + amountLicensedStickers);

                    stickerCost = paidStickers * STICKER;

                } else {
                    stickerCost = amountStickers * STICKER;
                }

                System.out.println("\nStickers: +" + stickerCost + "yen");
            }

            // Licensed stickers
            if (amountLicensedStickers > 0) {
                stickerCost += LICENSED * amountLicensedStickers;
                System.out.println("Licensed stickers: +" + LICENSED * amountLicensedStickers + " yen");
            }

            // Shirts
            int shirtCost = 0;
            if (amountShirts > 0) {
                shirtCost = amountShirts * SHIRT;
                System.out.println("Shirts: +" + shirtCost + " yen");
            }

            int totalCost = stickerCost + shirtCost;
            int subtotal = totalCost;

            System.out.println("Subtotal: " + totalCost + " yen, which is about " + yenToUsd(totalCost) + " USD\n");

            // Donald trump fee
            if (TARIFF) {
                int tariff = (int) (totalCost * 0.2);
                totalCost += tariff;
                System.out.println("Donald Trump fee: +" + tariff + " yen");
            }

            // Forwarding cost
            if (TENSO) {
                totalCost += SHIPPING;
                System.out.println("Shipping: +" + SHIPPING + " yen");
            }

            System.out.println("\nTOTAL COST:\n" + totalCost + " yen, which is about " + yenToUsd(totalCost) + " USD");
            System.out.println("You'll earn " + (subtotal / 200) + " points");

            System.out.println("\nPress enter to continue or type q to quit");

            if (sc.nextLine().toLowerCase().equals("q")) {
                break;
            }
        }

        sc.close();
    }

    // Clears the console
    public static void clearConsole() {
        System.out.print("\033\143");
    }

    // Get an integer input between min and max
    public static int getIntInput(int min, int max) {
        while (true) {
            try {
                int input = Integer.parseInt(sc.nextLine());
                if (input >= min && input <= max) {
                    return input;
                } else {
                    System.out.println("Enter a valid integer between " + min + " and " + max);
                }
            } catch (Exception e) {
                System.out.println("Enter a valid integer");
            }
        }
    }

    // Get an integer input greater than 0
    public static int getIntInput() {
        return getIntInput(0, Integer.MAX_VALUE);
    }

    // Get an integer input between 0 and max
    public static int getIntInput(int max) {
        return getIntInput(0, max);
    }

    // Converts yen to usd with the set conversion rate
    public static int yenToUsd(int yen) {
        return (int) Math.round((double) yen / CONVERSION);
    }
}