package apppreguntascert;

public class IfTernario {
	public static void main(String[] args) {
		int i = 0;

		boolean bool1 = true;
		boolean bool2 = false;
		boolean bool = false;

		bool = (bool2 &  method1(i++)); // 1
		bool = (bool2 && method1(i++)); // 2
		bool = (bool1 |  method1(i++)); // 3
		bool = (bool1 || method1(i++)); // 4

		System.out.println(i);
	}

	public static boolean method1(int i) {
		return i > 0 ? true : false;
	}

}
