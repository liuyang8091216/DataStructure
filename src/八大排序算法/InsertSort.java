package �˴������㷨;

import java.util.Arrays;

import org.junit.Test;

/**
 * 1���������� 	ֱ�Ӳ�������ϣ������ 			�۰�������� 
 * 2���������� 	ð�����򡢿������� 
 * 3��ѡ������ 	ֱ��ѡ�����򡢶����� 
 * 4���鲢���� 
 * 5����������	�������� 				������
 * 
 * 
 * 
 * �˴������㷨��
 * 
 * 
 * @author ������
 *
 *         2017��2��25��
 */
public class InsertSort {

	// �����õ�����������
	
	int[] a = {0,49,38,65,97,76,13,27,49};  //9 0Ϊ�ڱ�
	
	int[] a1 = { 0, 9, 5, 6, 12, 31, 23, 15, 100 };
	// int[] b = {0,9,5,6,12,31,23,15,100};

	/**
	 * * ==============================================================
	 * 1����������֮->ֱ�Ӳ������� 
	 * �ص㣺 
	 * 1���ȶ�����
	 * 2���㷨��㣬������ʵ��
	 * 3������������ʽ�洢�ṹ
	 * 4�����ʺ��ڳ�ʼ��¼�����������򣩣�����ʼ��¼����n�ϴ�ʱ�����㷨ʱ�临�ӶȽϸߣ����˲��á�
	 * ================================================================
	 */
	@Test
	public void IInsertSort() {
		System.out.println("1����������֮->ֱ�Ӳ�������");
		int j = 0;

		for (int i = 2; i < a.length; i++) { // �˴�i=2������Ϊֱ�Ӳ�������Ĭ��1Ϊ�ĺõ����У�i��=0
												// ����ΪԤ��0�Ŀռ����ݴ�ÿ�εĽ��
			if (a[i] < a[i - 1]) {// ��a[i] < a[i-1]ʱ����Ҫ������������Ϊ�������Ǻõ����У�ֱ������
				a[0] = a[i];
				a[i] = a[i - 1];
				// ��ʼŲ��
				for (j = i - 2; a[0] < a[j]; j--) { // j=i-2 Ϊʲô-2
													// ����Ϊ-2֮��ǰ���ǴӺ���ǰ�����ˣ�-��a[i]
													// = a[i-1] �� j=i-2 �Ǳ���һ���ؼ�
					a[j + 1] = a[j];
				}
				a[j + 1] = a[0];
			}
		}
		print(a);
	}

	/**
	 * * ====================================== 
	 * 1����������֮->�۰�������� �ص㣺 
	 * 1���ȶ�����
	 * 2����ΪҪ�����۰���ң�����ֻ������˳��ṹ������������ʽ�ṹ 
	 * 3���ʺϳ�ʼ��¼������n�ϴ�����
	 * ======================================
	 */
	@Test
	public void BInsertSort() {
		int low;
		int height;
		int j;
		int m;

		for (int i = 2; i < a.length; i++) { // i=2,�����2��ʼ
			a[0] = a[i];// �Ȱѵ�ǰֵ�浽a[0]
			low = 1;
			height = i - 1; // ��low��height��ֵ��low��1��ʼ��height�ӱ� ��ǰֵiС1����ʼ
			while (low <= height) { // һֱѭ���������� low<=height,����֮��ĵ�3�е� height =
									// m-1�����Ըı����ѭ����������
				m = (low + height) / 2; // ���������m;
				if (a[0] < a[m]) { // ���a[0]<a[m] ����a[0]���м��ֵС ˵�������Ӧ����ǰ��Σ�
					height = m - 1; // ���а��м�m-1�㸴�Ƹ�height��Ϊ����m-1����Ϊm�Ѿ��ù��ˣ�������m-1;
				} else {
					low = m + 1; // ������� �������Σ����m+1���Ƹ�low��������ȥ��������
				}
			}
			// ��ʼŲ��
			for (j = i - 1; j >= height + 1; j--) { // ��ֱ�Ӳ���������ȣ��˴�j=j-1
													// ���ǴӺ���ǰ����
				a[j + 1] = a[j]; // �ѵ�ǰj��j+1
			}
			a[j + 1] = a[0]; // ����a[0]��j+1����Ϊj��ȫ�ֱ���������j��ֵ�����ſ�ʼŲ��ѭ���ı仯��С��ֱ���������
		}
		System.out.println("1����������֮->�۰��������");
		print(a);
	}

