/*
 * Activity 2.1.4
 */

import java.util.Scanner;

public class LetterFrequencies {
	public static void main(String[] args) {
		String letters = "abcdefghijklmnopqrstuvwxyz";
		System.out.println("Enter a phrase:");
		Scanner sc = new Scanner(System.in);
		String phrase = sc.nextLine();
		sc.close();

		System.out.println("Letter frequencies in '" + phrase + "'");

		for (int i = 0; i < letters.length(); i++) {

			char letter = letters.charAt(i);

			int count = 0;

			for (int i2 = 0; i2 < phrase.length(); i2++) {

				char letter2 = phrase.charAt(i2);

				if (letter == letter2) {
					count++;
				}
			}

			if (count > 0) {
				System.out.println(letter + ": " + count);
			}

		}
	}
}
