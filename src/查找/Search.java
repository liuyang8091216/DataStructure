package ����;

import java.util.Scanner;

import org.junit.Test;

/**
 * 
 * ����
 * 1�����Ա����----˳����ң��۰���ң��ֿ����
 * 2���������-----������������ƽ���������B-����B+��
 * 3��ɢ�б����----
 * @author ������
 *
 * 2017��3��15��
 */
public class Search {

	int[] a = {0,5,16,20,27,30,36,44,55,60,67,71};
	

	
	/**
	 * =================================
	 * 1�����Ա����-��˳�����
	 * =================================
	 * 
	 */
	public int Search_seq(int key){
		//����һ
		/*
		for(int i=a.length-1;i>=1;i--){
			if(a[i] == key){
				return i;
			}
		}
		return 0;*/
		
		/**
		 * �������Ϸ���һ�����Ƿ����������ˡ��ڱ�������1�У�ÿһ����Ҫ���i�Ƿ�>=1�� ��2�е�a[0]�����ڱ�����Ϊ�ض�Ҫ��0��Ԫ�أ�����֪ʶһ���ȽϾ��� 
		 */
		//������
		
		a[0]=key;
		int i;
		for(i=a.length-1;a[i]!=key;i--){
		}
		return i;
		
	}
	
	
	/**
	 * =================================
	 * 1�����Ա����-���۰����
	 * Ҫ��
	 * 1������Ϊ��������
	 * 2��ֻ����˳��洢������������ʽ�洢��
	 * =================================
	 * 
	 */
	public int Search_Bin(int key){
		int low=1;
		int hight=a.length-1;
		while(low<=hight){
			int mid = (low+hight)/2;
			if(a[mid]==key) return mid;
			if(a[mid] < key){
				low = mid+1;
			}
			if(a[mid] >= key){
				hight = mid-1;
			}
		}
		return 0;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * ���Գ���
	 * 0,1,02,03,04,05,06,07,08,09,10,11
	 * 0,5,16,20,27,30,36,44,55,60,67,71
	 */
	@Test
	public void Search_Test(){
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		//1�����Ա����-��˳�����
		//System.out.println("5��λ��Ϊ��" + Search_seq(5));
		//2�����Ա����-���۰����
		System.out.println(a+"��λ��Ϊ��" + Search_Bin(a));
	}
}
