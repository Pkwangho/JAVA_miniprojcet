package miniProject_241104;

import java.util.Scanner;

public class Comma {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

		while (true) {
			String input = scanner.nextLine();

			if (input.equalsIgnoreCase("exit")) {
				System.out.println("종료합니다...");
				break;

			}
			String[] words = input.split(",");
			System.out.println("어절의 개수: " + words.length);
		}
		scanner.close();

	}

}
