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
		double[][] distanceMatrix = this.gewichtenMatrix.clone();

		// oefening 2.3

		return path;
	}

	public List<Integer> getShortestPath(int i, int j, int[][] path) {
		List<Integer> res = new ArrayList<>();

		// oefening 2.4

		return res;

	}

	public int berekenLengte(List<Integer> pad) {
		int som = 0;
	
		// oefening 2.5
		
		return som;
	}

}
