package ui;

import java.util.List;

import domain.Graph;

public class BreadthFirstSearchUI {

	public static void main(String[] args) {

//		int data[][] = { 	{ 0, 1, 0, 1, 0, 0, 0 }, // nabijheidsmatrix van graf  uit  figuur  1.5  van  cursus (1-7 7-1)
//							{ 0, 0, 1, 0, 0, 0, 0 }, 
//							{ 1, 0, 0, 1, 1, 0, 0 },
//							{ 0, 0, 0, 0, 1, 1, 0 }, 
//							{ 0, 1, 0, 0, 0, 0, 1 }, 
//							{ 0, 0, 0, 0, 0, 0, 1 }, 
//							{ 0, 0, 0, 0, 0, 0, 0 } };
		
		int data[][] = 
			{
				{0,1,1,1,0,0,0,0},
				{1,0,1,0,1,0,0,0},
				{1,1,0,0,0,1,0,0},
				{1,0,0,0,0,1,1,0},
				{0,1,0,0,0,1,0,1},
				{0,0,1,1,1,0,1,0},
				{0,0,0,1,0,1,0,1},
				{0,0,0,0,1,0,1,0},
			};
		
		Graph bfs = new Graph(data);

		int start = 1;
		int destination = 8;
		// deelresultaat afdrukken
		System.out.println(bfs.geefAncestors(start, destination));
		// eindresultaat
		System.out.println(zetPadOmNaarString(start, destination, bfs.findPath(start, destination)));

		start = 2;
		destination = 7;
		// deelresultaat afdrukken
		System.out.println(bfs.geefAncestors(start, destination));
		// eindresultaat
		System.out.println(zetPadOmNaarString(start, destination, bfs.findPath(start, destination)));
		
		start = 8;
		destination = 1;
		// deel resultaat afdrukken
		System.out.println(bfs.geefAncestors(start, destination));
		// eindresultaat
		System.out.println(zetPadOmNaarString(start, destination, bfs.findPath(start, destination)));
	}

	private static String zetPadOmNaarString(int start, int destination, List<Integer> path) {
		if (path.size() == 0)
			return "Er is geen pad van " + start + " naar " + destination;
		else
			return "Kortste pad van " + start + " naar "+ destination + " is " + path.size() + " knopen lang en bestaat uit volgende knopen  : " + path;
	}
}
