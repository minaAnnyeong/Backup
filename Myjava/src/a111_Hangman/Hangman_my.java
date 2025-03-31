package a111_Hangman;

import java.util.Scanner;

public class Hangman_my {

	public static void main(String[] args) {
		String tar = "picture";
		char[] underbar = "_".repeat(tar.length()).toCharArray();
		int count = 0;
		Scanner sc = new Scanner(System.in);

		while (count < 13) {
			System.out.println(String.valueOf(underbar) + " " + count + " 번쨰시도");
			System.out.println("예상글자입력: ");
			char inchar = sc.next().charAt(0);
			for (int i = 0; i < tar.length(); i++) {
				if (underbar[i] == '_' && tar.charAt(i) == inchar) {
					underbar[i] = inchar;
					break;
				}
			}
			if (String.valueOf(underbar).equals(tar)) {
				System.out.println(tar + " 정답");
				break;
			}
			count++;
		}

		if (count > 12) {
			System.out.println("다음기회에");
		}

		sc.close();

	}

}
