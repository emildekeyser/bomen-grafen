package domain;

import java.util.ArrayList;
import java.util.List;

public class Graph
{
	private final int[][] gewichtenMatrix;

	public Graph(int[][] matrix)
	{
		if (matrix == null || matrix.length == 0
				|| matrix.length != matrix[0].length)
		{
			throw new IllegalArgumentException();
		}

		this.gewichtenMatrix = matrix.clone();
	}
	
	public Integer berekenKleinsteDebiet(List<Integer> pad)
	{
		int debiet = 0;
		int min = Integer.MAX_VALUE;
		int first = 0;
		
		for (int i = 1; i < pad.size(); i++)
		{
			debiet = this.gewichtenMatrix[pad.get(first)][pad.get(i)];
			min = Math.min(min, debiet);
			first = i;
		}
		
		return min;
	}
	
	public List<List<Integer>> alleMogelijkePaden(int van, int naar)
	{
		List<List<Integer>> v = new ArrayList<>();		
		for (int i = 0; i < gewichtenMatrix.length; i++)
		{
			if (this.gewichtenMatrix[van-1][i] != 0 && this.gewichtenMatrix[van-1][i] != Integer.MAX_VALUE)
			{
				if (i == naar -1)
				{
					List<Integer> res = new ArrayList<>();
					res.add(van);
					res.add(naar);
					v.add(res);
				}
			}
			else
			{
				List<List<Integer>> m = this.alleMogelijkePaden(i+1, naar);
				if (m.size() != 0)
				{
					for (List<Integer> l : m)
					{
						l.add(0, van);
						v.add(l);
					}
				}
			}
		}
		return v;
	}
	
	public List<Integer> berekenWegMetOptimaalDebiet(int van, int naar)
	{
		List<Integer> ret = new ArrayList<>();
		for (List<Integer> pad : this.alleMogelijkePaden(van, naar))
		{
			ret.add(this.berekenKleinsteDebiet(pad));
		}
		return ret ;
	}

	
	
	
	
	
	private int[][] initMatrixDijkstra(int vanKnoop)
	{
		int[][] res = new int[this.gewichtenMatrix.length
				+ 1][this.gewichtenMatrix.length];

		for (int x = 0; x < res[0].length; x++)
		{
			res[0][x] = Integer.MAX_VALUE;
		}

		for (int y = 1; y < res.length; y++)
		{
			for (int x = 0; x < res[0].length; x++)
			{
				res[y][x] = this.gewichtenMatrix[y - 1][x];
				res[y][x] = res[y][x] == Integer.MAX_VALUE ? 0 : res[y][x];
			}
		}

		for (int y = 0; y < res.length; y++)
		{
			res[y][vanKnoop - 1] = 0;
		}

		return res;
	}

	public int[][] Dijkstra(int vanKnoop)
	{
		int[][] res = initMatrixDijkstra(vanKnoop);

		System.out.println("Initiele matrix: \n");
		printIntMatrix(res);

		ArrayList<Integer> berijkt = new ArrayList<>();
		Integer volgendeKnoop = vanKnoop-1;
		int vorigeknoop = vanKnoop;
		Integer kortste;
		
		while (berijkt.size() != res[0].length)
		{
			berijkt.add(volgendeKnoop+1);
			kortste = Integer.MAX_VALUE;
			for (Integer knoop : berijkt)
			{
				for (int x = 0; x < res[0].length; x++)
				{
					if (res[knoop][x] != 0 
							&& res[0][x] == Integer.MAX_VALUE
							&& res[knoop][x] + res[0][knoop - 1] < kortste)
					{

						kortste = res[knoop][x] + res[0][knoop - 1];
						volgendeKnoop = x;
						vorigeknoop = knoop;
					}
				}
			}

			res[0][volgendeKnoop] = kortste;
			for (int y = 1; y < res.length; y++)
			{
				if (y != vorigeknoop)
				{
					res[y][volgendeKnoop] = 0;
				}
			}
		}

		return res;
	}

	private ArrayList<Integer> berijkteKnopen(int[][] res)
	{
		ArrayList<Integer> ber = new ArrayList<>();
		for (int i = 0; i < res[0].length; i++)
		{
			if (res[0][i] != Integer.MAX_VALUE)
			{
				ber.add(i + 1);
			}
		}
		return ber;
	}

	private ArrayList<Integer> vindPad(int vanKnoop, int naarKnoop, int[][] res)
	{
		ArrayList<Integer> pad = new ArrayList<>();
		
		pad.add(naarKnoop);
		
		while (pad.get(0) != vanKnoop)
		{
			for (int y = 1; y < res.length; y++)
			{
				if (res[y][pad.get(0)-1] != 0)
				{
					pad.add(0, y);
				}
			}
		}
		
		return pad;
	}

	public String berekenPaden(int vanKnoop)
	{
		String uit = "";
		int[][] res = this.Dijkstra(vanKnoop);

		System.out.println("Resulterende matrix: \n");
		printIntMatrix(res);

		for (int i = 0; i < res[0].length; i++)
		{
			if ((i + 1) != vanKnoop)
			{
				if (res[0][i] == Integer.MAX_VALUE)
				{
					uit += "Er is geen pad van " + vanKnoop + " naar " + (i + 1)
							+ "\n";
				}
				else
				{
					uit += "Kortste afstand van " + vanKnoop + " naar "
							+ (i + 1) + " = " + res[0][i] + "\n";
					uit += "via ";

					int j = (i + 1);
					ArrayList<Integer> pad = vindPad(vanKnoop, j, res);
					uit += pad + "\n";
				}
			}
		}
		return uit;
	}

	private static void printIntMatrix(int[][] matrix)
	{
		String result = "";
		for (int i = 0; i < matrix.length; i++)
		{
			for (int j = 0; j < matrix[0].length; j++)
			{
				result += (matrix[i][j] == Integer.MAX_VALUE
						? "inf"
						: matrix[i][j]) + "\t";
			}
			result += "\n";
		}
		result += "\n";

		System.out.println(result);
	}

}
