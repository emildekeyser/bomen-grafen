package domain;

import java.io.IOException;
import java.util.ArrayList;

public class Graph {
	private final int[][] gewichtenMatrix;

	public Graph(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix.length != matrix[0].length) {
			throw new IllegalArgumentException();
		}

		this.gewichtenMatrix = matrix.clone();
	}

	private int[][] initMatrixDijkstra(int vanKnoop) {
		int[][] res = new int[this.gewichtenMatrix.length + 1][this.gewichtenMatrix.length];
		
			for (int x = 0; x < res[0].length; x++)
			{
				res[0][x] = Integer.MAX_VALUE;
				for (int y = 1; y < res.length; y++)
				{
					int gewicht = this.gewichtenMatrix[y-1][x];
					res[y][x] = gewicht == Integer.MAX_VALUE ? 0 : gewicht;
				}	
			}
			
			for (int i = 0; i < res.length; i++)
			{
				res[i][vanKnoop-1] = 0;
			}

		return res;
	}

	public int[][] Dijkstra(int vanKnoop) {
		int[][] res = initMatrixDijkstra(vanKnoop);
		
		System.out.println("Initiele matrix: \n");
		printIntMatrix(res);
		
		int min = Integer.MAX_VALUE;
		int path = 0;
		int from = 1;
		while(!allesGevonden(res[0]))
		{
			for (int i = 0; i < res[0].length; i++) // overloop header met i
			{
				if (res[0][i] != Integer.MAX_VALUE) // i is gevonden 
				{
					for (int x = 0; x < res[0].length; x++) // dus kijk wat bereikbaar is vanuit i
					{
						if (res[i+1][x] != 0 && res[0][x] == Integer.MAX_VALUE) // we vinden een punt dat bereikbaar is en nog niet bereikt is
						{
							if (res[i+1][x] + res[0][i] < min) // vind het kleinst totale gewicht
							{
								min = res[i+1][x] + res[0][i];
								path = x;
								from = i+1;
							}
						}
					}
				}
			}
			
			if (min == Integer.MAX_VALUE)
			{
				return res;
			}
			
			for (int i = 1; i < res.length; i++)
			{
				if (i != from)
				{
					res[i][path] = 0;					
				}
			}
			
			res[0][path] = min;
			
			min = Integer.MAX_VALUE;
		}

		return res;
	}

	private boolean allesGevonden(int[] res)
	{
		for (int i : res)
		{
			if (i == Integer.MAX_VALUE)
			{
				return false;
			}
		}
		return true;
	}

	private ArrayList<Integer> vindPad(int vanKnoop, int naarKnoop, int[][] res) {
		ArrayList<Integer> pad = new ArrayList<>();
		// oefening 3.5
		return pad;
	}

	public String berekenPaden(int vanKnoop) {
		String uit = "";
		int[][] res = this.Dijkstra(vanKnoop);

		System.out.println("Resulterende matrix: \n");
		printIntMatrix(res);
		
		for (int i = 0; i < res[0].length; i++) {
			if ((i + 1) != vanKnoop) {
				if (res[0][i] == Integer.MAX_VALUE) {
					uit += "Er is geen pad van " + vanKnoop + " naar " + (i + 1) + "\n";
				} else {
					uit += "Kortste afstand van " + vanKnoop + " naar " + (i + 1) + " = " + res[0][i] + "\n";
					uit += "via ";

					int j = (i + 1);
					ArrayList<Integer> pad = vindPad(vanKnoop, j, res);
					uit += pad + "\n";
				}
			}
		}
		return uit;
	}
	
	private static void printIntMatrix(int[][] matrix) {
		String result ="";
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				result += (matrix[i][j] == Integer.MAX_VALUE ? "inf" : matrix[i][j]) + "\t";
			}
			result += "\n";
		}
		result += "\n";
		
		System.out.println(result);		
	}

}
