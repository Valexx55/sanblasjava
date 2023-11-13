package apppreguntascert;

public class StaticVsDinamic {
	
	static int a = 0;
	int b;// = 5;
	
	public StaticVsDinamic() {
		this.b = 5;
	}
	
	public void foo ()
	{
		while (this.b>0)
		{
			this.b--;
			StaticVsDinamic.a++;
		}
	}
	
	public static void main(String[] args) {
		var p1 = new StaticVsDinamic();
		p1.foo();
		var p2 = new StaticVsDinamic();
		p2.foo();
		System.out.println(StaticVsDinamic.a +" "+StaticVsDinamic.a);
	}

}
