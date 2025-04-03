package a150_files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class File2 {
//												예외처리: read하고자하는 파일이 없을경우 등
	public static void main(String[] args) throws IOException {
//		텍스트뷰어 만들기
//		메모장 글>read>화면출력
		FileReader fr = new FileReader("D:/aa.txt"); // file open
		BufferedReader br = new BufferedReader(fr);
		// read시, 한 줄 단위로 읽는다.
//		String s = br.readLine(); 
//		System.out.println(s);

		// read 한 줄 말고 전체를 읽는다.
		String s = null;
		while ((s = br.readLine()) != null) {
			System.out.println(s);
		}
		
		br.close();
		fr.close();
	}

}