	/**
	 * 
	 * ====================================== 
	 * 1����������֮->ϣ�����򷽷�һ 
	 * �ص㣺
	 * 1����¼��Ծʽ�ƶ��������򷽷��ǲ��ȶ��� 
	 * 2��ֻ������˳��ṹ������������ʽ�ṹ
	 * 3���ۺ���˵��nԽ��Ч��Խ���ԣ������ʺϳ�ʼ��¼����n�ϴ�ʱ�����~��
	 * ======================================
	 */
	@Test
	public void shellInsertSort() {
		System.out.println("1����������֮->ϣ������");
		int[] a = { 26, 53, 67, 48, 57, 13, 48, 32, 60, 50 };
		System.out.println("������");
		printXiEr(a);

		int j = 0;
		int temp; // ��ʼ������ֵ
					// jʱΪ�˵ڶ���ѭ����tempΪ�˴洢��ǰֵ�����������ֲ�������ͬ��ʱ������ʹ��temp����������ʹ������ĵ�0��λ�ô洢
		for (int gap = a.length / 2; gap > 0; gap /= 2) {// ����ѭ������������ֵ 5 2 1
			System.out.println("����ѭ������Ϊ" + gap);
			for (int i = gap; i < a.length; i++) {// ��¼ÿ�εı仯��i=gap
													// �൱�ڵ�һ������a[5]Ҳ����13 ������
				temp = a[i]; // temp�洢��ǰ��ֵ�����������ֲ�������ͬ��ʱ������ʹ��temp����������ʹ������ĵ�0��λ�ô洢

				for (j = i - gap; j >= 0; j -= gap) { // ����ѭ��������Ҫ��ѭ����Ҳ�����ƶ�λ�õ�ѭ��
														// j=i-gap����һ��j�͵���0
														// Ҳ����a��0��=26
					if (temp < a[j]) { // temp = a[5] = 13
										// ��temp�϶���С��13�ģ�����ִ���±����
						a[j + gap] = a[j]; // ��a[j] = 26 �ŵ� j+gap��λ�ã�Ҳ���� 0+5
											// a[5]��λ��
					} else { // ������������ѭ������¼ִ�� i=gap��ѭ��
						break;
					}
				}

				a[j + gap] = temp; // ����temp��ֵ��ԭ
			}
			printXiEr(a);
		}

		// ������
		System.out.println("���ս����");
		printXiEr(a);
	}

	/**
	 * 
	 * ====================================== 
	 * 1����������֮->ϣ������ ������
	 * 
	 * �������޸ķ���һ�Ĵ洢Ԫ�صķ������Ͳ�������ǰ����һ��������a[0]���洢��
	 * ======================================
	 */
	@Test
	public void shellInsertSort2() {
		System.out.println("1����������֮->ϣ������2");
		int[] a = { 0, 26, 53, 67, 48, 57, 13, 48, 32, 60, 50 };
		System.out.println("������");
		print(a);
		System.out.println();
		int j = 0;
		// int temp; //��ʼ������ֵ
		// jʱΪ�˵ڶ���ѭ����tempΪ�˴洢��ǰֵ�����������ֲ�������ͬ��ʱ������ʹ��temp����������ʹ������ĵ�0��λ�ô洢
		for (int gap = a.length / 2; gap > 0; gap /= 2) {// ����ѭ������������ֵ 5 2 1
			System.out.println("����ѭ������Ϊ" + gap);
			for (int i = gap; i < a.length; i++) {// ��¼ÿ�εı仯��i=gap
													// �൱�ڵ�һ������a[5]Ҳ����13 ������
				a[0] = a[i]; // a[0]�洢��ǰ��ֵ

				for (j = i - gap; j > 0; j -= gap) { // ����ѭ��������Ҫ��ѭ����Ҳ�����ƶ�λ�õ�ѭ��
														// j=i-gap����һ��j�͵���0
														// Ҳ����a��0��=26 ע��˴���Ϊ>0
					if (a[0] < a[j]) { // temp = a[5] = 13
										// ��temp�϶���С��13�ģ�����ִ���±����
						a[j + gap] = a[j]; // ��a[j] = 26 �ŵ� j+gap��λ�ã�Ҳ���� 0+5
											// a[5]��λ��
					} else { // ������������ѭ������¼ִ�� i=gap��ѭ��
						break;
					}
				}

				a[j + gap] = a[0]; // ����a[0]��ֵ��ԭ
			}
			printXiEr(a);
		}

		// ������
		System.out.println("���ս����");
		print(a);
	}

