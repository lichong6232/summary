package cn.bupt.search;

public class BinSearch {
	
	//在旋转数组中查找元素，例如5,6,7,8,9,10,1,2,3,4中查找2
	public static int searchRotateArray(int a[],int target){
		int left=0,right=a.length-1;
		while(left<=right){
			int mid=(left+right)>>1;
			if(a[mid]==target)
				return mid;
			if(a[mid]>=a[left]){
				if(target<a[mid]&&target>=a[left])
					right=mid-1;
				else
					left=mid+1;
			}else{
				if(target<=a[right]&&target>a[mid])
					left=mid+1;
				else
					right=mid-1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int a[]={0,0,0,0,0,1,0,0,0};
		int index=searchRotateArray(a, 1);
		System.out.println(index);
	}

}
