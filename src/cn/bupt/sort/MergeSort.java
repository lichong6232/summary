package cn.bupt.sort;

/**
 * @Author: lichong04
 * @Date: Created in 下午6:39 2019/5/2
 */
public class MergeSort {



    private static void sort(int left, int right,int num[]){
        while (left<right){
            int mid = (left+right)/2;
            sort(left,mid,num);
            sort(mid+1,right,num);
            merge(left,right,mid,num);
        }
    }


    private static void merge(int left, int right, int mid, int num[]){
        int tmp[] = new int[right-left+1];
        int i = left;
        int j = mid+1;
        int pos = 0;
        while (i<=mid && j<=right){
            if (num[i]<=num[j]){
                tmp[pos++] = num[i++];
            }else {
                tmp[pos++] = num[j++];
            }
        }
        while (i<=mid){
            tmp[pos++] = num[i++];
        }
        while (j<=mid){
            tmp[pos++] = num[j++];
        }
        int start = 0;
        while (start<tmp.length){
            num[left++] = tmp[start++];
        }
    }
}
