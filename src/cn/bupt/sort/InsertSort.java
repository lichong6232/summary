package cn.bupt.sort;

/**
 * @Author: lichong04
 * @Date: Created in 下午3:51 2019/5/1
 */
public class InsertSort {


    /*
	 * 插入排序
	 * 时间复杂度O(n^2)
	 * 稳定排序
	 */
    public static void sort(int num[]){
        for (int i=1;i<num.length;i++){
            int tmp = num[i];
            int j = i-1;
            while (j>=0 && num[j]>tmp){
                num[j+1] = num[j];
                j--;
            }
            num[j+1] = tmp;

        }
    }
}
