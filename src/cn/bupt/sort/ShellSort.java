package cn.bupt.sort;

/**
 * @Author: lichong04
 * @Date: Created in 下午5:20 2019/5/1
 */
public class ShellSort {


    /*
	 * 希尔排序
	 * 时间复杂度O(nlogn)
	 * 稳定排序
	 */
    public static void sort(int num[]){
        int d = num.length/2;
        while (d>0){
            for (int i=0;i<d;i++){
                for (int j=i+d;j<num.length;j++){
                    int tmp = num[j];
                    int pos = j-d;
                    while (pos >= 0 && num[pos]>tmp){
                        num[pos+d] = num[pos];
                        pos-=d;
                    }
                    num[pos+d] = tmp;
                }
            }
            d/=2;
        }
    }
}
