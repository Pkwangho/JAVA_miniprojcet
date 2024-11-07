package miniProject_241104;

import java.util.Scanner;

public class CircleArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

		Circle[] circles = new Circle[4];

		for (int i = 0; i < circles.length; i++) {
			System.out.print(i + 1 + " 반지름 >>");
			int radius = scanner.nextInt();
			circles[i] = new Circle(radius);
		}
		System.out.println("저장하였습니다...");
		double totalArea = 0;

		for (int i = 0; i < circles.length; i++) {
			totalArea += circles[i].getArea(); // 각 원의 면적을 더함
		}

		System.out.printf("원의 면적 전체 합은 %.2f\n", totalArea);
		scanner.close();

	}

}
