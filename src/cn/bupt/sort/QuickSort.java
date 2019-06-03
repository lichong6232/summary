package cn.bupt.sort;

/**
 * @Author: lichong04
 * @Date: Created in 下午6:53 2019/5/2
 */
public class QuickSort {

    public static void sort(int num[], int left, int right){
        if (left<right){
            int i = left,j = right,temp = num[left];
            while (i<j){

                while (i<j && num[j]>temp){
                    j--;
                }
                while (i<j && num[i]<temp){
                    i++;
                }
                if (i<j){
                    int t = num[i];
                    num[i] = num[j];
                    num[j] = t;
                    j--;
                }
            }
            num[left] = num[i];
            num[i] = temp;
            if (left<i-1){
                sort(num,left,i-1);
            }
            if (right>i+1){
                sort(num,i+1,right);
            }
        }
    }
}
