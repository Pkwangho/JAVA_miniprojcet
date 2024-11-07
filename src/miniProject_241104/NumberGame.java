package miniProject_241104;

import java.util.Random;
import java.util.Scanner;

public class NumberGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();

		int targetNumber = random.nextInt(100) + 1;

		int attempts = 0; // 시도 횟수를 세기위한 정수형 변수를 0으로 초기화

		if (targetNumber % 2 == 0) {
			System.out.println("힌트: 숫자는 짝수입니다.");
		} else {
			System.out.println("힌트: 숫자는 홀수입니다.");
		}

		while (true) {
			System.out.print("숫자를 입력하세요 (1-100): ");
			int userGuess = scanner.nextInt();
			attempts++;

			if (userGuess < targetNumber) {
				System.out.println("더 큰 수입니다.");
			} else if (userGuess > targetNumber) {
				System.out.println("더 작은 수입니다.");
			} else {
				System.out.println("정답입니다! " + attempts + "회만에 맞췄습니다.");
				break;
			}
		}

		scanner.close();

	}

}
