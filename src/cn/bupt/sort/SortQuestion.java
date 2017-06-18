package cn.bupt.sort;

import java.util.Arrays;

public class SortQuestion {
	
	public static void swap(int a[],int i,int j){
		if(i!=j){
			a[i]=a[i]^a[j];
			a[j]=a[i]^a[j];
			a[i]=a[i]^a[j];
		}
	}
	
	/*
	 * 一个数组中只包含0,1两种数要求将所有的0移动到数组的最左边，所有的1移动到数组的最右边
	 * 方法一快速排序的思想
	 */
	public static void twoNumber1(int a[]){
		int left=0,right=a.length-1;
		while(left<right){
			while(left<right&&a[left]==0){
				left++;
			}
			while(left<right&&a[right]==1){
				right--;
			}
			if(left<right){
				swap(a, left, right);
				right--;
			}
		}
	}
	
	//一个数组中只包含0,1,2三个数，要求将0移动到最左边，1在中间，2在最右边
	public static void threeNumberSort(int a[]){
		int pos0=0,pos2=a.length-1;
		while(pos0<a.length&&a[pos0]==0){
			pos0++;
		}
		while(pos2>=0&&a[pos2]==2){
			pos2--;
		}
		int i=pos0;
		while(i<=pos2){
			if(a[i]==0){
				swap(a, i, pos0++);
			}else if(a[i]==2){
				swap(a, i, pos2--);
				if(a[i]==0){
					swap(a, i, pos0++);
				}
				while(pos2>=0&&a[pos2]==2){
					pos2--;
				}
			}
			i++;
		}
		
			
		
	}
	
	/*
	 * 需要排序的最短子数组长度
	 * [1,5,4,3,2,6,7],返回4因为只有5,4,3,2,需要排序
	 */
	public static int minNeedSort(int a[]){
		int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
		int tag1=-1,tag2=-1;
		for(int i=0;i<a.length;i++){
			if(a[i]>=max){
				max=a[i];
			}else{
				tag1=i;
			}
		}
		for(int i=a.length-1;i>=0;i--){
			if(a[i]<=min){
				min=a[i];
			}else{
				tag2=i;
			}
		}
		return tag1-tag2+1;
	}
	
	public static void main(String[] args) {
		/*int a[]={0,1,0,1,2,2,1,0,1,0,2,0};
		threeNumberSort(a);
		System.out.println(Arrays.toString(a));*/
		/*int a[]={0,1,0,0,1,0,0,1,0,1,0,0,0,1,1,0};
		twoNumber1(a);
		System.out.println(Arrays.toString(a));*/
		int a[]={1,5,4,3,2,6,7};
		int f=minNeedSort(a);
		System.out.println(f);
	}

}
