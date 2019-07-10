package domain.db;

import java.util.ArrayList;

import domain.model.BinaryMinHeap;
import domain.model.Vak;

public class VakkenLijstAsHeap {
	private BinaryMinHeap<Vak> vakken;
	
	public VakkenLijstAsHeap() {
		this.vakken = new BinaryMinHeap<>();
	}
	
	public Vak vakMetMinstAantalStudiepunten() {
		return this.vakken.getMin();
	}
	
	public boolean voegVakToe(Vak vak) {
		return this.vakken.addValue(vak);
	}
	
	public Vak verwijderVakMetMinstAantalStudiepunten() {
		return this.vakken.removeSmallest();
	}
	
	public ArrayList<Vak> geefVakken(){
		return vakken.getValues();
	}
}
