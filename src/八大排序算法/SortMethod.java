package �˴������㷨;


import java.util.Arrays;

import org.junit.Test;

public class SortMethod {

	int[] a = {0,49,38,65,97,76,13,27,49};  //9 0Ϊ�ڱ�
	/**
	 * 
	 * 1����������-��ֱ�Ӳ�������
	 */
	@Test
	public void InsertSort(){
		System.out.println("����������:" + Arrays.toString(a));
		for(int i = 2; i < a.length; i++){
			if(a[i] < a[i-1]){
				a[0] = a[i];
				a[i] = a[i-1];
				int j;
				for(j = i-2;a[0] < a[j];j--){ 
					a[j + 1] = a[j];
				}
				a[j+1] = a[0];
			}
		}
		System.out.println("�Ź�������:" + Arrays.toString(a));
	}
	
	/**
	 * 2����������-��ϣ������
	 */
	@Test
	public void ShellInsert(){
		int[] a = {49,38,65,97,76,13,27,49,55,4};
		System.out.println("����������:" + Arrays.toString(a));
		for(int gap = a.length/2; gap>0;gap /= 2){
			System.out.println("gap:" + gap);
			int temp;
			int j;
			for(int i = gap; i < a.length; i++){
				temp = a[i];
				for(j = i-gap; j >= 0; j-=gap){
					if(temp < a[j]){
						a[j + gap] = a[j];
					} else {
						break;
					}
				}
				a[j + gap] = temp;
			}
		}
		System.out.println("�Ź�������:" + Arrays.toString(a));
	}
	
	/**
	 * 2����������-��ð������
	 */
	@Test
	public void BubbleSort(){
		System.out.println("����������:" + Arrays.toString(a));
		for(int i=0;i<a.length-1;i++){
			for(int j=i+1;j<a.length;j++){
				if(a[i] > a[j]){
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		System.out.println("�Ź�������:" + Arrays.toString(a));
	}
	
	/**
	 * 2����������-����������
	 * 
	 */
	@Test
	public void quickSort(){
		System.out.println("��������");
		System.out.println("����������:" + Arrays.toString(a));
		sort(a,1,a.length-1);
		System.out.println("�Ź�������:" + Arrays.toString(a));
	}
	
	
	public void sort(int[] a, int low, int height) {
		if(low < height){
			int point = partition(a,low,height);
			sort(a,low,point-1);
			sort(a,point + 1,height);
		}
	}

	public int partition(int[] a, int low, int height) {
		//a[0] = a[low];
		int point = a[low];
		while(low < height){
			while(low < height && a[height] >= point){
				height--;
			}
			a[low] = a[height];
			
			while(low < height && a[low] <= point){
				low++;
			}
			a[height] = a[low];
			
		}
		a[low] = point;
		
		return low;
	}

	
	/**
	 * 3��ѡ������-��ֱ��ѡ������
	 */
	@Test
	public void selectSort(){
		System.out.println("����������:" + Arrays.toString(a));
		for(int i=0;i < a.length-1;i++){
			int k = i;
			for(int j = i + 1;j<a.length;j++){
				if(a[k] > a[j]){
					k = j;
				}
			}
			if(i!=k){
				int temp = a[k];
				a[k] = a[i];
				a[i] = temp;
			}
			
		}
		System.out.println("�������:" + Arrays.toString(a));
	}

	/**
	 * 3��ѡ������-��������
	 */
	@Test
	public void HeapSort(){
		System.out.println("����������:" + Arrays.toString(a));
		createHeap();
		for(int i = a.length - 1 ; i > 0; i--){
			int temp = a[1];
			a[1] = a[i];
			a[i] = temp;
			HeapAdjust(a, 1, i-1);
		}
		System.out.println("����������:" + Arrays.toString(a));
	}
	
	public void createHeap(){
		for(int i = a.length/2;i > 0;i--){
			HeapAdjust(a,i,a.length-1);
		}
	}
	
	public void HeapAdjust(int[] a, int s, int m){
		int temp = a[s];
		for(int j = 2 * s; j <= m; j*=2){
			if(j < m && a[j] < a[j + 1]){
				++j;
			}
			if(temp > a[j]){
				break;
			}
			a[s] = a[j];
			s = j;
		}
		a[s] = temp;
	}
	
	
	/**
	 * 4���鲢����
	 */
	@Test
	public void mergeSort(){
		System.out.println("����������:" + Arrays.toString(a));
		Msort(a,1,a.length-1);
		System.out.println("�������:" + Arrays.toString(a));
	}
	
	public void Msort(int[] nums,int low,int hight){
		int mid = (low + hight) / 2;
		if(low < hight){
			Msort(nums,low,mid);
			Msort(nums,mid + 1,hight);
			Merge(nums,low,mid,hight);
		}
	}
	
	public void Merge(int[] nums ,int low,int mid,int hight){
		int[] temp = new int[hight - low + 1];
		int i = low;
		int j = mid + 1;
		int k = 0;
		while(i <= mid && j <= hight){
			if(nums[i] < nums[j]){
				temp[k++] = nums[i++];
			} else {
				temp[k++] = nums[j++] ;
			}
		}
		
		while(i<=mid){
			temp[k++] = nums[i++];
		}
		
		while(j<=hight){
			temp[k++] = nums[j++];
		}
		
		for(int m=0;m<temp.length;m++){
			nums[low++] = temp[m];
		}
	}
	
	/**
	 * Arrays.sort()�������������������򷽷�����������͹鲢����
	 * ���ǻ����������͵�ʱ���ǿ�������
	 * ���Ƕ������͵�����ʱ���ù鲢����
	 * Collections.sort()���õ�Ҳ�ǹ鲢����
	 */
	@Test
	public void arraysSort(){
		int[] a = {49,38,65,97,76,13,27,49,55,4};
		System.out.println("����������:" + Arrays.toString(a));
		Arrays.sort(a);
		System.out.println("����������:" + Arrays.toString(a));
	}
	
	public static void main(String[] args) {
		
	}
}
