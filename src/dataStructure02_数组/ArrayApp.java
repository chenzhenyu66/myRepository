package dataStructure02_数组;
/**
 * @author 华硕
 * 查找、删除、展示
 */
public class ArrayApp {
	public static void main(String[] args) {
		long[] arr = new long[100];
		int n = 0;
		int j;
		long searchKey;
		//----------------------------------------//
		arr[0] =77;
		arr[1] =99;
		arr[2] =44;
		arr[3] =55;
		arr[4] =22;
		arr[5] =88;
		arr[6] =11;
		arr[7] =00;
		arr[8] =66;
		arr[9] =10;
		n = 10;
		
		//----------------------------------------//
		//find
		searchKey = 66;
		for(j=0;j<n;j++) 
			if(arr[j] == searchKey)
				break;
		
		if(j == n)
			System.out.println("没找到"+searchKey);
		else
			System.out.println("找到"+searchKey+"了");
		
		//----------------------------------------//
		//delete
		searchKey = 66;
		for(j=0;j<n;j++) 
			if(arr[j] == searchKey)
				break;
		for(int k=j;k<n;k++)
			arr[k]=arr[k+1];
		n--;
		//----------------------------------------//
		//display
		
		for(j=0;j<n;j++)
			System.out.println(arr[j]+" ");
		
		
	
		
	}

}