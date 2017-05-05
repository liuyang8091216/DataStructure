package 八大排序算法;

import java.util.Arrays;

import org.junit.Test;

/**
 * 1、插入排序 	直接插入排序、希尔排序 			折半插入排序 
 * 2、交换排序 	冒泡排序、快速排序 
 * 3、选择排序 	直接选择排序、堆排序 
 * 4、归并排序 
 * 5、分配排序	基数排序 				箱排序
 * 
 * 
 * 
 * 八大排序算法。
 * 
 * 
 * @author 刘阳阳
 *
 *         2017年2月25日
 */
public class InsertSort {

	// 此类用到的排序数组
	
	int[] a = {0,49,38,65,97,76,13,27,49};  //9 0为哨兵
	
	int[] a1 = { 0, 9, 5, 6, 12, 31, 23, 15, 100 };
	// int[] b = {0,9,5,6,12,31,23,15,100};

	/**
	 * * ==============================================================
	 * 1、插入排序之->直接插入排序 
	 * 特点： 
	 * 1、稳定排序
	 * 2、算法简便，且容易实现
	 * 3、可适用于链式存储结构
	 * 4、更适合于初始记录基本有序（正序），当初始记录无序，n较大时，此算法时间复杂度较高，不宜采用。
	 * ================================================================
	 */
	@Test
	public void IInsertSort() {
		System.out.println("1、插入排序之->直接插入排序");
		int j = 0;

		for (int i = 2; i < a.length; i++) { // 此处i=2，是因为直接插入排序默认1为拍好的序列，i！=0
												// 是因为预留0的空间来暂存每次的结果
			if (a[i] < a[i - 1]) {// 当a[i] < a[i-1]时才需要操作，否则因为本来就是好的序列，直接跳过
				a[0] = a[i];
				a[i] = a[i - 1];
				// 开始挪窝
				for (j = i - 2; a[0] < a[j]; j--) { // j=i-2 为什么-2
													// 是因为-2之后当前就是从后往前遍历了，-》a[i]
													// = a[i-1] 与 j=i-2 是本题一个关键
					a[j + 1] = a[j];
				}
				a[j + 1] = a[0];
			}
		}
		print(a);
	}

	/**
	 * * ====================================== 
	 * 1、插入排序之->折半插入排序 特点： 
	 * 1、稳定排序
	 * 2、因为要进行折半查找，所以只能用于顺序结构，不能用于链式结构 
	 * 3、适合初始记录无序，且n较大的情况
	 * ======================================
	 */
	@Test
	public void BInsertSort() {
		int low;
		int height;
		int j;
		int m;

		for (int i = 2; i < a.length; i++) { // i=2,代表从2开始
			a[0] = a[i];// 先把当前值存到a[0]
			low = 1;
			height = i - 1; // 给low和height赋值，low从1开始，height从比 当前值i小1，开始
			while (low <= height) { // 一直循环的条件是 low<=height,在这之后的第3行的 height =
									// m-1，可以改变结束循环的条件。
				m = (low + height) / 2; // 首先算出来m;
				if (a[0] < a[m]) { // 如果a[0]<a[m] 代表a[0]比中间的值小 说明插入点应该在前半段，
					height = m - 1; // 所有把中间m-1点复制给height，为何是m-1，因为m已经用过了，所有是m-1;
				} else {
					low = m + 1; // 否则代表 插入点后半段，则把m+1复制给low，来继续去搜索后半段
				}
			}
			// 开始挪窝
			for (j = i - 1; j >= height + 1; j--) { // 和直接插入排序相比，此处j=j-1
													// 还是从后往前遍历
				a[j + 1] = a[j]; // 把当前j给j+1
			}
			a[j + 1] = a[0]; // 最后把a[0]给j+1，因为j是全局变量，所以j的值会随着开始挪窝循环的变化减小，直至见到最佳
		}
		System.out.println("1、插入排序之->折半插入排序");
		print(a);
	}

