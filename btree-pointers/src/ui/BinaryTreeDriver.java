package ui;

import domain.BinaryIntegerTree;
import domain.BinaryTreeSimple;

public class BinaryTreeDriver
{

	public static void main(String[] args)
	{
//		BinaryTree<String> nodeC = new BinaryTree<String>("C");
//		BinaryTree<String> nodeE = new BinaryTree<String>("E");
//		BinaryTree<String> nodeH = new BinaryTree<String>("H");
//		
//		BinaryTree<String> nodeA = new BinaryTree<String>("A");
//		BinaryTree<String> nodeD = new BinaryTree<String>("D", nodeC, nodeE);
//		BinaryTree<String> nodeI = new BinaryTree<String>("I", nodeH, null);
//		
//		BinaryTree<String> nodeB = new BinaryTree<String>("B", nodeA, nodeD);
//		BinaryTree<String> nodeG = new BinaryTree<String>("G", null, nodeI);
//		
//		BinaryTree<String> boom = new BinaryTree<String>("F", nodeB, nodeG);
//		
//		System.out.println(boom.contains("D"));
//		System.out.println(boom.contains("H"));
//		System.out.println(boom.contains("F"));
//		System.out.println(boom.contains("Q"));

		// 5: Heralingsoefeningen Binaire Boom
		
		BinaryTreeSimple<String> nodeE1 = new BinaryTreeSimple<String>("E");
		BinaryTreeSimple<String> nodeE2 = new BinaryTreeSimple<String>("E");
		
		BinaryTreeSimple<String> nodeC = new BinaryTreeSimple<String>("C", null, nodeE1);
		BinaryTreeSimple<String> nodeE3 = new BinaryTreeSimple<String>("E");
		BinaryTreeSimple<String> nodeH1 = new BinaryTreeSimple<String>("H", null, nodeE2);
		BinaryTreeSimple<String> nodeE4 = new BinaryTreeSimple<String>("E");
		
		BinaryTreeSimple<String> nodeA = new BinaryTreeSimple<String>("A");
		BinaryTreeSimple<String> nodeH2 = new BinaryTreeSimple<String>("H", nodeC, nodeE3);
		BinaryTreeSimple<String> nodeI = new BinaryTreeSimple<String>("I", nodeH1, nodeE4);
		
		BinaryTreeSimple<String> nodeH3 = new BinaryTreeSimple<String>("H", nodeA, nodeH2);
		BinaryTreeSimple<String> nodeG = new BinaryTreeSimple<String>("G", null, nodeI);
		
		BinaryTreeSimple<String> boom = new BinaryTreeSimple<String>("A", nodeH3, nodeG);
		
		//Oef 5.1: count
//		System.out.println("I: " + boom.count("I"));
//		System.out.println("A: " + boom.count("A"));
//		System.out.println("H: " + boom.count("H"));
//		System.out.println("E: " + boom.count("E"));
//		System.out.println("Q: " + boom.count("Q"));
		
		//Oef 5.2: getNodesAtDistance()
//		for (int i = 0; i < 5; i++)
//		{
//			System.out.println(boom.getNodesAtDistance(i));
//		}
		
		//Oef 5.3 
		// Mystery method is ook countNodes, ik vind mijne mooier
		
		//Oef 5.4
		
		BinaryIntegerTree node8 = new BinaryIntegerTree(8);
		BinaryIntegerTree nodemin3 = new BinaryIntegerTree(-3);
		BinaryIntegerTree nodenogismin1 = new BinaryIntegerTree(-1);
		BinaryIntegerTree node10 = new BinaryIntegerTree(10);
		BinaryIntegerTree nodemin7 = new BinaryIntegerTree(-7);
		
		BinaryIntegerTree node5 = new BinaryIntegerTree(5, node8, nodemin3);
		BinaryIntegerTree nodemin1 = new BinaryIntegerTree(-1, nodenogismin1, null);
		BinaryIntegerTree node0 = new BinaryIntegerTree(0);
		BinaryIntegerTree nodenogis3 = new BinaryIntegerTree(3, node10, nodemin7);
		
		BinaryIntegerTree node4 = new BinaryIntegerTree(4, node5, nodemin1 );
		BinaryIntegerTree node3 = new BinaryIntegerTree(3, node0, nodenogis3);
		
		BinaryIntegerTree intboom = new BinaryIntegerTree(7, node4, node3);
		
		System.out.println(intboom.kinderSom());
	}

}
