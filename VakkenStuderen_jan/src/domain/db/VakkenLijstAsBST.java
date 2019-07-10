package domain.db;

import java.util.ArrayList;

import domain.model.BinarySearchTree;
import domain.model.Vak;

public class VakkenLijstAsBST {
	private BinarySearchTree<Vak> vakken;
	
	public VakkenLijstAsBST() {
		this.vakken = new BinarySearchTree<Vak>();
	}
	
	public Vak vakMetMinstAantalStudiepunten() {
		return this.vakken.searchSmallest();
	}
	
	public boolean voegVakToe(Vak vak) {
		return this.vakken.addNode(vak);
	}
	
	public Vak verwijderVakMetMinstAantalStudiepunten() {
		Vak kleinste = this.vakken.searchSmallest();
		this.vakken.removeNode(kleinste);
		return kleinste;
	}
	
	public ArrayList<Vak> geefVakken(){
		return vakken.geefVakken();
	}
}
