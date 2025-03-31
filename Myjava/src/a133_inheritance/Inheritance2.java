package a133_inheritance;

class Nulbi {
	protected int karo = 10;
	protected int sero = 20;

	public void nulbikyesan() {
		System.out.println(karo * sero);
	}
}

class Boopi extends Nulbi {
	protected int nopi = 5;

	public void boopikyesan() {
		System.out.println(karo * sero * nopi);
	}
}

public class Inheritance2 {

	public static void main(String[] args) {
		Nulbi n1 = new Nulbi();
		n1.nulbikyesan();
		
		Boopi b1 = new Boopi();
		b1.boopikyesan();
		  
	}

}
