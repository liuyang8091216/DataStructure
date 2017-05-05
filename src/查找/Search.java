package 查找;

import java.util.Scanner;

import org.junit.Test;

/**
 * 
 * 查找
 * 1、线性表查找----顺序查找，折半查找，分块查找
 * 2、树表查找-----二叉排序树、平衡二叉树、B-树、B+树
 * 3、散列表查找----
 * @author 刘阳阳
 *
 * 2017年3月15日
 */
public class Search {

	int[] a = {0,5,16,20,27,30,36,44,55,60,67,71};
	

	
	/**
	 * =================================
	 * 1、线性表查找-》顺序查找
	 * =================================
	 * 
	 */
	public int Search_seq(int key){
		//方法一
		/*
		for(int i=a.length-1;i>=1;i--){
			if(a[i] == key){
				return i;
			}
		}
		return 0;*/
		
		/**
		 * 方法二较方法一，就是方法二设置了“哨兵”，在1中，每一步都要检查i是否>=1， 而2中的a[0]就是哨兵，因为必定要找0号元素，所以知识一个比较就行 
		 */
		//方法二
		
		a[0]=key;
		int i;
		for(i=a.length-1;a[i]!=key;i--){
		}
		return i;
		
	}
	
	
	/**
	 * =================================
	 * 1、线性表查找-》折半查找
	 * 要求
	 * 1、必须为有序序列
	 * 2、只能是顺序存储（即不能是链式存储）
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
	 * 测试程序
	 * 0,1,02,03,04,05,06,07,08,09,10,11
	 * 0,5,16,20,27,30,36,44,55,60,67,71
	 */
	@Test
	public void Search_Test(){
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		//1、线性表查找-》顺序查找
		//System.out.println("5的位置为：" + Search_seq(5));
		//2、线性表查找-》折半查找
		System.out.println(a+"的位置为：" + Search_Bin(a));
	}
}
