package domain;

import java.util.ArrayList;
import java.util.Arrays;

public class Main
{
	public static void main(String[] args)
	{
//		ArrayList<Integer> a = new ArrayList<>(Arrays.asList(3,2,5,1,4,null,6));
//		ArrayList<String> b = new ArrayList<>(Arrays.asList("F",null,"A","B",null,"C","D"));
//		ArrayList<String> c = new ArrayList<>(Arrays.asList("F","A","B",null,"C","D","E","F",null));
//		
//		try{System.out.println(new BinaryTree<>(a));}
//		catch (Exception e){System.out.println(e);}
//		
//		try{System.out.println(new BinaryTree<>(b));}
//		catch (Exception e){System.out.println(e);}
//		
//		try{System.out.println(new BinaryTree<>(c));}
//		catch (Exception e){System.out.println(e);}
		
		ArrayList<String> data = new ArrayList<>(Arrays.asList("D","B","F","A","C","E","G"));
		BinaryTreeArray<String> dasboom = new BinaryTreeArray<>(data);
//		dasboom.printInOrder(2);
		
//		ArrayList<Integer> depthtest = new ArrayList();
//		for (int i = 0; i < 50; i++)
//		{
//			depthtest.add(i);
//			System.out.println(i + " ==> " + new BinaryTree<Integer>(depthtest).diepte());
//		}
		
//		System.out.println(dasboom.aantalBladeren());
//		System.out.println(dasboom.isComplete());
		
		System.out.println("Linker:");
		dasboom.maakLinkerBoom().printInOrder();
		
		System.out.println("Rechter:");
		dasboom.maakRechterBoom().printInOrder();
	}
}
