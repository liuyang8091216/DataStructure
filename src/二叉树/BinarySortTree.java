package ������;

/**
 * 
 * 
 * ����������
 * 
 * @author ������
 *
 *         2017��3��16��
 */
public class BinarySortTree {

	private Node root = null;

	/** ���Ҷ������������Ƿ���keyֵ */
	public boolean searchBST(int key) {
		Node current = root;
		while (current != null) {
			if (key == current.getValue())
				return true;
			else if (key < current.getValue())
				current = current.getLeft();
			else
				current = current.getRight();
		}
		return false;
	}

	
	
	/** ������������в����� */
	public void insertBST(int key) {
		Node p = root;
		/** ��¼���ҽ���ǰһ����� */
		Node prev = null;
		/** һֱ������ȥ��ֱ���������������Ľ��λ�� */
		while (p != null) {
			prev = p;
			if (key < p.getValue())
				p = p.getLeft();
			else if (key > p.getValue())
				p = p.getRight();
			else
				return;
		}
		/** prve��Ҫ���Ž��ĸ��ڵ㣬���ݽ��ֵ�ô�С��������Ӧ��λ�� */
		if (root == null)
			root = new Node(key);
		else if (key < prev.getValue())
			prev.setLeft(new Node(key));
		else
			prev.setRight(new Node(key));
	}

	public static void main(String[] args) {
		BinarySortTree bst = new BinarySortTree();
		/** �����Ķ�����û����ͬԪ�� */
		int[] num = { 4, 7, 2, 1, 10, 6, 9, 3, 8, 11, 2, 0, -2 };
		for (int i = 0; i < num.length; i++) {
			bst.insertBST(num[i]);
		}
		System.out.println(bst.searchBST(10));
	}

	/** �������Ľ�㶨�� */
	public class Node {
		private int value;
		private Node left;
		private Node right;

		public Node() {
		}

		public Node(Node left, Node right, int value) {
			this.left = left;
			this.right = right;
			this.value = value;
		}

		public Node(int value) {
			this(null, null, value);
		}

		public Node getLeft() {
			return this.left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return this.right;
		}

		public void setRight(Node right) {
			this.right = right;
		}

		public int getValue() {
			return this.value;
		}

		public void setValue(int value) {
			this.value = value;
		}
	}

}