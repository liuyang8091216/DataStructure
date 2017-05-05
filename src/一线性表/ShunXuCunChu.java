package һ���Ա�;

/**
 * ���Ա�˳��洢�ṹ
 * @author ������
 *
 * 2017��2��8��
 */
public class ShunXuCunChu {
	
	
	public static void main(String[] args) {
		SqlList sqlList = new SqlList();
		Object e = null;
		//1����ʼ��
		sqlList.initList(sqlList);
		//��ӡ
		sqlList.mPrint(sqlList);
		//2��getElem
		System.out.println("��ȡԪ��" + sqlList.getElem(sqlList, 6, e));
		System.out.println("==========================================");
		//3������
		sqlList.listInsert(sqlList, 11, "a");
		sqlList.mPrint(sqlList);
		System.out.println(sqlList.data[9]);
		//4��ɾ��
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
		//���Ա��Ƿ�����
		if(L.length == L.data.length){
			System.out.println("���Ա�������");
			return;
		}
		//�������λ���Ƿ�Ϸ�
		if(i<1 || i>L.length + 1){
			System.out.println("����λ�ò��Ϸ���");
			return;
		}
		//��������λ�ò��Ǳ�β��
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
			System.out.println("�����Ա�");
			return;
		}
		//���ɾ��Ϊ���Ƿ�Ϸ�
		if(i<1 || i>L.length){
			System.out.println("ɾ��λ�ò��Ϸ�");
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

