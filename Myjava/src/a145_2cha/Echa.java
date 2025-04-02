package a145_2cha;

import java.util.Scanner;

public class Echa {

	public static void main(String[] args) {
		int[][] k = new int[2][3];
		k[0][0] = 100;
		k[0][1] = 200;
		k[1][2] = 1000;

		int[][] k2 = { { 10, 20, 30 }, { 40, 50, 60 } };
		for (int i = 0; i < k2.length; i++) {
			for (int j = 0; j < k2[0].length; j++) {
				System.out.print(k2[i][j] + " ");
			}
			System.out.println();
		}
		/*
		 * for (int[] is : k2) { System.out.println(String.valueOf(is.toString())); }
		 */

//		Q) 남녀별 , 나이별 통계를 작성하시오
//		단, 성별, 나이를 입력받는다. 입력의 끝은 9 9 가 들어온다.
		/* input design */
		/*
		 * 0 1\n1 0\n1 2\n1 1\n9 9\n
		 */

		/* output design */
		/*
		 *
		 * 	10대 20대 30대 계
		 *  남 10 20 15 45 
		 *  여 29 23 30 82 
		 *  계 39 43 45 127 
		 *  >> 글자 말고 숫자만 출력 되어도ok
		 */
		Scanner sc = new Scanner(System.in);
		int [][] k3 = new int[3][4];
		int s2 = 0, a2 = 0;
		
		while(true) {
			// 성별: 0/1 , 나이: 0/1/2
			System.out.println("[성별(0/1) 나이(0/1/2)] 입력: ");
			String sa2 = sc.nextLine();
			if(sa2.equals("9 9")) {
				break;
			}
			String[] k22 = sa2.split(" "); // "0 1" ==> {"0", "1"}
			
			s2 = Integer.parseInt(k22[0]); // "0" ==> 0
			a2 = Integer.parseInt(k22[1]); // "1" ==> 1
			
			// 칸에 카운트++ 될 때마다 총합칸에도 카운트++ 하는 방식
			k3[s2][a2]++;
			k3[s2][k3[0].length - 1]++;
			k3[k3.length - 1][a2]++;
			k3[k3.length - 1][k3[0].length - 1] += 2;
		}
		System.out.println("\t10대\t20대\t30대\t계");
		System.out.print("남\t");
		for (int i = 0; i < k3[0].length; i++) {
			System.out.print(k3[0][i] + "\t");
		}
		System.out.println();
		System.out.print("여\t");
		for (int i = 0; i < k3[0].length; i++) {
			System.out.print(k3[1][i] + "\t");
		}
		System.out.println();
		System.out.print("계\t");
		for (int i = 0; i < k3[0].length; i++) {
			System.out.print(k3[2][i] + "\t");
		}
		
		sc.close();
	}

}
