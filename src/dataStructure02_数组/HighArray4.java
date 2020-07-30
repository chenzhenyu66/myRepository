package dataStructure02_数组;
/**
 * @author 华硕
 * 数组最好的用法
 * 将各个方法封装到类中
 */
public class HighArray4 {
	private long[] a;
	private int n;

	public HighArray4(int max) {
		a = new long[max];
		n = 0;
	}

	public boolean find(long searchKey) {
		int j;
		for (j = 0; j < searchKey; j++) {
			if (a[j] == searchKey)
				break;
		}

		if (j == n)
			return false;
		else
			return true;
	}

	public void add(long value) {
		a[n] = value;
		n++;
	}

	public boolean delete(long value) {

		int j;
		for (j = 0; j < n; j++) {
			if (value == a[j])
				break;
		}
		if (j == n) {
			return false;
		} else {
			for (int k = j; k < n; k++) {
				a[k] = a[k + 1];
			}
			n--;
			return true;
		}

	}// end delete()

	public void display() {
		for (int j = 0; j < n; j++) {
			System.out.print(a[j] + " ");
		}
		System.out.println();
	}// end display()

}

class HighArryApp {
	public static void main(String[] args) {
		int maxsize = 100;
		HighArray4 arr;
		arr = new HighArray4(maxsize);

		arr.add(77);
		arr.add(99);
		arr.add(88);
		arr.add(11);
		arr.add(22);
		arr.add(55);
		arr.add(77);
		arr.add(72);
		arr.add(14);
		arr.add(53);
		
		arr.display();
		
		int searchKey = 22;
		if(arr.find(searchKey)) {
			System.out.println("Found "+searchKey);
		}
		
		arr.delete(11);
		arr.delete(53);
		
		arr.display();
	}
}
