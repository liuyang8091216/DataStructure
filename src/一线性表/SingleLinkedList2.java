package һ���Ա�;

public class SingleLinkedList2<T> {
	
	private Link<T> first;//�׽��
	
	public  SingleLinkedList2(){
		this.first = null;
	}
	
	//����
	public void insert(T data){
		//ͷ�巨
//		Link<T> newLink = new Link<T>(data);
//		newLink.next = first;//�½���nextָ����һ���  
//		first = newLink;
		
		
		//����β�巨
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
	
	//������λ�ò���
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
	
	//ɾ��
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
		System.out.println("ɾ�����ַ���" + singleLink.remove(2));
		singleLink.displayList();*/
	}
	
	
	public void displayList() {//����  
        //System.out.println("List (first-->last):");  
        Link<T> current = first;  
        while (current != null) {  
            current.displayLink();  
            current = current.next;
        }  
    }
	
}

/**
 * ģ����
 * @author ������
 *
 * 2017��2��9��
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
