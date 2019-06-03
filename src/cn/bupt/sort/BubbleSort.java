package cn.bupt.sort;

/**
 * @Author: lichong04
 * @Date: Created in 下午3:34 2019/5/1
 */
public class BubbleSort {

    /*
	 * 冒泡排序
	 * 时间复杂父O(n^2)
	 * 稳定排序
	 */
    public static void sort(int a[]){
        for (int i=0;i<a.length;i++){
            for (int j=1;j<a.length-i;j++){
                if (a[j]<a[j-1]){
                    int tmp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = tmp;
                }
            }
        }
    }
}
