package ��ջ�Ͷ���;

public class ˳��ջ {

	public static void main(String[] args) {
		Statck s = new Statck();
		s.push(0);
		s.push(0);
		s.push(1);
		s.push(1);
		s.push(1);
		s.push(1);
		s.push(1);
		s.push(1);
		s.erShi();
		/*s.push(0);
		s.push(20);
		s.push(21);*/
		//s.print();
		//s.pop();
		//s.print();	
	}
}

class Statck{
	private int STACK_INIT_SIZE = 10;//ջ��ԭʼ��С
    private int INCREMENT =10;//ջ��������С
	
	
	Object[] data;
	int top;
	int base;
	int statckSize;
	
	public Statck(){
		data = new Object[STACK_INIT_SIZE];
		top = 0;
		base = 0;
		statckSize = 0;
	}
	
	//������ת��Ϊʮ����
	public void erShi(){
		int i=0;
		int sum = 0;
		while(top!=base){
			int tempCheng =1; 
			int a = (int) pop();
			for(int j=0;j<i;j++){
				tempCheng = tempCheng * 2;
			}
			//System.out.println("a" + tempCheng);
			i++;
			sum = sum + a * tempCheng;
			//System.out.println("sum" + sum);
		}
		System.out.println(sum);
	}
	
	//��ջ
	public void push(int element){
		//���ȼ��ջ�Ƿ���ջ
		if(top-base >=STACK_INIT_SIZE ){
			STACK_INIT_SIZE = STACK_INIT_SIZE + INCREMENT;
			System.out.println("ջ��" + "��ջ��СΪ:" + STACK_INIT_SIZE );
			Object[] temp = new Object[STACK_INIT_SIZE];
			for(int i=0;i<data.length;i++){
				temp[i] = data[i];
			}
			data = temp;
		}
		data[top] = element; 
		statckSize++;
		top++;
	}
	
	//��ջ
	public Object pop(){
		Object temp = null ;
		if(top == base){
			System.out.println("ջ��û��Ԫ��");
		} else {
			temp = data[top-1];
			//System.out.println("��ջԪ�أ�" + temp);
			top--;
		}
		return temp;
	}
	
	//����ջ
	public void print(){
		System.out.println("ջ��Ԫ�أ�");
		for(int i=top-1;i>=0;i--){
			System.out.print(data[i] + "->");
		}
	}
}
