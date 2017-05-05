package ��ջ�Ͷ���;

public class LinkStack {

	private Element base;
	private Element top;

	class Element {
		public Object data;
		public Element next;
	}

	/**
	 * ��ʼ��ջ
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
	 * ��ջ
	 */
	void push(Object o) {
		Element e = new Element();
		e.data = o;
		if (top.next == base)// ��һ����ջ����
		{
			e.next = base;
			top.next = e;
		} else {
			e.next = top.next;
			top.next = e;
		}

	}

	/**
	 * ��ջ
	 */
	void pop() {
		if (top.next == base) {
			System.out.println("ջ��û��Ԫ�أ�");
		} else {
			System.out.println("��ջ����" + top.next.data);
			top.next = top.next.next;
		}
	}

	/**
	 * ��ӡջ
	 */
	void print() {
		System.out.print("��ӡջ��");
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
