package domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryMinHeap<E extends Comparable<E>> implements Iterable<E>
{
	private ArrayList<E> values = new ArrayList<>();

	public void print()
	{
		System.out.println(values);
	}

	public E getMin()
	{
		if (this.values.isEmpty())
		{
			throw new IllegalStateException();
		}
		else
		{
			return this.values.get(0);
		}
	}
	
	public E getMax()
	{
		if (this.values.isEmpty())
		{
			throw new IllegalStateException();
		}
		else
		{
			int a = this.values.size()-1;
			double lastLevel = Math.log(a) / Math.log(2);
			lastLevel = Math.floor(lastLevel);
			E highest = this.values.get((int) lastLevel);
			
			for (int i = (int)lastLevel+1; i < this.values.size(); i++)
			{
				if (this.values.get(i).compareTo(highest) > 0)
				{
					highest = this.values.get(i);
				}
			}
			
			return highest;
		}
	}
	
	public boolean addValue(E value)
	{
		if (value == null) throw new IllegalArgumentException();
		values.add(value); // achteraan toevoegen
		if (this.values.size() > 1)
		{
			this.bubbleUp(); // bubbleUp vanaf de laatste zie slides theorie
		}
		return true;
	}

	private void bubbleUp()
	{
		boolean ready = false;
		int child = this.values.size() - 1;
		int parent;
		
		while(!ready)
		{
			if(child % 2 == 0) //even dus rechter kind (wanterig root0 + kind1 => klein boompje kind1 is links, kind2 zou rechts zijn)
			{
				parent = (child - 2)/2;  // komt van 2*ouder-2 = rechter kind
			}
			else // oneven linker kind
			{
				parent = (child - 1)/2; // komt van 2*ouder-1 = linker kind
			}
			
			if (this.values.get(child).compareTo(this.values.get(parent)) < 0)
			{
				E temp = this.values.get(child);
				this.values.set(child, this.values.get(parent));
				this.values.set(parent, temp);
				child = parent;
				
				ready = (child == 0); // we zijn helemaal boven.
			}
			else // of we kunnen niet meer omhoog
			{
				ready = true;
			}	
		}
	}

	public E removeSmallest()
	{
		if (this.values.size() < 1)
		{
			throw new IllegalStateException();
		}
		else if(this.values.size() == 1)
		{
			E temp = this.getMin();
			this.values.remove(0);
			return temp ;
		}
//		else if(this.values.size() == 2)
//		{
//			E temp = this.getMin();
//			this.values.set(0, this.values.get(1));
//			this.values.remove(1); 
//			return temp;
//		}
		else
		{
			E temp = this.getMin();// res bevat de kleinste = eerste element van de lijst
			this.values.set(0, this.values.get(this.values.size() - 1));// verwissel eerste met de laatste
			this.values.remove(this.values.size() - 1); // verwijder de laatste
			this.bubbleDown(); // bubble down van eerste naar beneden zie theorie
			return temp;
		}
		
	}
	
	private void bubbleDown()
	{
		boolean ready = false;
		int parent = 0;
		int childleft;
		int childright;
		E valueleft;
		E valueright;
		E valueparent;
		
		while(!ready)
		{
			childleft = 2 * parent + 1;
			childright = 2 * parent + 2;
			
			valueright = childright < this.values.size() ? this.values.get(childright) : null; 
			valueleft = childleft < this.values.size() ? this.values.get(childleft) : null;
			valueparent = this.values.get(parent);
			
			if(valueleft == null)
			{
				ready = true;
			}
			else if(valueright == null)
			{
				if(valueleft.compareTo(valueparent) < 0)
				{
					this.values.set(childleft, valueparent);
					this.values.set(parent, valueleft);
				}
				else
				{
					ready = true;
				}
			}
			else
			{
				if (valueparent.compareTo(valueleft) > 0 || valueparent.compareTo(valueright) > 0)
				{
					if(valueleft.compareTo(valueright) <= 0)
					{
						this.values.set(childleft, valueparent);
						this.values.set(parent, valueleft);
						parent = childleft;
					}
					else
					{
						this.values.set(childright, valueparent);
						this.values.set(parent, valueright);
						parent = childright;
					}
					
					ready = (parent >= this.values.size() - 1);
				}
				else
				{
					ready = true;
				}
			}
			
		}
	}

	public LinkedList<E> getPath(E value)
	{
		if(!this.values.contains(value))
		{
			return null;
		}
		else
		{
			LinkedList<E> ret = new LinkedList<>();
			int index = this.values.indexOf(value);
			while(index >= 0)
			{
				ret.addFirst(this.values.get(index));
				if(index % 2 == 0)
				{
					index = (index - 2)/2; 
				}
				else
				{
					index = (index - 1)/2;
				}
			}
			
			return ret;
		}
	}
	
	public boolean isEmpty()
	{
		return this.values.isEmpty();
	}

	@Override
	public Iterator<E> iterator()
	{
		return this.values.iterator();
	}

	
}
