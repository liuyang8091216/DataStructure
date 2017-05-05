package 一线性表;

public class SingleLinkedList2<T> {
	
	private Link<T> first;//首结点
	
	public  SingleLinkedList2(){
		this.first = null;
	}
	
	//插入
	public void insert(T data){
		//头插法
//		Link<T> newLink = new Link<T>(data);
//		newLink.next = first;//新结点的next指向上一结点  
//		first = newLink;
		
		
		//以下尾插法
		Link<T> newLink = new Link<T>(data);
		Link<T> temp = first;
		if(temp == null){
			//System.out.println("aa");
			newLink.next = temp;
			temp = newLink;
			first = newLink;
		} else {
			while(temp.next!=null){
				temp = temp.next;
			}
			temp.next = newLink;
			//newLink = temp;
		}
		
		
		/*Link<T> newLink = new Link<T>(data);
		Link<T> temp = first;
		if(temp == null){
			//System.out.println("aa");
			newLink.next = temp;
			temp = newLink;
			first = newLink;
		} else {
			while(temp.next!=null){
				temp = temp.next;
			}
			temp.next = newLink;
			//newLink = temp;
		}*/
	}
	
	//在任意位置插入
	public void add(int i, T data){
		Link<T> dat = new Link<T>(data);
		Link<T> temp = (Link<T>) first;
		int j = 1;
		while(j<i){
			temp = temp.next;
			j++;
		}
		if(temp == null || j>i){
			return;
		}
		dat.next = temp.next;
		temp.next = dat;
	}
	
	//删除
	public Object remove(int i){
		Link<T> temp = first;
		Object returnn;
		int j=1;
		while(j<i){
			temp = temp.next;
			j++;
		}
		if(temp.next == null || j>i){
			return false;
		}
		returnn = temp.next.data;
		temp.next = temp.next.next;
		return returnn;
	}
	
	public static void main(String[] args) {
		SingleLinkedList2<Object> singleLink = new SingleLinkedList2<Object>();
		singleLink.insert("22");
		singleLink.insert("23");
		singleLink.insert("24");
		singleLink.insert("25");
		singleLink.insert("26");
		singleLink.insert("27");
		singleLink.displayList();
		/*System.out.println();
		singleLink.add(3, "888");
		singleLink.displayList();
		System.out.println();
		System.out.println("删除的字符：" + singleLink.remove(2));
		singleLink.displayList();*/
	}
	
	
	public void displayList() {//遍历  
        //System.out.println("List (first-->last):");  
        Link<T> current = first;  
        while (current != null) {  
            current.displayLink();  
            current = current.next;
        }  
    }
	
}

/**
 * 模拟结点
 * @author 刘阳阳
 *
 * 2017年2月9日
 */
class Link<T>{
	T data;
	Link<T> next;
	
	Link(T data){
		this.data = data; 
	}
	
	void displayLink(){
		System.out.print(data+"->");
	}
}
