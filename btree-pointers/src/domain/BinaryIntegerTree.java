package domain;

import domain.BinaryTreeSimple;

public class BinaryIntegerTree extends BinaryTreeSimple<Integer>
{

	public BinaryIntegerTree(int data)
	{
		super(data);
	}
	
	public BinaryIntegerTree(int data, BinaryIntegerTree leftTree, BinaryIntegerTree rightTree)
	{
		super(data, leftTree, rightTree);
	}
	
	public boolean kinderSom()
	{
		// eerste juiste som bepalen (null = 0)
		int som = this.leftTree == null ? 0 : this.leftTree.data;
		som += this.rightTree == null ? 0 : this.rightTree.data;
		
		// als som niet gelijk aan data direct false teruggeven
		if (som != this.data)
		{
			return false;
		}
		else // som is dus wel gelijk aan data
		{
			//als beide kinderen null of leafs zijn zijn we klaar met sommen vergelijken
			boolean ready = this.leftTree == null || this.leftTree.isLeaf();
			ready &= this.rightTree == null || this.rightTree.isLeaf();
			if(ready)
			{
				return true;
			}
			else // Als we nog niet klaar zijn recursief verder naar 'benden' gaan
			{
				return ((BinaryIntegerTree) this.leftTree).kinderSom() && ((BinaryIntegerTree) this.rightTree).kinderSom();
			}
		}
	}

}
