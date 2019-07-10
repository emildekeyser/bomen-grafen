package domain.model;

import java.util.ArrayList;

public class BinarySearchTree<E extends Comparable<E>> {
	private E data;
	private BinarySearchTree<E> leftTree, rightTree;

	public BinarySearchTree() {
	}

	private BinarySearchTree(E data) {
		this.data = data;
	}

	public void printInOrder() {
		if (this.data != null) {
			if (leftTree != null)
				leftTree.printInOrder();
			System.out.print(this.data + " ");
			if (rightTree != null)
				rightTree.printInOrder();
		}
	}

	public boolean lookup(E data) {
		if (data == null || this.data == null)
			return false;
		else {
			if (data.compareTo(this.data) == 0)
				return true;
			else if (data.compareTo(this.data) < 0) {
				return (this.leftTree == null ? false : leftTree.lookup(data));
			} else {
				return (this.rightTree == null ? false : rightTree.lookup(data));
			}
		}
	}

	public boolean addNode(E data) {
		if (data == null) {
			throw new IllegalArgumentException("data mag niet null zijn");
		}
		if (this.data == null) {
			this.data = data;
			return true;
		}
		if (data.equals(this.data))
			return false;
		if (data.compareTo(this.data) < 0) {
			if (leftTree != null)
				return this.leftTree.addNode(data);
			else
				this.leftTree = new BinarySearchTree<E>(data);

		} else {
			if (rightTree != null)
				return this.rightTree.addNode(data);
			else
				this.rightTree = new BinarySearchTree<E>(data);
		}
		return true;
	}

	public boolean removeNode(E data) {
		if (data == null)
			return false;
		if (data.compareTo(this.data) == 0) {
			if (this.isLeaf())
				this.data = null;
			else {
				if (leftTree != null) {
					E g = leftTree.searchGreatest();
					this.data = g;
					leftTree.removeNode(g);
				} else {
					E k = rightTree.searchSmallest();
					this.data = k;
					rightTree.removeNode(k);
				}
			}
			removeEmptyLeaves();
			return true;
		} else if (data.compareTo(this.data) < 0) {
			if (leftTree == null)
				return false;
			else
				return leftTree.removeNode(data);
		} else if (data.compareTo(this.data) > 0) {
			if (rightTree == null)
				return false;
			else
				return rightTree.removeNode(data);
		}
		return false;
	}

	public E searchGreatest() {
		if (this == null || this.data == null)
			return null;
		if (this.rightTree == null)
			return this.data;
		return rightTree.searchGreatest();
	}

	public E searchSmallest() {
		if (this == null || this.data == null)
			return null;
		if (this.leftTree == null)
			return this.data;
		return leftTree.searchSmallest();
	}

	public boolean isLeaf() {
		return this.leftTree == null && this.rightTree == null;
	}

	public boolean removeEmptyLeaves() {
		if (!this.isLeaf()) {
			if (this.leftTree != null) {
				if (this.leftTree.data == null) {
					this.leftTree = null;
				} else {
					this.leftTree.removeEmptyLeaves();
				}
			}
			if (this.rightTree != null) {
				if (this.rightTree.data == null) {
					this.rightTree = null;
				} else {
					this.rightTree.removeEmptyLeaves();
				}
			}
		}

		return true;
	}
	
	public ArrayList<E> geefVakken(){
		ArrayList<E> res = new ArrayList<>();
		if (this.data != null) {
			if (leftTree != null)
				res.addAll(leftTree.geefVakken());
			res.add(this.data );
			if (rightTree != null)
				res.addAll(rightTree.geefVakken());
		}
		return res;
	}

}
