package a152_charstreamcopy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileStream {

	public static void main(String[] args) throws IOException {
		/*
		 * FileReader fr = new FileReader("D:/aa.txt"); BufferedReader br = new
		 * BufferedReader(fr);
		 * 
		 * FileWriter fw = new FileWriter("D:/ff.txt"); BufferedWriter bw = new
		 * BufferedWriter(fw); PrintWriter pw = new PrintWriter(bw);
		 */

		// 줄여쓰기 가능. 속에있는 객체는 .close()하지 않아도 된다.
		BufferedReader br = new BufferedReader(new FileReader("D:/aa.txt"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("D:/ff.txt", true)));

		String s = "";
		while ((s = br.readLine()) != null) {
			System.out.println("나 복사중임...");
			pw.println(s); // 콘솔 화면이 아닌 파일 내에 줄바꿈 추가
		}
		br.close();
//		fr.close();
		
		pw.close();
//		bw.close();
//		fw.close();
	}

}
