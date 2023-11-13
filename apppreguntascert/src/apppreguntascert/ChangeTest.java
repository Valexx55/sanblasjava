package apppreguntascert;

public class ChangeTest {
	private int myValue = 0;

	public void showOne(int myValue) {
		myValue = myValue;
	}

	public void showTwo(int myValue) {
		this.myValue = myValue;
	}

	public static void main(String[] args) {
		var ct = new ChangeTest();
		ct.showTwo(200);
		System.out.println(ct.myValue);
		ct.showOne(100);
		System.out.println(ct.myValue);
	}

}