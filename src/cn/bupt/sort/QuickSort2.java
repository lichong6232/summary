package cn.bupt.sort;

import java.util.Arrays;

/**
 * @Author: lichong04
 * @Date: Created in 下午3:55 2019/5/3
 */
public class QuickSort2 {

    public static void sort(int num[],int left,int right){

        if (left<right){
            int partition = partition(num,left,right);
            sort(num,left,partition);
            sort(num,partition+1,right);
        }

    }

    public static void main(String[] args) {
        int num[] = new int[]{1,4,3,2,5,2};
        sort(num,0,num.length);
        System.out.println(Arrays.toString(num));
    }

    private static int partition(int num[],int left,int right){
        int p = left,q = left+1,temp = num[left];
        while (q<right){
            if (num[q]<temp){
                p++;
                swap(num,p,q);
            }
            q++;
        }
        swap(num,left,p);
        return p;

    }

    private static void swap(int num[],int left,int right){
        if (left!=right){
            num[left] = num[left]^num[right];
            num[right] = num[left]^num[right];
            num[left] = num[left]^num[right];
        }
    }
}
