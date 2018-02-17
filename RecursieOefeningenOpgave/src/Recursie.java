import java.util.ArrayList;
import java.util.List;

public class Recursie
{

	// Oefening 1: n-de Fibonacci-getal

	public static int fibonacci(int getal)
	{
		if (getal <= 0)
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
		if (s == null)
		{
			throw new IllegalArgumentException();
		}
		else if (s.isEmpty())
		{
			return "";
		}
		else if (s.length() == 1)
		{
			return s;
		}
		else
		{
			int l = s.length();
			return s.substring(l - 1, l) + keerOm(s.substring(0, l - 1));
		}
	}

	// oefening 4: countX

	public static int countX(String s)
	{
		if (s == null)
		{
			throw new IllegalArgumentException();
		}
		else if (s.isEmpty())
		{
			return 0;
		}
		else if (s.startsWith("x"))
		{
			return 1 + countX(s.substring(1));
		}
		else
		{
			return countX(s.substring(1));
		}
	}

	// oefening 5 : countHi
	public static int countHi(String s)
	{
		if (s == null)
		{
			throw new IllegalArgumentException();
		}
		else if (s.isEmpty())
		{
			return 0;
		}
		else if (s.startsWith("hi"))
		{
			return 1 + countHi(s.substring(1));
		}
		else
		{
			return countHi(s.substring(1));
		}
	}

	// oefening 6
	public static String changeXY(String s)
	{
		if (s == null)
		{
			throw new IllegalArgumentException();
		}
		else if (s.isEmpty())
		{
			return "";
		}
		else if (s.startsWith("x"))
		{
			return "y" + changeXY(s.substring(1));
		}
		else
		{
			return s.charAt(0) + changeXY(s.substring(1));
		}
	}

	// oefening 7

	public static String changePi(String s)
	{
		if (s == null)
		{
			throw new IllegalArgumentException();
		}
		else if (s.isEmpty())
		{
			return "";
		}
		else if (s.startsWith("pi"))
		{
			return "3.14" + changePi(s.substring(2));
		}
		else
		{
			return s.charAt(0) + changePi(s.substring(1));
		}

	}

	// oefening 8:
	public static int tweelog(int getal)
	{
		if (getal <= 0)
		{
			throw new IllegalArgumentException();
		}
		else if (getal == 1)
		{
			return 0;
		}
		else
		{
			return 1 + tweelog(getal / 2);
		}
	}

	// oefening 9;
	public static double findMaximum(List<Double> lijst)
	{
		if (lijst == null)
		{
			throw new IllegalArgumentException();
		}
		else if(lijst.isEmpty())
		{
			throw new IllegalArgumentException();
		}
		else if(lijst.size() == 1)
		{
			return lijst.get(0);
		}
		else if (lijst.get(0) > lijst.get(lijst.size() - 1))
		{
			lijst.add(lijst.get(0));
			lijst.remove(0);
			return findMaximum(lijst);
		}
		else
		{
			lijst.remove(0);
			return findMaximum(lijst);
		}
	}

	// oefening 10;
	public static ArrayList<String> findSubstrings(String string)
	{
		System.out.println(string);
		
		if (string == null)
		{
			throw new IllegalArgumentException();
		}
		else if(string.length() <= 1)
		{
			ArrayList<String> a = new ArrayList<>(1);
			a.add(string);
			return a;
		}
		else
		{
			ArrayList<String> a = new ArrayList<>();
			a.add(string);
			for (int i = 0; i < string.length(); i++)
			{
				String s = string.substring(0, i) + string.substring(i+1);
				a.addAll(findSubstrings(s));
			}
			return a;
		}
	}

}