	/**
	 * 
	 * ====================================== 
	 * 1、插入排序之->希尔排序方法一 
	 * 特点：
	 * 1、记录跳跃式移动导致排序方法是不稳定的 
	 * 2、只能用于顺序结构，不能用于链式结构
	 * 3、综合来说，n越大，效果越明显，所以适合初始记录无序，n较大时的情况~。
	 * ======================================
	 */
	@Test
	public void shellInsertSort() {
		System.out.println("1、插入排序之->希尔排序");
		int[] a = { 26, 53, 67, 48, 57, 13, 48, 32, 60, 50 };
		System.out.println("最初结果");
		printXiEr(a);

		int j = 0;
		int temp; // 初始化两个值
					// j时为了第二层循环，temp为了存储当前值，与其他两种插入排序不同的时，本处使用temp，上面两处使用数组的第0个位置存储
		for (int gap = a.length / 2; gap > 0; gap /= 2) {// 本次循环的是增量的值 5 2 1
			System.out.println("本次循环增量为" + gap);
			for (int i = gap; i < a.length; i++) {// 记录每次的变化，i=gap
													// 相当于第一遍先拿a[5]也就是13 来进行
				temp = a[i]; // temp存储当前的值，与其他两种插入排序不同的时，本处使用temp，上面两处使用数组的第0个位置存储

				for (j = i - gap; j >= 0; j -= gap) { // 本处循环是最重要的循环，也就是移动位置的循环
														// j=i-gap，第一遍j就等于0
														// 也就是a【0】=26
					if (temp < a[j]) { // temp = a[5] = 13
										// ，temp肯定是小于13的，所以执行下边语句
						a[j + gap] = a[j]; // 将a[j] = 26 放到 j+gap的位置，也就是 0+5
											// a[5]的位置
					} else { // 否则跳过本层循环，记录执行 i=gap的循环
						break;
					}
				}

				a[j + gap] = temp; // 最后把temp的值还原
			}
			printXiEr(a);
		}

		// 输出结果
		System.out.println("最终结果：");
		printXiEr(a);
	}

	/**
	 * 
	 * ====================================== 
	 * 1、插入排序之->希尔排序 方法二
	 * 
	 * 方法二修改方法一的存储元素的方案，和插入排序前两个一样，采用a[0]来存储。
	 * ======================================
	 */
	@Test
	public void shellInsertSort2() {
		System.out.println("1、插入排序之->希尔排序2");
		int[] a = { 0, 26, 53, 67, 48, 57, 13, 48, 32, 60, 50 };
		System.out.println("最初结果");
		print(a);
		System.out.println();
		int j = 0;
		// int temp; //初始化两个值
		// j时为了第二层循环，temp为了存储当前值，与其他两种插入排序不同的时，本处使用temp，上面两处使用数组的第0个位置存储
		for (int gap = a.length / 2; gap > 0; gap /= 2) {// 本次循环的是增量的值 5 2 1
			System.out.println("本次循环增量为" + gap);
			for (int i = gap; i < a.length; i++) {// 记录每次的变化，i=gap
													// 相当于第一遍先拿a[5]也就是13 来进行
				a[0] = a[i]; // a[0]存储当前的值

				for (j = i - gap; j > 0; j -= gap) { // 本处循环是最重要的循环，也就是移动位置的循环
														// j=i-gap，第一遍j就等于0
														// 也就是a【0】=26 注意此处改为>0
					if (a[0] < a[j]) { // temp = a[5] = 13
										// ，temp肯定是小于13的，所以执行下边语句
						a[j + gap] = a[j]; // 将a[j] = 26 放到 j+gap的位置，也就是 0+5
											// a[5]的位置
					} else { // 否则跳过本层循环，记录执行 i=gap的循环
						break;
					}
				}

				a[j + gap] = a[0]; // 最后把a[0]的值还原
			}
			printXiEr(a);
		}

		// 输出结果
		System.out.println("最终结果：");
		print(a);
	}

