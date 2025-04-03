package a151_imgfilecopy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Imgfilecopy2 {

	public static void main(String[] args) throws IOException {
		// file copy ; byte stream (이미지 파일의 스트림)
		// file 원본열기
		FileInputStream fis = new FileInputStream("D:/ice-cream-2759348_640.jpg");
		// file 사본열기(붙여넣기될 대상)
		FileOutputStream fos = new FileOutputStream("D:/ice-cream-22.jpg", false);
		
		int i;
		// fis.read() << 파일의 한 byte를 읽어들인다.
		// 한 btye == 영어 한 글자. => != null 아니고 != -1 로.
		while((i = fis.read()) != -1) {
			fos.write(i);
		}
		fis.close();
		fos.close();
	}

}
