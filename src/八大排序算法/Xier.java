package °Ë´óÅÅĞòËã·¨;


public class Xier {
	public static void shellSortSmallToBig(int[] data) {
		int j = 0;
		int temp = 0;
		for (int gap = data.length / 2; gap > 0; gap /= 2) {
			System.out.println("gap:" + gap);
			for (int i = gap; i < data.length; i++) {
				temp = data[i];
				for (j = i - gap; j >= 0; j -= gap) {
					if (temp < data[j]) {
						data[j + gap] = data[j];
					} else {
						break;
					}
				}
				data[j + gap] = temp;
			}
			
			for (int i = 0; i < data.length; i++){
				System.out.print(data[i] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[] data = new int[] { 26, 53, 67, 48, 57, 13, 48, 32, 60, 50 };
		for (int i = 0; i < data.length; i++){
			System.out.print(data[i] + " ");
		}
		System.out.println();
		
		shellSortSmallToBig(data);
		
		for (int i = 0; i < data.length; i++){
			System.out.print(data[i] + " ");
		}
	}
}
