package һ���Ա�;

/*
 * ����Լɪ������~~~
 * =============================
 * ѭ������
 * =============================
 * �������ǻ�Ȼ���ʵ�һ�δ��� ��ֵ���ٴλع�
 * =============================
 * ����ѭ�������γ�Լɪ��
 */
public class Main
{
	
	
    public static void main(String[] args)
    {
        int N=41;//�����ʾ������
        int M=3;//���������˳���
        Node t=new Node(1);//ͷ�ڵ㵥�г����������γ�ѭ������
        Node x=t;

        for(int i=2;i<=N;i++){
        	Node temp = new Node(i);
        	x.next=temp;
        	x = x.next;  //ʼ��ָ��ǰ���
        	//x=(x.next=temp);//������������
        }
        x.next=t;//���һ���ڵ��nextָ���һ���ڵ㣬�γ�ѭ������

        System.out.println("��Ȧ��˳��Ϊ��");
        while(x!=x.next){
            for(int i=1;i<M;i++){
            	x=x.next;  //��ʱx�ǽ����еĽڵ��ǰһ���ڵ�
            }
            System.out.print(x.next.getValue()+" ");
            x.next=x.next.next;
        }
        System.out.println();
        System.out.println("Survivors is "+x.getValue());  
}
}

// ������
class Node {
	Object value; // �ڵ�����
	Node next; // ��������ָ����һ���ڵ�

	public Node(Object v) {
		this.value = v;
	}

	public void setValue(Object v) {
		this.value = v;
	}

	public Object getValue() {
		return this.value;
	}

	public void setNext(Node node) {
		this.next = node;
	}

	public Node getNex() {
		return next;
	}
}

