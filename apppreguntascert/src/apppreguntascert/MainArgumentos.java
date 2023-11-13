package apppreguntascert;

public class MainArgumentos {

	public static void main(String[] args) {
		if (args[0].equals("open"))
		{
			if (args[1].equals("someone"))
				System.out.println("Hello!");
			else
				System.out.println("Go away " + args[1]);
		}

	}

}
