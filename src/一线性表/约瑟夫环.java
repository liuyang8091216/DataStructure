package һ���Ա�;

/**
 * ѭ������
 * @author ������
 *
 * 2017��2��16��
 */
public class Լɪ�� {

	private static Linkd first = new Linkd();
	static int n = 41;
	static int m = 3;
	
	//��ʼ��
	static void init(int n){
		first.data = 1;
		int i=2;
		
		Linkd p = first;
		Linkd s = null;  
		while(i <=n){
			s = new Linkd();  //�½�һ�����
			s.data = i;			//���ý���ֵ
			s.next = first;		// �ؼ�һ��  ���½ڵ��next����Ϊfirst�׽��
			i++;
			
			p.next = s;  //���½ڵ㸴�Ƹ�p����һ�����
			p = s;    //p������ǵ�ǰ���

		}
	}
	
	//����
	static void bianli(){
		Linkd p = first;
		while(p.next != first){
		//while(first.next != first){
			System.out.print(p.data + " ");
			p = p.next;
		}
		System.out.println(p.data);
	}
	
	//ִ��
	static void dealWith(){
		Linkd p = first;
		Linkd temp;
		m = n % m;  //m=2
		while(p != p.next){
			for(int i=1;i<=m-1;i++){
				p = p.next;  //��ǰΪ�ڶ������
			}
			System.out.print(p.next.data + " ");  //�������������ֵ
			temp = p.next;  //temp������ǵ��������
			p.next = temp.next;  //�ڶ������ָ����ĸ����
			
			p = p.next;  //���������
		}
		System.out.print(p.data);
	}
	
	public static void main(String[] args){
		init(n);
		//bianli();
		dealWith();
		
	}	
}

class Linkd{
	Object data;
	Linkd next;
}
