package 二叉树;

/**
 * 
 * 
 * 二叉排序树
 * 
 * @author 刘阳阳
 *
 *         2017年3月16日
 */
public class BinarySortTree {

	private Node root = null;

	/** 查找二叉排序树中是否有key值 */
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

	
	
	/** 向二叉排序树中插入结点 */
	public void insertBST(int key) {
		Node p = root;
		/** 记录查找结点的前一个结点 */
		Node prev = null;
		/** 一直查找下去，直到到达满足条件的结点位置 */
		while (p != null) {
			prev = p;
			if (key < p.getValue())
				p = p.getLeft();
			else if (key > p.getValue())
				p = p.getRight();
			else
				return;
		}
		/** prve是要安放结点的父节点，根据结点值得大小，放在相应的位置 */
		if (root == null)
			root = new Node(key);
		else if (key < prev.getValue())
			prev.setLeft(new Node(key));
		else
			prev.setRight(new Node(key));
	}

	public static void main(String[] args) {
		BinarySortTree bst = new BinarySortTree();
		/** 构建的二叉树没有相同元素 */
		int[] num = { 4, 7, 2, 1, 10, 6, 9, 3, 8, 11, 2, 0, -2 };
		for (int i = 0; i < num.length; i++) {
			bst.insertBST(num[i]);
		}
		System.out.println(bst.searchBST(10));
	}

	/** 二叉树的结点定义 */
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