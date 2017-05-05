package �˴������㷨;

public class ShellSortTest {  
    public static int count = 0;  
  
    public static void main(String[] args) {  
  
        int[] data = new int[] { 5, 3, 6, 2, 1, 9, 4, 8, 7 };  
        print(data);  
        shellSort(data);  
        print(data);  
  
    }  
  
    public static void shellSort(int[] data) {  
        // ���������hֵ  
        int h = 1;  
        while (h <= data.length / 3) {  
            h = h * 3 + 1;  //h=4
        }  
        //System.out.println(h);
        while (h > 0) {  
            for (int i = h; i < data.length; i += h) {  
                if (data[i] < data[i - h]) {  
                    int tmp = data[i];  
                    int j = i - h;  
                    while (j >= 0 && data[j] > tmp) {  
                        data[j + h] = data[j];  
                        j -= h;  
                    }  
                    data[j + h] = tmp;  
                    print(data);  
                }  
            }  
            // �������һ��hֵ  
            h = (h - 1) / 3;  
        }  
    }  
  
    public static void print(int[] data) {  
        for (int i = 0; i < data.length; i++) {  
            System.out.print(data[i] + "\t");  
        }  
        System.out.println();  
    }  
  
}  
