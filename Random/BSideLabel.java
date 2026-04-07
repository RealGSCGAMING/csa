import java.util.Scanner;

public class BSideLabel {

    public static final int STICKER = 330;
    public static final int LICENSED = 385;
    public static final int SHIRT = 3850;
    public static final int SHIPPING = 3000;

    public static final boolean COUPON = true;
    public static final boolean TENSO = true;
    public static final boolean TARIFF = true;

    public static final double CONVERSION = 159.69;

    public static int presetStickers = -1;
    public static int presetShirts = -1;

    public static void main(String[] args) {

        clearConsole();

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the B SIDE LABEL price calculator");

        while (true) {
            System.out.println();
            int amountStickers, amountShirts, amountLicensedStickers;

            // Get amount of stickers
            if (presetStickers == -1) {
                System.out.println("How many stickers do you want to buy");
                amountStickers = Integer.parseInt(sc.nextLine());
                System.out.println("How many of them are licensed");
                amountLicensedStickers = Integer.parseInt(sc.nextLine());
            } else {
                amountStickers = presetStickers;
                amountLicensedStickers = 0;
            }

            // Get amount of shirts
            if (presetShirts == -1) {
                System.out.println("How many shirts do you want to buy");
                amountShirts = Integer.parseInt(sc.nextLine());
            } else {
                amountShirts = presetShirts;
            }
            
            if (amountStickers <= 0 && amountShirts <= 0) {
                System.out.println("You can't buy nothing!");
                continue;
            }

            // Stickers
            int stickerCost = 0;
            if (amountStickers > 0) {
                // Check if using the birthday coupon
                if (COUPON && amountStickers >= 4) {

                    int paidStickers = 0;
                    int freeStickers = 0;
                    int amountTemp = amountStickers; //int amountTemp = amountStickers - amountLicensedStickers;

                    while (freeStickers < 5 && amountTemp >= 4) {
                        amountTemp -= 4;
                        freeStickers += 1;
                        paidStickers += 3;
                    }

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

            System.out.println("Subtotal: " + totalCost + " yen, which is about " + (Math.round((double) totalCost / CONVERSION)) + " USD\n");

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

            double usd = (double) totalCost / CONVERSION;

            System.out.println("\nTOTAL COST:\n" + totalCost + " yen, which is about " + Math.round(usd) + " USD");
            System.out.println("You'll earn " + (subtotal / 200) + " points");

            System.out.println("\nPress enter to continue or type q to quit");

            if (sc.nextLine().toLowerCase().equals("q")) {
                break;
            }
        }

        sc.close();
    }

    public static void clearConsole() {
        System.out.print("\033\143");
    }
}