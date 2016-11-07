package testgid2.testaid2;

/**
 * Hello world!
 *
 */
public class App 
{
	public static boolean t = true;
    public static void main( String[] args )
    {
        (new Thread(new Runnable(){
        	public void run(){
        		System.out.println("Hello world!");
        	}
        })).start();
        System.out.println( "Hello World!" );
        System.out.println( Vigenere( "ABCY", new int[]{2,3,4}));
        System.out.println( Vigenere( "DADPSGSHCIITQLRGLDYEKCIYAPORLSKHFOETSLWLQBDAUPSNYYRIRNRCEK", new int[]{-2, -15, -3, -7, -0}));
        System.out.println( Anzahl("Hello World!", 'o', 2, 3));
        System.out.println( -3 % 5 );
        String c = "HLNFYJXPTGOFRTBXOFQHUMRFVJIEYMIZCEICENFKLMEUHIYTXTBPZEMLFRAAMMGIYVRNFMUFVCJKLOIYFGOJJMSIKJIZFIUUHLDOBOKDVVKFNLESJIHHNESTRPDLAPIMGIUUPPDLIFOHORAHITBGOU";
        Test(c, 4);
        System.out.println( Vigenere( c, new int[]{-4, -7, -1}));
        System.out.println( Vigenere( "ILFLNI", new int[]{-4, -24, -18, -3, -9, 5}));

        
    }
    public static int StelleImAlphabet(char x)
    {
    	return x - 'A' + 1;
    }
    public static char Shift(char x, int k)
    {
    	if(k < 0)
    		k += 26;
    	return (char)((StelleImAlphabet(x) + k - 1) % 26 + 'A');
    }
    public static String Vigenere(String X, int[] k)
    {
    	String Y = "";
    	for(int i = 0; i < X.length(); i++)
    	{
    		Y += Shift(X.charAt(i), k[i % k.length]);
    	}
    	return Y;
    }
    public static int Anzahl(String X, char x, int a, int s)
    {
    	int res = 0;
    	for(int i = a - 1; i < X.length(); i += s)
    	{
    		if(X.charAt(i) == x)
    			res++;
    	}
    	return res;
    }
    public static char AlleBuchstaben(String X, int a, int s)
    {
    	char buchstabe = '_';
    	int max = 0;
    	int temp = 0;
    	for(char c = 'A'; c <= 'Z'; c++)
    	{
    		temp = Anzahl(X, c, a, s);
    		if(temp > max)
    		{
    			max = temp;
    			buchstabe = c;
    		}
    	}
    	System.out.print("Max: " + max);
    	return buchstabe;
    }
    public static void Test(String X, int smax)
    {
    	for(int s = 1; s <= smax; s++)
    	{
    		System.out.print("\nSchlüssellänge: " + s + " ");
    		for(int a = 1; a <= s; a++)
    		{
    			System.out.print("(" + a + ", " + AlleBuchstaben(X, a, s) + "), ");
    			//System.out.println("Buchstabe: " + AlleBuchstaben(X, a, s));
    		}
    	}
    	System.out.println();
    }
    
}
