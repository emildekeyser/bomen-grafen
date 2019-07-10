package domain;

import java.util.ArrayList;

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
