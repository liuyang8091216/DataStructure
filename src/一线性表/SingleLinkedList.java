package һ���Ա�;

public class SingleLinkedList<T> {
	
	private Link<T> first;        //�׽��  
    public SingleLinkedList() {  
          
    }  
      
    public boolean isEmpty() {  
        return first == null;  
    }  
      
    public void insertFirst(T data) {// ���� �� ��ͷ  
        Link<T> newLink = new Link<T>(data);  
        newLink.next = first; //�½���nextָ����һ���  
        first = newLink;  
    }  
      
    public Link<T>  deleteFirst() {//ɾ�� ��ͷ  
        Link<T> temp = first;  
        first = first.next; //����׽�㣬Ϊ��һ���  
        return temp;  
    }  
      
    public Link<T> find(T t) {  
        Link<T> find = first;  
        while (find != null) {  
            if (!find.data.equals(t)) {  
                find = find.next;  
            } else {  
                break;  
            }  
        }  
        return find;  
    }  
      
    public Link<T> delete(T t) {  
        if (isEmpty()) {  
            return null;  
        } else {  
            if (first.data.equals(t)) {  
                Link<T> temp = first;  
                first = first.next; //����׽�㣬Ϊ��һ���  
                return temp;  
            }  
        }  
        Link<T> p = first;  
        Link<T> q = first;  
        while (!p.data.equals(t)) {  
            if (p.next == null) {//��ʾ����β��û�ҵ�  
                return null;  
            } else {  
                q = p;  
                p = p.next;  
            }  
        }  
          
        q.next = p.next;  
        return p;  
    }  
      
    public void displayList() {//����  
        System.out.println("List (first-->last):");  
        Link<T> current = first;  
        while (current != null) {  
            current.displayLink();  
            current = current.next;  
        }  
    }  
      
    public void displayListReverse() {//�������  
        Link<T> p = first, q = first.next, t;  
        while (q != null) {//ָ�뷴�򣬱���������˳�����  
            t = q.next; //no3  
            if (p == first) {// ��Ϊԭ����ͷʱ��ͷ��.nextӦ���ÿ�  
                p.next = null;  
            }  
            q.next = p;// no3 -> no1  pointer reverse  
            p = q; //start is reverse  
            q = t; //no3 start  
        }  
        //����ѭ���е�if���first.next �ÿ���, ����qΪnull��ִ��ѭ��ʱ��p��Ϊԭ��������һ���������ת���p����first  
        first = p;   
        displayList();  
    }  
      
    class Link<T> {//�����  
        T data;     //������  
        Link<T> next; //���ָ�룬���       ����  
        Link(T data) {  
            this.data = data;  
        }  
        void displayLink() {  
            System.out.println("the data is " + data.toString());  
        }  
    }  
      
    public static void main(String[] args) {  
        SingleLinkedList<Integer> list = new SingleLinkedList<Integer>();  
        list.insertFirst(33);  
        list.insertFirst(78);  
        list.insertFirst(24);  
        list.insertFirst(22);  
        list.insertFirst(56);  
        list.displayList();  
          
        //list.deleteFirst();  
       // list.displayList();  
          
        /*System.out.println("find:" + list.find(56));  
        System.out.println("find:" + list.find(33));  
          
        System.out.println("delete find:" + list.delete(99));  
        System.out.println("delete find:" + list.delete(24));  
        list.displayList();  
        System.out.println("----reverse----");  
        list.displayListReverse();  */
    }  
}  
