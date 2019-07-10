package ui;

import domain.BinaryMinHeap;
import domain.BinarySearchTree;
import domain.model.Vak;

public class VakkenMain {

	public static void main(String[] args) {
		Vak bop = new Vak("BOP",5);
		Vak oop = new Vak("OOP",6);
		Vak algo = new Vak("Algo",3);
		Vak web1 = new Vak("Web1",4);
		Vak web2 = new Vak("Web2",3);
		Vak pd = new Vak("Probleemoplossend Denken", 3);
		
		BinaryMinHeap<Vak> db = new BinaryMinHeap<>();
		db.addValue(bop);
		db.addValue(oop);
		db.addValue(algo);
		db.addValue(web1);
		db.addValue(web2);
		db.addValue(pd);
		
		System.out.println("Dit vak moet je eerst studeren: " + db.getMin());
		db.removeSmallest();
		System.out.println("Dit vak moet je nu studeren: " + db.getMin());
		db.addValue(new Vak("CompŜys", 3));
		System.out.println("Deze vakken moet ik nog allemaal studeren:");
		db.print();
		System.out.println("Nog te doen stijgend:");
		BinarySearchTree <Vak> dbst = new BinarySearchTree<>();
		for (Vak vak : db)
		{
			dbst.addNode(vak);	
		}
		dbst.printInOrder("* ", "\n");
		
		dbst = new BinarySearchTree<>();
		dbst.addNode(bop);
		dbst.addNode(oop);
		dbst.addNode(algo);
		dbst.addNode(web1);
		dbst.addNode(web2);
		dbst.addNode(pd);
		
		System.out.println(dbst.searchSmallest());
		System.out.println(dbst.searchGreatest());
		
	}

}
