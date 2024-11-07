package miniProject_241104;

public class StudentScore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] scores = { { 80, 60, 70 }, { 90, 95, 80 }, { 75, 80, 100 }, { 80, 70, 95 }, { 100, 65, 80 } };

		System.out.println("학생번호   국어   영어   수학    총점    평균");
		System.out.println("=============================================");

		for (int i = 0; i < scores.length; i++) {
			int total = 0; 

			System.out.printf("%2d번 학생:", (i + 1));

			for (int j = 0; j < scores[i].length; j++) {
				total += scores[i][j]; 
				System.out.printf("%6d", scores[i][j]); 
			}

			double average = total / (double) scores[i].length; 
			System.out.printf("%8d%8.1f\n", total, average); 
		}

	}

}
