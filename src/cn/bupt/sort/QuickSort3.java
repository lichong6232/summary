package cn.bupt.sort;

/**
 * @Author: lichong04
 * @Date: Created in 下午4:47 2019/5/3
 */
public class QuickSort3 {

    public static void sort(int num[], int left, int right){
        if (left<right){
            int partition[] = getPartition(num,left,right);
            sort(num,left,partition[0]-1);
            sort(num,partition[1]+1,right);
        }
    }

    private static int[] getPartition(int num[], int left, int right){
        int i=left-1,j=right+1,current = left,temp = num[left];
        while (current!=right){
            if (num[current] == temp){
                current++;
            }else if (num[current]<temp){
                swap(num,++i,current++);
            }else {
                swap(num,current,--j);
            }

        }
        int par[] = new int[2];
        par[0] = i+1;
        par[1] = j-1;
        return par;
    }

    private static void swap(int num[],int i,int j){
        if (i!=j){
            num[i] = num[i]^num[j];
            num[j] = num[i]^num[j];
            num[i] = num[i]^num[j];
        }
    }
}
