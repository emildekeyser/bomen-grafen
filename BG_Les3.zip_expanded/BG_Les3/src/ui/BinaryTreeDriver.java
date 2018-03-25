package ui;

import domain.BinaryTree;

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
		
		BinaryTree<String> nodeE1 = new BinaryTree<String>("E");
		BinaryTree<String> nodeE2 = new BinaryTree<String>("E");
		
		BinaryTree<String> nodeC = new BinaryTree<String>("C", null, nodeE1);
		BinaryTree<String> nodeE3 = new BinaryTree<String>("E");
		BinaryTree<String> nodeH1 = new BinaryTree<String>("H", null, nodeE2);
		BinaryTree<String> nodeE4 = new BinaryTree<String>("E");
		
		BinaryTree<String> nodeA = new BinaryTree<String>("A");
		BinaryTree<String> nodeH2 = new BinaryTree<String>("H", nodeC, nodeE3);
		BinaryTree<String> nodeI = new BinaryTree<String>("I", nodeH1, nodeE4);
		
		BinaryTree<String> nodeH3 = new BinaryTree<String>("H", nodeA, nodeH2);
		BinaryTree<String> nodeG = new BinaryTree<String>("G", null, nodeI);
		
		BinaryTree<String> boom = new BinaryTree<String>("A", nodeH3, nodeG);
		
		System.out.println("I: " + boom.count("I"));
		System.out.println("A: " + boom.count("A"));
		System.out.println("H: " + boom.count("H"));
		System.out.println("E: " + boom.count("E"));
		System.out.println("Q: " + boom.count("Q"));
	}

}
