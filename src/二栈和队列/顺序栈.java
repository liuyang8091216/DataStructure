package 二栈和队列;

public class 顺序栈 {

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
	private int STACK_INIT_SIZE = 10;//栈的原始大小
    private int INCREMENT =10;//栈的增量大小
	
	
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
	
	//二进制转化为十进制
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
	
	//入栈
	public void push(int element){
		//首先检查栈是否满栈
		if(top-base >=STACK_INIT_SIZE ){
			STACK_INIT_SIZE = STACK_INIT_SIZE + INCREMENT;
			System.out.println("栈满" + "新栈大小为:" + STACK_INIT_SIZE );
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
	
	//出栈
	public Object pop(){
		Object temp = null ;
		if(top == base){
			System.out.println("栈中没有元素");
		} else {
			temp = data[top-1];
			//System.out.println("出栈元素：" + temp);
			top--;
		}
		return temp;
	}
	
	//遍历栈
	public void print(){
		System.out.println("栈中元素：");
		for(int i=top-1;i>=0;i--){
			System.out.print(data[i] + "->");
		}
	}
}
