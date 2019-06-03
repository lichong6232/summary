package cn.bupt.sort;

/**
 * @Author: lichong04
 * @Date: Created in 下午3:41 2019/5/1
 */
public class SelectSort {

    public static void sort(int num[]){
        for (int i=0;i<num.length;i++){
            int minIndex = i;
            for (int j=i+1;j<num.length;i++){
                if (num[j]<num[minIndex]){
                    minIndex = j;
                }
            }
            int tmp = num[minIndex];
            num[minIndex] = num[i];
            num[i] = num[minIndex];
        }
    }
}