	/**
	 * 
	 * ====================================== 
	 * 2、交换排序->冒泡排序
	 * 冒泡排序最为一种经典的排序算法，是我们应该随后都能写出来的。 
	 * 特点： 1、稳定排序 
	 * 2、可用于链式存储结构
	 * 3、移动记录次数较多，算法平均时间性能比直接插入排序查。 
	 * 4、当记录无序，n较大时，此算法不宜采用。
	 * 
	 * ======================================
	 */
	@Test
	public void BulleSort() {
		System.out.println("2、交换排序->冒泡排序");
		printXiEr(a);
		for (int i = 0; i < a.length - 1; i++) { // 采用第一层循环来控制循环的次数，一共循环a.length-1次
													// 这样会循环到倒数第二个元素
			for (int j = i + 1; j < a.length; j++) {// 第二层循环来交换位置，j在i的基础上+1是因为当前的值要和他身后的元素比较大小，直至最后一个。（
													// 因为第二次循环直至最后一个所以第一层循环才会a.length-1）
				if (a[i] > a[j]) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		printXiEr(a);
	}

	/**
	 * 
	 * ====================================== 
	 * 2、交换排序->快速排序 
	 * 特点： 
	 * 1、属于不稳定排序
	 * 2、排序过程中需要确定上界和下届，所以只能用于顺序结构，很难用于链式
	 * 3、在n较大时，在平均情况下快速排序是所有内部排序中速度最快的一种，所以适合初始记录无序，n较大的情况
	 * ======================================
	 */
	@Test
	public void QuickSort() {
		System.out.println("待排序序列");
		print(a);
		Qsort(a, 1, a.length - 1);
		System.out.println();
		print(a);
	}

	private void Qsort(int[] a, int low, int height) {
		if (low < height) {
			int point;
			point = Partition(a, low, height);// 查找中间点
			Qsort(a, low, point - 1);// 递归排序左边
			Qsort(a, point + 1, height);// 递归排序右边
		}
	}

	private int Partition(int[] a, int low, int height) { //1   9
		a[0] = a[low];// 将中间点保存在a[0]这个位置中。
		int point = a[low];// 把中间点保存在point中
		while (low < height) {// 循环条件是只要low<height
			// 以下两个while就是核心之处
			while (low < height && a[height] >= point) {// low<height就不说了，本来是a[height]<poin就移动，
														// 现在改变一下
														// 当》=的时候就--；
				height--;
			}
			a[low] = a[height]; // 循环结束后，交换位置，把右边小的，交换到中间点的左边
			while (low < height && a[low] <= point) { // 相反同上， 本来是a[low]>=point
														// 改变写法 改成a<=point就跳过++；
				low++;
			}
			a[height] = a[low];
		}
		a[low] = a[0];
		return low;
	}
	// 3、选择排序 直接选择排序、堆排序、 树形排序

	/**
	 * 
	 * ====================================== 
	 * 3、选择排序->直接选择排序 
	 * 
	 * 特点： 
	 * 1、是一种稳定的排序算法。
	 * 2、可用于链式存储结构
	 *  ======================================
	 */
	@Test
	public void selectSort() {
		System.out.println("待排序序列");
		print(a);
		for (int i = 1; i < a.length; i++) {//9
			int k = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[k] > a[j]) {
					k = j;
				}
			}
			if (k != i) {
				int temp = a[i];
				a[i] = a[k];
				a[k] = temp;
				
			}
		}
		System.out.println();
		print(a);
	}

	/**
	 * 
	 * ====================================== 
	 * 3、选择排序->堆排序 
	 * 特点：
	 * 1、不稳定排序
	 * 2、只能用于顺序存储结构
	 *  ======================================
	 */
	@Test
	public void HeapSort() {
		System.out.println(Arrays.toString(a));
		CreateHeap();// 首先需要创建根堆
		/*for (int i = a.length - 1; i > 1; --i) {// 这个循环是把最大值a[1]放到末尾 ，
			int temp = a[1];
			a[1] = a[i]; // 此时i代表最后一个元素
			a[i] = temp;
			HeapAdjust(a, 1, i - 1);// 调整一次后继续，把数组，第一个位置，和最后一个位置 此处为何i-1，
									// 是因为循环已经把最大值放到最后一个了，所以下次就方法最后一个-1的位置
		}*/
		System.out.println(Arrays.toString(a));
		print(a);
	}

	private void CreateHeap() {
		int n = a.length - 1; // 得到数组的最大值      8
		for (int i = n / 2; i > 0; i--) { // 从最后一个非终端结点开始，然后一次--    4
			HeapAdjust(a, i, n);
		}
	}

	// 调整堆              调整堆就是我给你三个参数int[] a, int s, int m ，你把以s为枢纽的完全二叉树，调成大根堆。
	private void HeapAdjust(int[] a, int s, int m) {// s代表当前 m代表最后
		int temp = a[s]; // 先把a[s]的值赋给temp保存起来
		for (int j = 2 * s; j <= m; j *= 2) {
			if (j < m && a[j] < a[j + 1]) { // 判断是s大还是s+1大，如果s+1大 就++j，把j换成当前最大
				++j;
			}
			if (temp >= a[j]) { // 如果temp中比最大值还大，代表本身就是一个根堆，break
				break;// 如果大于，就代表当前为大跟对，退出
			}
			a[s] = a[j];// 否则就把最大给[s]
			s = j;// 然后把最大下标给s，继续循环,检查是否因为调整根堆而破坏了子树
			// s = j 如果在进入for循环，就是检查以s为根节点，他之后的是否是根堆
		}
		a[s] = temp;
	}

