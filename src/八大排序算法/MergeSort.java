package 八大排序算法;

import java.util.Arrays;

import org.junit.Test;



public class MergeSort {
	/**
	 * 归并排序 简介:将两个（或两个以上）有序表合并成一个新的有序表
	 * 即把待排序序列分为若干个子序列，每个子序列是有序的。然后再把有序子序列合并为整体有序序列 时间复杂度为O(nlogn) 稳定排序方式
	 * 
	 * @param nums
	 *            待排序数组
	 * @return 输出有序数组
	 */
	public static int[] sort(int[] nums, int low, int high) {
		int mid = (low + high) / 2;
		if (low < high) {
			sort(nums, low, mid);// 左边
			sort(nums, mid + 1, high);// 右边
			merge(nums, low, mid, high);// 左右归并
		}
		return nums;
	}

	public static void merge(int[] nums, int low, int mid, int high) {
		int[] temp = new int[high - low + 1];
		int i = low;// 左指针
		int j = mid + 1;// 右指针
		int k = 0;
		// 把较小的数先移到新数组中
		while (i <= mid && j <= high) {
			if (nums[i] < nums[j]) {
				temp[k++] = nums[i++];
			} else {
				temp[k++] = nums[j++];
			}
		}
		// 把左边剩余的数移入数组
		while (i <= mid) {
			temp[k++] = nums[i++];
		}
		// 把右边边剩余的数移入数组
		while (j <= high) {
			temp[k++] = nums[j++];
		}
		// 把新数组中的数覆盖nums数组        这种处理方法比数据结构书上给的demo处理方式要好。
		for (int k2 = 0; k2 < temp.length; k2++) {
			nums[k2 + low] = temp[k2];
		}
	}

	// 归并排序的实现
	public static void main(String[] args) {

		int[] nums = { 2, 7, 8, 3, 1, 6, 9, 0, 5, 4 };

		MergeSort.sort(nums, 0, nums.length - 1);
		System.out.println(Arrays.toString(nums));
	}
}










/**
 *  
 * ======================================
 * 4、归并排序
 * 特点：
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
