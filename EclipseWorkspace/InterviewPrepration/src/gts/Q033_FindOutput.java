package gts;

/**
 * Find Output ??
 public static void main (String args[])
    {
        System.out.println(100 + 100 + "Str");
        System.out.println(Str" + 100 + 100);
    }
 * */
public class Q033_FindOutput {
	public static void main(String args[]) {
		String Str = "hello";
		System.out.println(100 + 100 + "Str" + 100 + 100); // 200Str100100
		System.out.println(100 + 100 + 'a' + 100 + 100); // 497
		System.out.println(Str + 100 + 100); // hello100100
	}
}
