package 一线性表;

/**
 * 线性表顺序存储结构
 * @author 刘阳阳
 *
 * 2017年2月8日
 */
public class ShunXuCunChu {
	
	
	public static void main(String[] args) {
		SqlList sqlList = new SqlList();
		Object e = null;
		//1、初始化
		sqlList.initList(sqlList);
		//打印
		sqlList.mPrint(sqlList);
		//2、getElem
		System.out.println("获取元素" + sqlList.getElem(sqlList, 6, e));
		System.out.println("==========================================");
		//3、插入
		sqlList.listInsert(sqlList, 11, "a");
		sqlList.mPrint(sqlList);
		System.out.println(sqlList.data[9]);
		//4、删除
		sqlList.listDelete(sqlList, 5);
		sqlList.mPrint(sqlList);

		
		

	}
	
}

class SqlList{
	
	private final int MAXSIZE = 50;
	
	Object[] data;
	int length;
	
	void mPrint(SqlList L){
		for(int i=0;i<L.data.length;i++){
			Object temp = L.data[i];
			if(temp == null){
				break;
			}
			System.out.print(temp + " ");
		}
		System.out.println();
		System.out.println("num:" + L.length);
		System.out.println("==========================================");
	}
	


	public void initList(SqlList sqlList) {
		sqlList.data = new Object[MAXSIZE];
		for(int i=0;i<10;i++){
			sqlList.data[i] = i + 1;
		}
		sqlList.length = 10;
	}
	
	public Object getElem(SqlList L, int i, Object e){
		if(L.length == 0 || i < 1 || i > L.length){
			return false;
		}
		e = L.data[i-1];
		return e;
	}
	
	public void listInsert(SqlList L, int i, Object e){
		//线性表是否满了
		if(L.length == L.data.length){
			System.out.println("线性表已满！");
			return;
		}
		//检查插入的位置是否合法
		if(i<1 || i>L.length + 1){
			System.out.println("插入位置不合法！");
			return;
		}
		//如果插入的位置不是表尾部
		if(i<=L.length){
			for(int j=L.length-1;j>=i-1;j--){
				L.data[j+1] = L.data[j]; 
			}
		}
		L.data[i-1] = e;
		L.length = L.length + 1;
	}
	
	public void listDelete(SqlList L, int i) {
		if(L.length==0){
			System.out.println("空线性表");
			return;
		}
		//检查删除为何是否合法
		if(i<1 || i>L.length){
			System.out.println("删除位置不合法");
			return;
		}
		
		if(i<L.length){
			//System.out.println(L.length);
			for(int j=i;j<=L.length;j++){
				L.data[j-1] = L.data[j];
			}
		}
		
		L.length--;
	}
}

