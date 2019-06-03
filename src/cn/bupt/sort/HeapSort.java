package cn.bupt.sort;

import java.util.Arrays;

/**
 * @Author: lichong04
 * @Date: Created in 下午11:59 2019/5/3
 */
public class HeapSort {

    public static void main(String[] args) {
        int num[] = new int[]{5,1,2,7,9,0,4,10,7,5};
        sort(num);
        System.out.println(Arrays.toString(num));
    }

    public static void sort(int num[]){
        int length = num.length-1;
        for (int i = 0;i<num.length;i++){
            buildMaxHeap(length-i,num);
            swap(num,0,length-i);
        }
    }

    private static void swap(int num[],int left,int right){
        if (left!=right){
            num[left] = num[left]^num[right];
            num[right] = num[left]^num[right];
            num[left] = num[left]^num[right];
        }
    }

    private static void buildMaxHeap(int lastIndex,int num[]){
        for (int i=(lastIndex-1)/2;i>=0;i--){
            int k = i;
            while (2*k+1<=lastIndex){
                int biggerIndex = 2*k+1;
                if (biggerIndex<lastIndex){
                    if (num[biggerIndex]<num[biggerIndex+1]){
                        biggerIndex++;
                    }
                }
                if (num[k]<num[biggerIndex]){
                    swap(num,k,biggerIndex);
                    k = biggerIndex;
                }else {
                    break;
                }
            }
        }
    }
}
