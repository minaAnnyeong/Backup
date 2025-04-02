package a145_2cha;

import java.util.Scanner;

public class Echa_ans {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] k3 = new int[3][4];// 3행 4열

		Scanner sc2 = new Scanner(System.in);

		int s2 = 0, a2 = 0;
		while (true) {
			// 성별입력은 0,1 나이입력은 0 1 2
			System.out.println("성별 나이");
			String sa2 = sc2.nextLine(); // "0 1"
			String[] k22 = sa2.split(" ");// "0" "1"

			if (k22[0].equals("9"))
				break;

			s2 = Integer.parseInt(k22[0]); // "0"==> 0 //행
			a2 = Integer.parseInt(k22[1]); // "1"==> 1 //열

			k3[s2][a2] = k3[s2][a2] + 1; // a=a+1
			k3[s2][3] += 1;
			k3[2][a2] += 1;
			k3[2][3] += 1;
		} // while

		for (int p = 0; p < k3.length; p++) {
			for (int j = 0; j < k3[p].length; j++) {
				System.out.print(k3[p][j] + "\t");
			}
			System.out.println();// 줄바꿈
		}
		sc2.close();

	}// main-end
}
