package ui;

import domain.BinaryTree;

public class BinaryTreeDriver
{

	public static void main(String[] args)
	{
		BinaryTree<String> nodeC = new BinaryTree<String>("C");
		BinaryTree<String> nodeE = new BinaryTree<String>("E");
		BinaryTree<String> nodeH = new BinaryTree<String>("H");
		
		BinaryTree<String> nodeA = new BinaryTree<String>("A");
		BinaryTree<String> nodeD = new BinaryTree<String>("D", nodeC, nodeE);
		BinaryTree<String> nodeI = new BinaryTree<String>("I", nodeH, null);
		
		BinaryTree<String> nodeB = new BinaryTree<String>("B", nodeA, nodeD);
		BinaryTree<String> nodeG = new BinaryTree<String>("G", null, nodeI);
		
		BinaryTree<String> boom = new BinaryTree<String>("F", nodeB, nodeG);
		
		System.out.println(boom.countNodes());
	}

}
