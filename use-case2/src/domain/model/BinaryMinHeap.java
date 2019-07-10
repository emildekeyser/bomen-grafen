package domain.model;

import java.util.ArrayList;

public class BinaryMinHeap<E extends Comparable<E>> {
	private ArrayList<E> values = new ArrayList<>();
	
	public BinaryMinHeap(){
		
	}
	
	public E getMin(){
		if (this.values.size() == 0) throw new IllegalStateException();
		return this.values.get(0);
	}
	
	public boolean addValue(E value){
		if (value == null) throw new IllegalArgumentException();
		values.add(value);//achteraan toevoegen
		this.bubbleUp();//bubbleUp vanaf de laatste zie theorie
		return true;
	}
	/**
	 * Geeft de kleinste waarde van de heap terug en verwijdert deze uit de heap
	 * @return de kleinste waarde van de heap
	 */
	public E removeSmallest(){
			E res = this.values.get(0);// res bevat de kleinste = eerste element van de lijst
			this.values.set(0, this.values.get(this.values.size()-1));// verwissel eerste met de laatste
			this.values.remove(this.values.size()-1); // verwijder de laatste
			this.bubbleDown(); // bubble down van eerste naar beneden zie theorie
			return res;
	}

	private void bubbleDown() {
		int i = 0;
		int iChild1= i*2 + 1;
		boolean ok = true;
		
		while (ok && iChild1 < this.values.size()){
			// zoek index van de kleinste van 2 kinderen van i
			int iKL = iChild1;
			int iChild2= iChild1+1;
			if (iChild2 < this.values.size()) {
				if (this.values.get(iChild2).compareTo(this.values.get(iChild1)) < 0){
					iKL = iChild2;
				}
			}
			
			if (this.values.get(i).compareTo(this.values.get(iKL)) < 0 ){
				ok= false; //genoeg gebubbled
			}
			else{
				// verwissel de ide net de iKL-de
				E hulp = this.values.get(i);
				this.values.set(i, this.values.get(iKL));
				this.values.set(iKL, hulp);
				
				//bubbledown vanaf iKL
				i= iKL;
				iChild1= i*2 + 1;
			}
		}
		
	}

	private void bubbleUp() {
		int i = this.values.size() - 1; // index laatste
		int iParent = (i - 1)/ 2; // index van parent van ide
		while (iParent >= 0 && this.values.get(iParent).compareTo(this.values.get(i)) > 0){
			// verwissel de ide met zijn parent
			E hulp = this.values.get(i);
			this.values.set(i,this.values.get(iParent));
			this.values.set(iParent,hulp);
			
			i = iParent;
			iParent= (i-1)/2;
		}
	}
	
	public void print(){
		System.out.println(this.values);
	}
	
	/** pad van kleinste naar naar
	 * 
	 * @param naar
	 * @return
	 */
	public ArrayList<E> getPath(int i, E naar){
		ArrayList<E> res = new ArrayList<>();
		if (i>= 0  && i < this.values.size() &&  this.values.contains(naar)) {
			res.add(this.values.get(i));
			if (this.values.get(i).equals(naar)) return res;
			else {
					ArrayList<E> p = this.getPath(2*i+1, naar);
					if (p!=null) {res.addAll(p); return res;} 
					else {
						p = this.getPath(2*i+2, naar);
						if (p!=null){res.addAll(p); return res;}
						else return null;
					}
				}
			}
		return null;
	
	}
	
	public ArrayList<E> getValues(){
		return this.values;
	}
	
	public ArrayList<E> getPath(E naar){
		return this.getPath(0,naar);
	}
}
	
