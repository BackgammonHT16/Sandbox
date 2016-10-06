package testgid2.testaid2;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello Worlaöldskfjalksfjdasölkfjd!");
		System.out.println(vigenere("ABC", new int[] { 2, 3, 4 }));
		System.out.println(anzahl("aaaabbbaaeee",'a',2,1));
		System.out.println(vigenere("DADPSGSHCIITQLRGLDYEKCIYAPORLSKHFOETSLWLQBDAUPSNYYRIRNRCEK",new int[]{-2,-15,-3,-7,-0}));
		String c = "HLNFYJXPTGOFRTBXOFQHUMRFVJIEYMIZCEICENFKLMEUHIYTXTBPZEMLFRAAMMGIYVRNFMUFVCJKLOIYFGOJJMSIKJIZFIUUHLDOBOKDVVKFNLESJIHHNESTRPDLAPIMGIUUPPDLIFOHORAHITBGOU";
		schlüssellänge(c, 3);
		System.out.println("\n"+ vigenere(c, new int[]{-4,-7,-1}));
	}

	public static int stelleimalphabet(char x) {

		return x - 'A' + 1;
	}

	public static char shift(char x, int k) {
		if (k < 0)
			k += 26;
		return (char) (((stelleimalphabet(x) + k - 1) % 26) + 'A');
	}

	public static String vigenere(String X, int[] k) {
		String Y = "";
		for (int i = 0; i < X.length(); i++) {
			Y += shift(X.charAt(i), k[i % k.length]);

		}
		return Y;
	}

	public static int anzahl(String X, char x, int a, int s) {
		int res = 0;
		for (int i = a - 1; i < X.length(); i += s) {
			if (X.charAt(i) == x)
				res++;
		}
		return res;
	}

	public static char alledurchgehenBUCHSTABE(String X, int a, int s) {
		int temp = 0;
		int maximum = 0;
		char buchstabe = '_';
		for (char c = 'A'; c <= 'Z'; c++) {
			temp = anzahl(X, c, a, s);
			if (temp > maximum){
				maximum = temp;
				buchstabe = c;}

		}
		System.out.print("Max: "+ maximum);
		return buchstabe;

	}

	public static void schlüssellänge(String X, int smax){
		for(int s=1; s <= smax; s++){
		System.out.print("\nSchlüssellänge: " + s + " ");
		 for(int a = 1; a <= s; a ++ ){
			System.out.print(" (" + a +  " ," + alledurchgehenBUCHSTABE(X, a, s) + ") ");
		 }
	}
	}
}
