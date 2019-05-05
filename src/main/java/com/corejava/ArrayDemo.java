package com.corejava;

public class ArrayDemo {

	public static void main(String[] args) {
		
		int[] arr=new int[5];
		arr[0]=10;
		arr[1]=11;
		arr[2]=12;
		arr[3]=13;
		arr[4]=14;
		//arr[5]=100;
		// 1st update from eclipse
		// 1st update from github
		System.out.println(arr.length);
		
		for(int kosmik:arr){
			System.out.println(kosmik);
		}
		
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
		
		String[] strings=new String[]{"kosmik","vimal","srinivas"};
		
		for(String str:strings){
			System.out.println(str);
		} 
		
		Object[] obj=new Object[]{"kosmik",123,123.456,false};
		
		for(Object obj1:obj){
			System.out.println(obj1.toString());
		}
		
		int[][] marks=new int[][]{{10,11,12,13},{14,15,16,17},{10,11,12,13}};
		
	System.out.println(marks.length);	
	
	/*for(int[] mar:marks){
		for(int i:mar){
			System.out.print(i+" ");
		}
		System.out.println();
	}*/
	
	for(int i=0;i<marks.length;i++){
		
		for(int j=0;j<marks[i].length;j++){
			System.out.print(marks[i][j]+" ");
		}
		System.out.println();
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
