package 一线性表;

/**
 * 循环链表
 * @author 刘阳阳
 *
 * 2017年2月16日
 */
public class 约瑟夫环 {

	private static Linkd first = new Linkd();
	static int n = 41;
	static int m = 3;
	
	//初始化
	static void init(int n){
		first.data = 1;
		int i=2;
		
		Linkd p = first;
		Linkd s = null;  
		while(i <=n){
			s = new Linkd();  //新建一个结点
			s.data = i;			//设置结点得值
			s.next = first;		// 关键一步  把新节点得next设置为first首结点
			i++;
			
			p.next = s;  //把新节点复制给p的下一个结点
			p = s;    //p保存的是当前结点

		}
	}
	
	//遍历
	static void bianli(){
		Linkd p = first;
		while(p.next != first){
		//while(first.next != first){
			System.out.print(p.data + " ");
			p = p.next;
		}
		System.out.println(p.data);
	}
	
	//执行
	static void dealWith(){
		Linkd p = first;
		Linkd temp;
		m = n % m;  //m=2
		while(p != p.next){
			for(int i=1;i<=m-1;i++){
				p = p.next;  //当前为第二个结点
			}
			System.out.print(p.next.data + " ");  //输出第三个结点的值
			temp = p.next;  //temp保存的是第三个结点
			p.next = temp.next;  //第二个结点指向第四个结点
			
			p = p.next;  //第三个结点
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
