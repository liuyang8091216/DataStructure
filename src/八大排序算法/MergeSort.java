package �˴������㷨;

import java.util.Arrays;

import org.junit.Test;



public class MergeSort {
	/**
	 * �鲢���� ���:�����������������ϣ������ϲ���һ���µ������
	 * ���Ѵ��������з�Ϊ���ɸ������У�ÿ��������������ġ�Ȼ���ٰ����������кϲ�Ϊ������������ ʱ�临�Ӷ�ΪO(nlogn) �ȶ�����ʽ
	 * 
	 * @param nums
	 *            ����������
	 * @return �����������
	 */
	public static int[] sort(int[] nums, int low, int high) {
		int mid = (low + high) / 2;
		if (low < high) {
			sort(nums, low, mid);// ���
			sort(nums, mid + 1, high);// �ұ�
			merge(nums, low, mid, high);// ���ҹ鲢
		}
		return nums;
	}

	public static void merge(int[] nums, int low, int mid, int high) {
		int[] temp = new int[high - low + 1];
		int i = low;// ��ָ��
		int j = mid + 1;// ��ָ��
		int k = 0;
		// �ѽ�С�������Ƶ���������
		while (i <= mid && j <= high) {
			if (nums[i] < nums[j]) {
				temp[k++] = nums[i++];
			} else {
				temp[k++] = nums[j++];
			}
		}
		// �����ʣ�������������
		while (i <= mid) {
			temp[k++] = nums[i++];
		}
		// ���ұ߱�ʣ�������������
		while (j <= high) {
			temp[k++] = nums[j++];
		}
		// ���������е�������nums����        ���ִ����������ݽṹ���ϸ���demo����ʽҪ�á�
		for (int k2 = 0; k2 < temp.length; k2++) {
			nums[k2 + low] = temp[k2];
		}
	}

	// �鲢�����ʵ��
	public static void main(String[] args) {

		int[] nums = { 2, 7, 8, 3, 1, 6, 9, 0, 5, 4 };

		MergeSort.sort(nums, 0, nums.length - 1);
		System.out.println(Arrays.toString(nums));
	}
}










/**
 *  
 * ======================================
 * 4���鲢����
 * �ص㣺
 * ======================================
 *//*
@Test
public void MSortM1(){
	int[] c = new int[a.length];
	Msort(a,c,1,a.length-1);
	print(a);
	print(c);
}
private void Msort(int[] R, int[] T, int low, int height) {
	if(low == height){
		T[low] = R[low];
	} else {
		int mid = (low+height)/2;
		Msort(R,T,low,mid);
		Msort(R,T,mid+1,height);
		Merge(T,R,low,mid,height);
	}
}

private void Merge(int[] R, int[] T, int low, int mid, int height) {
	int i=low;
	int j=mid+1;
	int k=low;
	while(i<=mid && j<=height){
		if(R[i]<=R[j]){
			T[k]=R[i++];
		} else {
			T[k]=R[j++];
		}
	}
	while(i<=mid){
		T[k++]=R[i++];
	}
	while(j<=height){
		T[k++]=R[j++];
	}
}*/
