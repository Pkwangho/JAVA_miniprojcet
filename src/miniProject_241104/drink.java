package miniProject_241104;

import java.util.HashMap;
import java.util.Scanner;

public class drink {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		HashMap<String, Integer> map = new HashMap<>();

		map.put("밀키스", 700);
		map.put("코카콜라", 800);
		map.put("펩시", 1000);
		map.put("칠성사이다", 1200);

		System.out.println("밀키스, 코카콜라, 펩시, 칠성사이다 있습니다.");

		while (true) {
			System.out.print("선택 >> ");
			String drinkName = scanner.nextLine();


			if (drinkName.equalsIgnoreCase("그만")) {
				System.out.println("종료합니다...");
				break;
			}

			// 음료수 가격을 HashMap에서 조회
			if (map.containsKey(drinkName)) {
				// 가격 출력
				int price = map.get(drinkName);
				System.out.println(drinkName + "는 " + price + "원 입니다.");
			} else {
				// 음료수가 없을 경우
				System.out.println("해당 음료수가 없습니다.");

			}

		}
	}
}
