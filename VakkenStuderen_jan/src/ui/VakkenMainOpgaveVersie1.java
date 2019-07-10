package ui;

import java.util.ArrayList;
import java.util.Collections;

import domain.db.VakkenLijstAsHeap;
import domain.model.Vak;

public class VakkenMainOpgaveVersie1 {

	public static void main(String[] args) {
		Vak bop = new Vak("BOP",5);
		Vak oop = new Vak("OOP",6);
		Vak algo = new Vak("Algo",3);
		Vak web1 = new Vak("Web1",4);
		Vak web2 = new Vak("Web2",3);
		Vak pd = new Vak("Probleemoplossend Denken", 3);

		VakkenLijstAsHeap mijnVakken = new VakkenLijstAsHeap();
		mijnVakken.voegVakToe(bop);
		mijnVakken.voegVakToe(oop);
		mijnVakken.voegVakToe(algo);
		mijnVakken.voegVakToe(web1);
		mijnVakken.voegVakToe(web2);
		mijnVakken.voegVakToe(pd);
		
		
		System.out.println("Dit vak moet je eerst studeren: "+ mijnVakken.verwijderVakMetMinstAantalStudiepunten());
		System.out.println("Dit vak moet je nu studeren: "+ mijnVakken.verwijderVakMetMinstAantalStudiepunten());
		mijnVakken.voegVakToe(new Vak("Computersystemen",3));
		ArrayList<Vak> vakken = mijnVakken.geefVakken();
		Collections.sort(vakken);
		System.out.println("Vak met meest aantal studiepunten " + vakken.get(vakken.size()-1));
		System.out.println("Deze vakken moet ik nog allemaal studeren: ");
		for (Vak v: vakken) {
			System.out.println(v);
		}
		
	}

}
