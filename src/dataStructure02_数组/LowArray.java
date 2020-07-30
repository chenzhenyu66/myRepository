package dataStructure02_数组;

public class LowArray {
	private long[] a;
	
	public LowArray(int size) {
		a = new long[size];
	}
	
	public void setElem(int index,long value) {
		a[index] = value;
	}
	public long getElem(int index) {
		return a[index];
	}
	
}
class LowArrayApp{
	public static void main(String[] args) {
		LowArray arr;
		arr = new LowArray(100);
		int n = 0;
		int j;
		
		arr.setElem(0, 77);
		arr.setElem(1, 99);
		arr.setElem(2, 88);
		arr.setElem(3, 11);
		arr.setElem(4, 22);
		arr.setElem(5, 55);
		arr.setElem(6, 77);
		arr.setElem(7, 72);
		arr.setElem(8, 14);
		arr.setElem(9, 53);
		n=10;
		
		for (j=0;j<n;j++) {
			System.out.print(arr.getElem(j)+" ");
		}
		System.out.println("");
		
		
		int serachKey=14;
		for(j=0;j<n;j++) {
			if(arr.getElem(j) == serachKey) {
				System.out.println("找到了"+serachKey);
				break;
			}
		}
		
		for(j=0;j<n;j++) {
			if(arr.getElem(j) == 55)
				break;
		}
		for(int k =j;k<n;k++) {
			arr.setElem(k, arr.getElem(k+1));
		}
		n--;
		
		for(j=0;j<n;j++) {
			System.out.print(arr.getElem(j)+" ");
		}
	}
}