	/**
	 * 
	 * ====================================== 
	 * 2����������->ð������
	 * ð��������Ϊһ�־���������㷨��������Ӧ�������д�����ġ� 
	 * �ص㣺 1���ȶ����� 
	 * 2����������ʽ�洢�ṹ
	 * 3���ƶ���¼�����϶࣬�㷨ƽ��ʱ�����ܱ�ֱ�Ӳ�������顣 
	 * 4������¼����n�ϴ�ʱ�����㷨���˲��á�
	 * 
	 * ======================================
	 */
	@Test
	public void BulleSort() {
		System.out.println("2����������->ð������");
		printXiEr(a);
		for (int i = 0; i < a.length - 1; i++) { // ���õ�һ��ѭ��������ѭ���Ĵ�����һ��ѭ��a.length-1��
													// ������ѭ���������ڶ���Ԫ��
			for (int j = i + 1; j < a.length; j++) {// �ڶ���ѭ��������λ�ã�j��i�Ļ�����+1����Ϊ��ǰ��ֵҪ��������Ԫ�رȽϴ�С��ֱ�����һ������
													// ��Ϊ�ڶ���ѭ��ֱ�����һ�����Ե�һ��ѭ���Ż�a.length-1��
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
	 * 2����������->�������� 
	 * �ص㣺 
	 * 1�����ڲ��ȶ�����
	 * 2�������������Ҫȷ���Ͻ���½죬����ֻ������˳��ṹ������������ʽ
	 * 3����n�ϴ�ʱ����ƽ������¿��������������ڲ��������ٶ�����һ�֣������ʺϳ�ʼ��¼����n�ϴ�����
	 * ======================================
	 */
	@Test
	public void QuickSort() {
		System.out.println("����������");
		print(a);
		Qsort(a, 1, a.length - 1);
		System.out.println();
		print(a);
	}

	private void Qsort(int[] a, int low, int height) {
		if (low < height) {
			int point;
			point = Partition(a, low, height);// �����м��
			Qsort(a, low, point - 1);// �ݹ��������
			Qsort(a, point + 1, height);// �ݹ������ұ�
		}
	}

	private int Partition(int[] a, int low, int height) { //1   9
		a[0] = a[low];// ���м�㱣����a[0]���λ���С�
		int point = a[low];// ���м�㱣����point��
		while (low < height) {// ѭ��������ֻҪlow<height
			// ��������while���Ǻ���֮��
			while (low < height && a[height] >= point) {// low<height�Ͳ�˵�ˣ�������a[height]<poin���ƶ���
														// ���ڸı�һ��
														// ����=��ʱ���--��
				height--;
			}
			a[low] = a[height]; // ѭ�������󣬽���λ�ã����ұ�С�ģ��������м������
			while (low < height && a[low] <= point) { // �෴ͬ�ϣ� ������a[low]>=point
														// �ı�д�� �ĳ�a<=point������++��
				low++;
			}
			a[height] = a[low];
		}
		a[low] = a[0];
		return low;
	}
	// 3��ѡ������ ֱ��ѡ�����򡢶����� ��������

	/**
	 * 
	 * ====================================== 
	 * 3��ѡ������->ֱ��ѡ������ 
	 * 
	 * �ص㣺 
	 * 1����һ���ȶ��������㷨��
	 * 2����������ʽ�洢�ṹ
	 *  ======================================
	 */
	@Test
	public void selectSort() {
		System.out.println("����������");
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
	 * 3��ѡ������->������ 
	 * �ص㣺
	 * 1�����ȶ�����
	 * 2��ֻ������˳��洢�ṹ
	 *  ======================================
	 */
	@Test
	public void HeapSort() {
		System.out.println(Arrays.toString(a));
		CreateHeap();// ������Ҫ��������
		/*for (int i = a.length - 1; i > 1; --i) {// ���ѭ���ǰ����ֵa[1]�ŵ�ĩβ ��
			int temp = a[1];
			a[1] = a[i]; // ��ʱi�������һ��Ԫ��
			a[i] = temp;
			HeapAdjust(a, 1, i - 1);// ����һ�κ�����������飬��һ��λ�ã������һ��λ�� �˴�Ϊ��i-1��
									// ����Ϊѭ���Ѿ������ֵ�ŵ����һ���ˣ������´ξͷ������һ��-1��λ��
		}*/
		System.out.println(Arrays.toString(a));
		print(a);
	}

	private void CreateHeap() {
		int n = a.length - 1; // �õ���������ֵ      8
		for (int i = n / 2; i > 0; i--) { // �����һ�����ն˽�㿪ʼ��Ȼ��һ��--    4
			HeapAdjust(a, i, n);
		}
	}

	// ������              �����Ѿ����Ҹ�����������int[] a, int s, int m �������sΪ��Ŧ����ȫ�����������ɴ���ѡ�
	private void HeapAdjust(int[] a, int s, int m) {// s����ǰ m�������
		int temp = a[s]; // �Ȱ�a[s]��ֵ����temp��������
		for (int j = 2 * s; j <= m; j *= 2) {
			if (j < m && a[j] < a[j + 1]) { // �ж���s����s+1�����s+1�� ��++j����j���ɵ�ǰ���
				++j;
			}
			if (temp >= a[j]) { // ���temp�б����ֵ���󣬴��������һ�����ѣ�break
				break;// ������ڣ��ʹ���ǰΪ����ԣ��˳�
			}
			a[s] = a[j];// ����Ͱ�����[s]
			s = j;// Ȼ�������±��s������ѭ��,����Ƿ���Ϊ�������Ѷ��ƻ�������
			// s = j ����ڽ���forѭ�������Ǽ����sΪ���ڵ㣬��֮����Ƿ��Ǹ���
		}
		a[s] = temp;
	}

	/**
	 * 
	 * ====================================== 
	 * 4���鲢���� 
	 * �ص㣺
	 * 1�������ȶ�����
	 * 2����������ʽ�洢
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
		int mid = (low + hight) / 2; // ����м��
		if (low < hight) { // �ж����� ���low<hight�ͼ�������
			Msort(nums, low, mid); // �ݹ���
			Msort(nums, mid + 1, hight); // �ݹ���
			Merge(nums, low, mid, hight); // ���ϲ�
		}

	}

	private void Merge(int[] nums, int low, int mid, int hight) {
		int[] temp = new int[hight - low + 1]; // ��ʱ���飬��ű������������
		int i = low; // i���������п�ͷ j���������п�ͷ k�����������temp����ʹ�õ�
		int j = mid + 1;
		int k = 0;
		while (i <= mid && j <= hight) { // while����������������&&������ֻҪ��һ����������˳�
			// ����ѭ������������� �����������У�����һ��������ȫ��ֵ��temp��Ȼ�����
			if (nums[i] < nums[j]) { // �Ƚ�
				temp[k++] = nums[i++]; // ��ֵ
			} else {
				temp[k++] = nums[j++]; // ��ֵ
			}
		}
		// ��������while����������while����Ϊ�����while�������Ľ��Ϊ
		// �����������У�����һ��������ȫ��ֵ��temp��Ȼ���������������һ�����л���ֵû�и���temp
		// ����������� �Ͷ������н��и�ֵ
		while (i <= mid) {
			temp[k++] = nums[i++];
		}
		// ����������� �Ͷ������н��и�ֵ
		while (j <= hight) {
			temp[k++] = nums[j++];
		}
		// ���ѱ����ź����temp�����պϲ�ǰ����ʵλ�ÿ�ʼ�����¸�ֵ��nums�� ���ִ����������ݽṹ���ϸ���demo����ʽҪ�á�
		for (int m = 0; m < temp.length; m++) {
			nums[low + m] = temp[m];
		}
	}

	/**
	 * 
	 * ��������
	 * 
	 */
	@Test
	public void radixSortTest(){
		radixSort(a,4,3);
		print(a);
	}
	
	private static void radixSort(int[] array, int radix, int distance) {
		// radix���������
		// distance��������Ԫ�ص�λ�� Ҳ���ǽ��м��� ���� �ռ�������Ϊ���������������ֵΪ100   ��λ�� ����distanceΪ3
		int length = array.length;
		int[] temp = new int[length];// �����ݴ�Ԫ��
		int[] count = new int[radix];// ����ͳ�ƻ�����Ԫ�ظ���
		int divide = 1;

		for (int i = 0; i < distance; i++) {

			System.arraycopy(array, 0, temp, 0, length);
			Arrays.fill(count, 0);

			for (int j = 0; j < length; j++) {
				int tempKey = (temp[j] / divide) % radix;
				count[tempKey]++; // ����ѡ�м���
			}

			for (int j = 1; j < radix; j++) {
				count[j] = count[j] + count[j - 1];// �ۼƼ���
			}
			for (int j = length - 1; j >= 0; j--) {
				int tempKey = (temp[j] / divide) % radix;
				count[tempKey]--;// �Ӻ���ǰ��ֵ
				array[count[tempKey]] = temp[j];
			}
			divide = divide * radix;
		}
	}


	
	
	
	
	
	
	
	
	
	
	

	/**
	 * ���������������ǰ�����ֵ��
	 * 
	 * @param temp
	 *            ���ܴ�����������
	 */
	void print(int[] temp) {
		System.out.println("������Ϊ��");
		for (int i = 1; i < temp.length; i++) {
			System.out.print(temp[i] + " ");
		}
	}

	/**
	 * ��һ��ϣ�������ר�ó������
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
	 * С���ԣ�����return��break��continue������
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
