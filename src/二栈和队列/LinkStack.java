package 二栈和队列;

public class LinkStack {

	private Element base;
	private Element top;

	class Element {
		public Object data;
		public Element next;
	}

	/**
	 * 初始化栈
	 */
	void initStack() {
		top = new Element();
		base = new Element();
		top.data = null;
		top.next = base;
		base.data = null;
		base.next = null;
	}

	/**
	 * 入栈
	 */
	void push(Object o) {
		Element e = new Element();
		e.data = o;
		if (top.next == base)// 第一次入栈操作
		{
			e.next = base;
			top.next = e;
		} else {
			e.next = top.next;
			top.next = e;
		}

	}

	/**
	 * 出栈
	 */
	void pop() {
		if (top.next == base) {
			System.out.println("栈中没有元素！");
		} else {
			System.out.println("出栈操作" + top.next.data);
			top.next = top.next.next;
		}
	}

	/**
	 * 打印栈
	 */
	void print() {
		System.out.print("打印栈：");
		Element temp = top;
		while (temp.next != base) {
			System.out.print(temp.next.data + "\t");
			temp = temp.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		LinkStack lStack = new LinkStack();
		lStack.initStack();
		// lStack.pop();
		lStack.push(1);
		lStack.push(2);
		lStack.push(3);
		lStack.push(4);
		lStack.print();

		lStack.pop();
		lStack.pop();
		lStack.print();

		/*
		 * lStack.pop(); lStack.pop(); lStack.print(); lStack.pop();
		 */
	}
}
