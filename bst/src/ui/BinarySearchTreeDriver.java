package ui;

import domain.BinarySearchTree;

public class BinarySearchTreeDriver {

	public static void main(String[] args) {
		BinarySearchTree<Integer> boom = new BinarySearchTree<>();		
		boom.addNode(5);
		boom.addNode(4);
		boom.addNode(3);
		boom.addNode(8);
		boom.addNode(7);
		boom.addNode(10);
		System.out.println(boom.getPath(7));
		System.out.println(boom.getPath(4));
		System.out.println(boom.getPath(8));
		boom.printInOrder();
	}

}
