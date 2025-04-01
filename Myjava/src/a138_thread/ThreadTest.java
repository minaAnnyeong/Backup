package a138_thread;

class ThreadClass2 extends Thread {
	public void run() {
		System.out.println(getName() + "나는 나이");
		System.out.println("All ypu nedd id love");
	}
}

class ThreadClass3 extends Thread {
	public void run() {
		System.out.println(getName() + "나는 나이");
		System.out.println("Love is all you need");
	}
}

public class ThreadTest {

	public static void main(String[] args) {
		ThreadClass2 tc2 = new ThreadClass2();
		ThreadClass2 tc3 = new ThreadClass2();
		tc2.start();
		tc3.start();
	}

}
