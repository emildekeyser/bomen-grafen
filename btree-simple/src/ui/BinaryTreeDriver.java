package ui;

import domain.BinaryTreeSimple;

public class BinaryTreeDriver
{

	public static void main(String[] args)
	{
		BinaryTreeSimple<Integer> node6 = new BinaryTreeSimple<Integer>(6);
		
		BinaryTreeSimple<Integer> node2 = new BinaryTreeSimple<Integer>(2, node6, null);
		BinaryTreeSimple<Integer> node3 = new BinaryTreeSimple<Integer>(3);
		
		BinaryTreeSimple<Integer> node7 = new BinaryTreeSimple<Integer>(7);
		BinaryTreeSimple<Integer> node9 = new BinaryTreeSimple<Integer>(9);
		
		BinaryTreeSimple<Integer> nodem7 = new BinaryTreeSimple<Integer>(-7, node3, node2);
		BinaryTreeSimple<Integer> nodem4 = new BinaryTreeSimple<Integer>(-4, node9, node7);
		
		BinaryTreeSimple<Integer> boom = new BinaryTreeSimple<Integer>(5, nodem4, nodem7);
		
		System.out.println("volledige binaire boom -> " + boom.isStrikt());
		System.out.println("binaire boom enkel node 9 -> " + node9.isStrikt());
		System.out.println("binaire boom node -4 met kinderen 9 en 7 -> " + nodem4.isStrikt());
		
		
		
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
		
//		BinaryTreeSimple<int> nodeE1 = new BinaryTreeSimple<int>("E");
//		BinaryTreeSimple<int> nodeE2 = new BinaryTreeSimple<int>("E");
//		
//		BinaryTreeSimple<int> nodeC = new BinaryTreeSimple<int>("C", null, nodeE1);
//		BinaryTreeSimple<int> nodeE3 = new BinaryTreeSimple<int>("E");
//		BinaryTreeSimple<int> nodeH1 = new BinaryTreeSimple<int>("H", null, nodeE2);
//		BinaryTreeSimple<int> nodeE4 = new BinaryTreeSimple<int>("E");
//		
//		BinaryTreeSimple<int> nodeA = new BinaryTreeSimple<int>("A");
//		BinaryTreeSimple<int> nodeH2 = new BinaryTreeSimple<int>("H", nodeC, nodeE3);
//		BinaryTreeSimple<int> nodeI = new BinaryTreeSimple<int>("I", nodeH1, nodeE4);
//		
//		BinaryTreeSimple<int> nodeH3 = new BinaryTreeSimple<int>("H", nodeA, nodeH2);
//		BinaryTreeSimple<int> nodeG = new BinaryTreeSimple<int>("G", null, nodeI);
//		
//		BinaryTreeSimple<int> boom = new BinaryTreeSimple<int>("A", nodeH3, nodeG);
		
		
//		
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
//		
//		BinaryIntegerTree node8 = new BinaryIntegerTree(8);
//		BinaryIntegerTree nodemin3 = new BinaryIntegerTree(-3);
//		BinaryIntegerTree nodenogismin1 = new BinaryIntegerTree(-1);
//		BinaryIntegerTree node10 = new BinaryIntegerTree(10);
//		BinaryIntegerTree nodemin7 = new BinaryIntegerTree(-7);
//		
//		BinaryIntegerTree node5 = new BinaryIntegerTree(5, node8, nodemin3);
//		BinaryIntegerTree nodemin1 = new BinaryIntegerTree(-1, nodenogismin1, null);
//		BinaryIntegerTree node0 = new BinaryIntegerTree(0);
//		BinaryIntegerTree nodenogis3 = new BinaryIntegerTree(3, node10, nodemin7);
//		
//		BinaryIntegerTree node4 = new BinaryIntegerTree(4, node5, nodemin1 );
//		BinaryIntegerTree node3 = new BinaryIntegerTree(3, node0, nodenogis3);
//		
//		BinaryIntegerTree intboom = new BinaryIntegerTree(7, node4, node3);
//		
//		System.out.println(intboom.kinderSom());
	}

}
