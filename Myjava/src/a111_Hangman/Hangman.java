package a111_Hangman;

import java.util.Scanner;

public class Hangman {

	/*
	 * Q) picture�� ���ڿ� �迭�� �ְ� ���ڸ� �˾Ƹ��ߴ� hangman program �� �ۼ��Ͻÿ�(��, 13��
	 * �ȿ� ���߾�� �Ѵ�)
	 */

	public static void main(String[] args) {
		// String [] aa50={"kim","sam","park"};
		// TODO Auto-generated method stub
		String[] moonja = { "p", "i", "c", "t", "u", "r", "e" };
		String[] jool = { "_", "_", "_", "_", "_", "_", "_" };
		String ip;

		int cnt, sw = 0;// �ʱ�ġ�� ���� �� ���߿�

		for (int j = 0; j < 7; j++) // ó�� �� ��� _______
			System.out.print(jool[j]);
		System.out.println();

		Scanner scan1 = new Scanner(System.in);

		for (int i = 1; i <= 13; i++) { // 13�� üũ
			cnt = 0;
			System.out.println("예상글자입력:");
			ip = scan1.next(); ////////

			for (int j = 0; j < 7; j++) { // ������ڰ� �����ܾ �־�?
				if (ip.equals(moonja[j])) // == �� ������
					jool[j] = moonja[j];
			}
			for (int j = 0; j < 7; j++) // �ְ� ���� ���� �����
				System.out.print(jool[j]);// �����
			System.out.println("\t" + i + "번 시도");

			for (int j = 0; j < 7; j++) { // �����ܾ�� �ٱ��ڰ� 7�� ����?
				if (jool[j].equals(moonja[j]))
					cnt++;
			}
			if (cnt == 7) { // �׷��� �� ���߾����� ������
				System.out.println("정답");
				sw = 1;/////////////////
				break;
			}
		} // 13-for-end
		if (sw == 0)
			System.out.print("다음기회에");
		scan1.close();
	}

}