	/**
	 * 
	 * ====================================== 
	 * 4、归并排序 
	 * 特点：
	 * 1、属于稳定排序
	 * 2、可用于链式存储
	 * ======================================
	 */
	@Test
	public void MSortM1() {
		print(a);
		System.out.println();
		Msort(a, 1, a.length - 1);
		print(a);
	}

	private void Msort(int[] nums, int low, int hight) {
		int mid = (low + hight) / 2; // 求得中间点
		if (low < hight) { // 判断条件 如果low<hight就继续进行
			Msort(nums, low, mid); // 递归左
			Msort(nums, mid + 1, hight); // 递归又
			Merge(nums, low, mid, hight); // 最后合并
		}

	}

	private void Merge(int[] nums, int low, int mid, int hight) {
		int[] temp = new int[hight - low + 1]; // 临时数组，存放本次排序的序列
		int i = low; // i代表做序列开头 j代表右序列开头 k的作用是针对temp数组使用的
		int j = mid + 1;
		int k = 0;
		while (i <= mid && j <= hight) { // while条件必须满足两个&&条件，只要有一个不满足就退出
			// 本次循环的最后结果就是 左右两个序列，其中一个序列完全赋值给temp，然后结束
			if (nums[i] < nums[j]) { // 比较
				temp[k++] = nums[i++]; // 赋值
			} else {
				temp[k++] = nums[j++]; // 赋值
			}
		}
		// 以下两个while是针对上面的while，因为上面的while最后结束的结果为
		// 左右两个序列，其中一个序列完全赋值给temp，然后结束，这样其中一个序列还有值没有赋给temp
		// 如果是左序列 就对左序列进行赋值
		while (i <= mid) {
			temp[k++] = nums[i++];
		}
		// 如果是又序列 就对又序列进行赋值
		while (j <= hight) {
			temp[k++] = nums[j++];
		}
		// 最后把本次排好序的temp，按照合并前的其实位置开始，重新赋值给nums； 这种处理方法比数据结构书上给的demo处理方式要好。
		for (int m = 0; m < temp.length; m++) {
			nums[low + m] = temp[m];
		}
	}

	/**
	 * 
	 * 基数排序
	 * 
	 */
	@Test
	public void radixSortTest(){
		radixSort(a,4,3);
		print(a);
	}
	
	private static void radixSort(int[] array, int radix, int distance) {
		// radix，代表基数
		// distance代表排序元素的位数 也就是进行几次 分配 收集，，因为待排序序列中最大值为100   三位数 所以distance为3
		int length = array.length;
		int[] temp = new int[length];// 用于暂存元素
		int[] count = new int[radix];// 用于统计基数内元素个数
		int divide = 1;

		for (int i = 0; i < distance; i++) {

			System.arraycopy(array, 0, temp, 0, length);
			Arrays.fill(count, 0);

			for (int j = 0; j < length; j++) {
				int tempKey = (temp[j] / divide) % radix;
				count[tempKey]++; // 基数选中计数
			}

			for (int j = 1; j < radix; j++) {
				count[j] = count[j] + count[j - 1];// 累计计数
			}
			for (int j = length - 1; j >= 0; j--) {
				int tempKey = (temp[j] / divide) % radix;
				count[tempKey]--;// 从后往前赋值
				array[count[tempKey]] = temp[j];
			}
			divide = divide * radix;
		}
	}


	
	
	
	
	
	
	
	
	
	
	

	/**
	 * 辅助方法，输出当前数组的值。
	 * 
	 * @param temp
	 *            接受传过来的数组
	 */
	void print(int[] temp) {
		System.out.println("排序结果为：");
		for (int i = 1; i < temp.length; i++) {
			System.out.print(temp[i] + " ");
		}
	}

	/**
	 * 第一种希尔排序的专用抽出方法
	 * 
	 * @param temp
	 */
	void printXiEr(int[] temp) {
		for (int i = 0; i < temp.length; i++) {
			System.out.print(temp[i] + " ");
		}
		System.out.println();
	}

	/**
	 * 小测试，测试return，break，continue的区别
	 */
	@Test
	public void aaa() {
		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 3; j++) {
				if (i == 2) {
					break;
				}
				System.out.println(i + " " + j);
			}
		}
	}
}
