package domain;

import java.util.ArrayList;
import java.util.List;

public class WeightedGraph {
	private final double[][] gewichtenMatrix;
	public final static double infty = Double.POSITIVE_INFINITY;

	public WeightedGraph(double[][] matrix) {
		if (matrix == null || matrix.length != matrix[0].length)
			throw new IllegalArgumentException("No valid gewichtenmatrix");
		this.gewichtenMatrix = matrix;
	}

	public int[][] findDistances() {
		int[][] path = new int[this.gewichtenMatrix.length][this.gewichtenMatrix.length];
		double[][] distanceMatrix = new double[this.gewichtenMatrix.length][this.gewichtenMatrix.length];
		for (int i = 0; i < this.gewichtenMatrix.length; i++) {
			for (int j = 0; j < this.gewichtenMatrix.length; j++) {
				distanceMatrix[i][j] = this.gewichtenMatrix[i][j];
				path[i][j] = 0;
			}
		}
		
		for (int tussenPunt = 0; tussenPunt < distanceMatrix.length; tussenPunt++)
		{
			for (int van = 0; van < distanceMatrix.length; van++)
			{
				for (int naar = 0; naar < distanceMatrix.length; naar++)
				{
					double nieuwPadGewicht = distanceMatrix[van][tussenPunt];
					nieuwPadGewicht += distanceMatrix[tussenPunt][naar];
					
					if (nieuwPadGewicht < distanceMatrix[van][naar])
					{
						path[van][naar] = tussenPunt+1;
						distanceMatrix[van][naar] = nieuwPadGewicht; 
					}
				}
			}
		}

		return path;
	}

	public List<Integer> getShortestPath(int i, int j, int[][] path) {
		List<Integer> res = new ArrayList<>();

		if (j == i)
		{
			return res;
		}
		
		int next = path[i-1][j-1];
		if (next == 0 && this.gewichtenMatrix[i-1][j-1] != infty)
		{
			res.add(i);
			res.add(j);
		}
		else
		{
			res.addAll(this.getShortestPath(i, next, path));
			List<Integer> rechts = this.getShortestPath(next, j, path);
			rechts.remove(0);
			res.addAll(rechts );
		}

		return res;

	}

	public int berekenLengte(List<Integer> pad) {
		int som = 0;
	
		if (pad.size() >= 2)
		{
			for (int i = 1; i < pad.size(); i++)
			{
				som += this.gewichtenMatrix[pad.get(i-1)-1][pad.get(i)-1];
			}
		}
		
		return som;
	}

}
