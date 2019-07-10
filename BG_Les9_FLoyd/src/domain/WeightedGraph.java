package domain;

import java.util.ArrayList;
import java.util.List;

public class WeightedGraph
{
	private final double[][] gewichtenMatrix;
	public final static double infty = Double.POSITIVE_INFINITY;

	public WeightedGraph(double[][] matrix)
	{
		if (matrix == null || matrix.length != matrix[0].length)
			throw new IllegalArgumentException("No valid gewichtenmatrix");
		this.gewichtenMatrix = matrix;
	}

	public int[][] findDistances()
	{
		int[][] path = new int[this.gewichtenMatrix.length][this.gewichtenMatrix.length];
		double[][] distanceMatrix = new double[this.gewichtenMatrix.length][this.gewichtenMatrix.length];
		for (int i = 0; i < this.gewichtenMatrix.length; i++)
		{
			for (int j = 0; j < this.gewichtenMatrix.length; j++)
			{
				distanceMatrix[i][j] = this.gewichtenMatrix[i][j];
			}
		}

		for (int d = 0; d < distanceMatrix.length; d++)
		{
			for (int i = 0; i < this.gewichtenMatrix.length; i++)
			{
				for (int j = 0; j < this.gewichtenMatrix.length; j++)
				{
					double sumDInbetween = distanceMatrix[i][d] + distanceMatrix[d][j];
					double weight = distanceMatrix[i][j];
					distanceMatrix[i][j] = Math.min(weight, sumDInbetween);
					path[i][j] = weight > sumDInbetween ? d + 1 : path[i][j];
					
				}
			}
		}

		return path;
	}

	public List<Integer> getShortestPath(int i, int j, int[][] path)
	{
		List<Integer> res = new ArrayList<>();

		if (path[i-1][j-1] == 0)
		{
			res.add(i);
			res.add(j);
		}
		else
		{
			res.addAll(getShortestPath(i, path[i-1][j-1], path));
			res.addAll(getShortestPath(path[i-1][j-1], j, path));
		}

		return res;

	}

	public int berekenLengte(List<Integer> pad)
	{
		int som = 0;
		for (int i = 0; i < pad.size() - 1; i += 2)
		{
			som += this.gewichtenMatrix[pad.get(i)-1][pad.get(i+1)-1];
		}
		return som;
	}

}
