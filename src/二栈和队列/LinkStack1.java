package 二栈和队列;

/**
 * 
 * 链栈
 * @author 刘阳阳
 *
 * 2017年2月16日
 */
public class LinkStack1 {

	private Element top ;
	private Element base;
	
	
	public static void main(String[] args) {
		LinkStack1 l = new LinkStack1();
		l.initStack();
		l.push("1");
		l.push("0");
		l.push("2");
		l.push("4");
		l.print();
		System.out.println("=======================");
		l.pop();
		l.pop();
		l.print();
	}
	
	void initStack(){
		top = new Element();
		base = new Element();
		top.data = null;
		top.next = base;
		base.data = null;
		base.next = null;
	}
	
	void push(Object ee){
		Element e = new Element();
		e.data = ee;
		
		if(top.next == base){
			e.next = base;
			top.next = e;
		} else{
			e.next = top.next;
			top.next = e;
		}
	}
	
	//出栈
	void pop(){
		if(top.next == base){
			System.out.println("栈中没有元素");
		} else {
			System.out.println("出栈远处为：" + top.next.data);
			top = top.next;
		}
	}
	
	
	void print(){
		
/*		Element temp = top;
		while(temp.next != base){
			System.out.println(temp.next.data);
			temp = temp.next;
		}*/
		
		Element temp = top;
		while(top.next != base){
			System.out.println(top.next.data);
			top = top.next;
		}
		top = temp;
		
		/*Element temp = top;
		while(top.next != base){
			System.out.println(top.next.data);
			top.next = top.next.next;
		}
		top = temp;*/
	}
	
	
	
	class Element{
		Object data;
		Element next;
	}
}
