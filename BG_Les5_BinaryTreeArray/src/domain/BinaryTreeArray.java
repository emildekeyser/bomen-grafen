package domain;

import java.util.ArrayList;
import java.util.Iterator;

public class BinaryTreeArray<E>
{
	private ArrayList<E> knopen;

	public BinaryTreeArray(ArrayList<E> knopen)
	{
		if (!isGeldigeKnopenRij(knopen)) throw new IllegalArgumentException("Niet Geldig");

		this.knopen = knopen;
	}

	/**
	 * gaat na of de gegeven array knopen overeenkomt met een BB gaat dus na
	 * voor elke knoop dat als deze null is er geen
	 * kinderen/kleinkinderen/achterkleinkinderen zijn (deze moet dus ook
	 * allemaal null zijn)
	 * 
	 * @param knopen
	 * @return true indien de gegeven rij een geldige knopen rij is, false
	 *         anders
	 */
	private boolean isGeldigeKnopenRij(ArrayList<E> knopen)
	{
		if (knopen == null || knopen.size() == 0) return false;
		return this.isGeldigeKnopenRij(knopen, 0);
	}
	/**
	 * gaat na of de knoop i in de gegeven array knopen geldig is gaat dus na of
	 * voor de knoop met index i geldt dat als deze null is er geen
	 * kinderen/kleinkinderen/achterkleinkinderen zijn (deze moet dus ook
	 * allemaal null zijn)
	 * 
	 * @param knopen
	 * @return true indien knoop i en zijn nageslacht in de de gegeven rij een
	 *         geldige knoop is, false anders
	 */
	private boolean isGeldigeKnopenRij(ArrayList<E> knopen, int i)
	{
		if (i >= knopen.size()) return true;
		
		boolean ret = true;
		if (knopen.get(i) == null)
		{
			try
			{
				ret = knopen.get(i * 2 + 1) != null;
				ret	&= knopen.get(i * 2 + 2) != null;
			}
			catch (Exception e){}
		}
		
		return ret && this.isGeldigeKnopenRij(knopen, i + 1);
	}

	/**
	 * print de knopen in inOrder uit
	 */
	public void printInOrder()
	{
		this.printInOrder(0);
	}
	/**
	 * print de deelboom met wortel knoop met index i , in inOrder uit
	 * 
	 * @param i
	 */
	public void printInOrder(int i)
	{
		if (i >= 0 && i < this.knopen.size() && this.knopen.get(i) != null)
		{
			this.printInOrder(i * 2 + 1); 
			System.out.println(this.knopen.get(i));
			this.printInOrder(i * 2 + 2); 
		}

	}

	public void printPreOrder()
	{
		this.printPreOrder(0);
	}

	private void printPreOrder(int i)
	{
		if (i >= 0 && i < this.knopen.size() && this.knopen.get(i) != null)
		{
			System.out.println(this.knopen.get(i));
			this.printInOrder(i * 2 + 1); 
			this.printInOrder(i * 2 + 2);
		}

	}

	public void printPostOrder()
	{
		this.printPostOrder(0);
	}

	private void printPostOrder(int i)
	{
		if (i >= 0 && i < this.knopen.size() && this.knopen.get(i) != null)
		{
			this.printInOrder(i * 2 + 1); 
			this.printInOrder(i * 2 + 2);
			System.out.println(this.knopen.get(i));
		}
	}

	public void printBreadthFirst()
	{
		for (E e : this.knopen)
		{
			System.out.println(e);
		}
	}

	public int aantalKnopen()
	{
		int ret = 0;
		for (E e : this.knopen)
		{
			ret += e == null ? 0 : 1;
		}
		return ret;
	}

	public int diepte()
	{
		if(this.knopen.size() <= 0 ) return 0;
		
		int a = 0;
		for (int i = this.knopen.size(); i > 0; i = (i - 1)/2)
		{
			a++;
		}
		
		return a;
	}

	private boolean isLeaf(int i)
	{
		return i * 2 + 1 > this.knopen.size() - 1;
	}
	
	public int aantalBladeren()
	{
		int a = 1;
		for (int i = 0; i < this.knopen.size() - 1; i++)
		{
			a += this.isLeaf(i) ? 1 : 0;
		}
		return a;
	}

	public boolean isComplete()
	{
		return (this.knopen.size() + 1)/2 == Math.pow(2, this.diepte() - 1);
	}

	public BinaryTreeArray<E> maakLinkerBoom()
	{
		if (this.knopen.size() >= 2 && this.knopen.get(1) != null)
		{
			ArrayList<E> res = new ArrayList<>();
			res.add(this.knopen.get(1));
			int k = 2;
			int i = 3;
			while (i < this.knopen.size())
			{
				for (int j = 1; j <= k && i < this.knopen.size(); j++)
				{
					res.add(this.knopen.get(i));
					i++;
				}
				i += k;
				k *= 2;
			}
			return new BinaryTreeArray<>(res);
		}
		else return null;
	}

	public BinaryTreeArray<E> maakRechterBoom()
	{
		if (this.knopen.size() >= 3 && this.knopen.get(1) != null)
		{
			ArrayList<E> res = new ArrayList<>();
			res.add(this.knopen.get(2));
			int k = 2;
			int i = 5;
			while (i < this.knopen.size())
			{
				for (int j = 1; j <= k && i < this.knopen.size(); j++)
				{
					res.add(this.knopen.get(i));
					i++;
				}
				i += k;
				k *= 2;
			}
			return new BinaryTreeArray<>(res);
		}
		else return null;
	}

}
