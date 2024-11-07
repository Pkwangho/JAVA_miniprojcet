package miniProject_241104;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Cumstomer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

		HashMap<String, Integer> customerBalances = new HashMap<>();

		System.out.println("<< 통장 관리 프로그램입니다. >>");

		while (true) {
			// 고객 이름을 입력 받음
			System.out.print("이름과 금액 입력>> ");
			String input = scanner.nextLine();

			// "exit"이 입력되면 종료
			if (input.equalsIgnoreCase("exit")) {
				System.out.println("프로그램을 종료합니다...");
				break;
			}
			String[] parts = input.split(" ");
			String name = parts[0];
			int amount = Integer.parseInt(parts[1]);

			customerBalances.put(name, customerBalances.getOrDefault(name, (int) 0) + amount);

			// 현재까지의 모든 고객 잔액 출력
			StringBuilder output = new StringBuilder();
			for (Entry<String, Integer> entry : customerBalances.entrySet()) {
				output.append("(").append(entry.getKey()).append(">").append(entry.getValue()).append("원) ");

			}
			System.out.println(output.toString().trim());

		}
		scanner.close();
	}
}
