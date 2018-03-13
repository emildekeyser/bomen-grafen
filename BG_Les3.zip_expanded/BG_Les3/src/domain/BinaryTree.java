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
		int leftDepth = this.leftTree == null ? 0 : this.leftTree.depth();
		int rightDepth = this.rightTree == null ? 0 : this.rightTree.depth();
		return 1 + Math.max(leftDepth, rightDepth);
	}
	
	public boolean isLeaf()
	{
		return this.rightTree == null && this.leftTree == null;
	}
	
	public int countLeafs()
	{
		if (this.isLeaf()) return 1;
		else
		{
			int leftLeafs = this.leftTree == null ? 0 : this.leftTree.countLeafs();
			int rightLeafs = this.rightTree == null ? 0 : this.rightTree.countLeafs();
			return leftLeafs + rightLeafs;
		}
	}
	
	public void printDataLeafs()
	{
		if (this.isLeaf()) System.out.println(this.data);
		else
		{
			if (this.leftTree != null) this.leftTree.printDataLeafs();
			if (this.rightTree != null) this.rightTree.printDataLeafs();
		}
	}
	
	public boolean contains(E search)
	{
		if (this.data == search) return true;
		else
		{
			boolean leftContains = this.leftTree == null ? false : this.leftTree.contains(search);
			boolean rightContains = this.rightTree == null ? false : this.rightTree.contains(search);
			return leftContains || rightContains;
		}
	}
}
















