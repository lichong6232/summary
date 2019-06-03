package cn.bupt.sort;

import java.util.Arrays;

public class Sort {
	
	public static void swap(int a[],int i,int j){
		if(i!=j){
			a[i]=a[i]^a[j];
			a[j]=a[i]^a[j];
			a[i]=a[i]^a[j];
		}
	}
	//?鲢????
	public static void mergeSort(int a[],int left,int right){
		if(left<right){
			int mid=(left+right)>>1;
			mergeSort(a, left, mid);
			mergeSort(a, mid+1, right);
			merge(a, left, right, mid);
			
		}
	}
	public  static void merge(int a[],int left,int right,int mid){
		int i=left,j=mid+1,k=0;
		int temp[]=new int[right-left+1];
		while(i<=mid&&j<=right){
			if(a[i]<a[j]){
				temp[k++]=a[i++];
			}else{
				temp[k++]=a[j++];
			}
		}
		while(i<=mid){
			temp[k++]=a[i++];
		}
		while(j<=right){
			temp[k++]=a[j++];
		}
		int pos=0;
		while(left<=right){
			a[left++]=temp[pos++];
		}
	}
	//????????
	public static void quickSort(int a[],int left,int right){
		int temp=a[left];
		int i=left,j=right;
		while(i<j){
			while(i<j&&a[j]>=temp){
				j--;
			}
			while(i<j&&a[i]<=temp){
				i++;
			}
			if(i<j){
				swap(a, i, j);
				j--;
			}
		}
		a[left]=a[i];
		a[i]=temp;
		if(i>left+1){
			quickSort(a, left, i-1);
		}
		if(i<right-1){
			quickSort(a, i+1, right);
		}
	}

	public static void bubbing(int a[]){
	    for (int i=0;i<a.length;i++){
	        for (int j=1;j<a.length-i;j++){
	            if (a[j]<a[j-1]){
	                int tmp =a[j];
	                a[j]=a[j-1];
	                a[j-1]=tmp;
                }
            }
        }
    }
	
	public static void main(String[] args) {
		int a[]={10,5,7,9,3,4,2,1,5,6,0,3,9,8,7,4};
//		quickSort(a, 0, a.length-1);
		mergeSort(a, 0, a.length-1);
		System.out.println(Arrays.toString(a));
		
	}

}
