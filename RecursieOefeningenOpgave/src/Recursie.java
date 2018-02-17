import java.util.ArrayList;
import java.util.List;

public class Recursie
{

	// Oefening 1: n-de Fibonacci-getal

	public static int fibonacci(int getal)
	{
		if(getal <= 0)
		{
			throw new IllegalArgumentException();
		}
		
		if (getal == 1 || getal == 2)
		{
			return 1;
		}
		else
		{
			return fibonacci(getal - 2) + fibonacci(getal - 1);
		}
	}

	// Oefening 2 : som van cijfers

	public static int somVanCijfers(int getal)
	{	
		getal = Math.abs((getal));
		
		if (getal < 10)
		{
			return getal;
		}
		else
		{
			return getal % 10 + somVanCijfers(Math.round(getal / 10));
		}
	}

	// Oefening 3: keer een string om
	public static String keerOm(String s)
	{
		if (s.isEmpty())
		{
			return "";
		}
		else
		{
			return s.substring(s.length() - 1) + keerOm(s.substring(0, s.length() - 2));
		}
	}

	// oefening 4: countX

	public static int countX(String s)
	{
		return 0;
	}

	// oefening 5 : countHi
	public static int countHi(String s)
	{
		return 0;
	}

	// oefening 6
	public static String changeXY(String s)
	{
		return "";
	}

	// oefening 7

	public static String changePi(String s)
	{
		return "";

	}

	// oefening 8:
	public static int tweelog(int getal)
	{
		return 0;
	}

	// oefening 9;
	public static double findMaximum(List<Double> lijst)
	{
		return 0.0;
	}

	// oefening 10;
	public static ArrayList<String> findSubstrings(String string)
	{
		return null;
	}

}