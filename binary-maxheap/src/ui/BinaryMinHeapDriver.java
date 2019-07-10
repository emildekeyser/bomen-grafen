package ui;

import domain.BinaryMaxHeap;

public class BinaryMinHeapDriver {

	public static void main(String[] args) {
		BinaryMaxHeap<Integer> heap = new BinaryMaxHeap<>();
		heap.addValue(3);
		heap.addValue(2);
		heap.addValue(1);
		heap.addValue(0);
		heap.addValue(-1);
		heap.addValue(-2);
		heap.addValue(-4);
		heap.addValue(2);
		heap.addValue(-7);
		heap.print();
		System.out.println();
		System.out.println("Kleinste waarde = " + heap.getMin());
		System.out.println("Grootste waarde = " + heap.getMax());
		System.out.println();
		
		for (int i = 1 ; i <= 5; i++){
			System.out.println(heap.removeLargest());
			heap.print();
		}
		System.out.println();
		
		System.out.println(heap.getPath(-1));
		System.out.println(heap.getPath(-4));
		System.out.println(heap.getPath(-7));
	}

}
