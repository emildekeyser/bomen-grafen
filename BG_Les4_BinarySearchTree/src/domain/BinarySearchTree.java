package domain;

public class BinarySearchTree<E extends Comparable<E>>
{
	private E data;
	private BinarySearchTree<E> leftTree, rightTree;

	public BinarySearchTree()
	{
	}

	private BinarySearchTree(E data)
	{
		this.data = data;
	}

	public void printInOrder()
	{
		if (this.data != null)
		{
			if (leftTree != null) leftTree.printInOrder();
			System.out.print(this.data + " ");
			if (rightTree != null) rightTree.printInOrder();
		}
	}

	public boolean lookup(E data)
	{
		if (data == null || this.data == null) return false;
		else
		{
			if (data.compareTo(this.data) == 0) return true;
			else if (data.compareTo(this.data) < 0)
			{
				return (this.leftTree == null ? false : leftTree.lookup(data));
			}
			else
			{
				return (this.rightTree == null
						? false
						: rightTree.lookup(data));
			}
		}
	}

	public boolean addNode(E data)
	{
		if (data == null) return false;
		else if (this.data == null)
		{
			this.data = data;
			return true;
		}
		else if (data.compareTo(this.data) < 0)
		{
			if (this.leftTree == null)
			{
				this.leftTree = new BinarySearchTree<E>(data);
				return true;
			}
			else return this.leftTree.addNode(data);
		}
		else if (data.compareTo(this.data) > 0) 
		{
			if (this.rightTree == null)
			{
				this.rightTree = new BinarySearchTree<E>(data);
				return true;
			}
			else return this.rightTree.addNode(data);
		}
		else return false; //duplicate found (compare == 0)
	}

	public boolean removeNode(E data)
	{
		if(data == null || this.data == null) return false;
		if(data.compareTo(this.data) == 0)
		{
			if (this.isLeaf())
			{
				this.data = null;
				return true;
			}
			else
			{
				if (this.leftTree != null)
				{
					E greatestLeft = this.leftTree.searchGreatest();
					this.data = greatestLeft;
					this.leftTree.removeNode(greatestLeft);
					return true;
				}
				else
				{
					E smallestRight = this.rightTree.searchSmallest();
					this.data = smallestRight;
					this.rightTree.removeNode(smallestRight);
					return true;
				}
			}
		}
		if(data.compareTo(this.data) < 0 )
		{
			if(this.leftTree == null) return false;
			else
			{
				return this.leftTree.removeNode(data);
			}
		}
		else
		{
			if(this.rightTree == null) return false;
			else
			{
				return this.rightTree.removeNode(data);
			}
		}
	}
	
	public void cleanUp()
	{
		if(this.leftTree != null)
		{
			if(this.leftTree.isLeaf() && this.leftTree.data == null) this.leftTree = null;
			else this.leftTree.cleanUp();
		}
		
		if(this.rightTree != null)
		{
			if(this.rightTree.isLeaf() && this.rightTree.data == null) this.rightTree = null;
			else this.rightTree.cleanUp();
		}
	}

	public E searchGreatest()
	{
		if (this.rightTree == null) return this.data;
		else return this.rightTree.searchGreatest();
	}

	public E searchSmallest()
	{
		if (this.leftTree == null) return this.data;
		return this.leftTree.searchSmallest();
	}
	
	public boolean isLeaf()
	{
		return this.rightTree == null && this.leftTree == null;
	}
	
	public String getPath(E data)
	{
		if (data == null) return "no path"; 
		String ret = this.data.toString();
		if(data.compareTo(this.data) == 0) return ret;
		if(data.compareTo(this.data) < 0)
		{
			if(this.leftTree != null) ret += " -> " + this.leftTree.getPath(data);
			return ret;
		}
		if(data.compareTo(this.data) > 0)
		{
			if(this.rightTree != null) ret += " -> " + this.rightTree.getPath(data);
			return ret;
		}
		else return "no path";
	}
	
}
