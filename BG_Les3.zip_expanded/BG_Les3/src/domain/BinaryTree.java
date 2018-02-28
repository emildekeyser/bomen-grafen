package domain;

public class BinaryTree<E>
{
	private E data;
	private BinaryTree<E> leftTree, rightTree;

	public BinaryTree(E data)
	{
		this(data, null, null);
	}

	public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree)
	{
		this.data = data;
		this.leftTree = leftTree;
		this.rightTree = rightTree;
	}

	public void printPreorder()
	{
		System.out.print(this.data + " ");
		if (this.leftTree != null) this.leftTree.printPreorder();
		if (this.rightTree != null) this.rightTree.printPreorder();
	}
	
	public void printInorder()
	{
		if (this.leftTree != null) this.leftTree.printInorder();
		System.out.print(this.data + " ");
		if (this.rightTree != null) this.rightTree.printInorder();
	}
	
	public void printPostorder()
	{
		if (this.leftTree != null) this.leftTree.printPostorder();
		if (this.rightTree != null) this.rightTree.printPostorder();
		System.out.print(this.data + " ");
	}
	
	public int countNodes()
	{
		int nodesLinks = this.leftTree != null ? this.leftTree.countNodes() : 0;
		int nodesRechts = this.rightTree != null ? this.rightTree.countNodes() : 0;
		return 1 + nodesLinks + nodesRechts;
	}
	
	public int depth()
	{
		int rightDepth = this.leftTree != null ? this.leftTree.countNodes() : 0;
		int leftDepth = this.rightTree != null ? this.rightTree.countNodes() : 0;
		return 1 + nodesLinks + nodesRechts;
	}
}

















