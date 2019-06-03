package cn.bupt.sort;

import cn.bupt.link.ListNode;

/**
 * @Author: lichong04
 * @Date: Created in 下午1:33 2019/5/4
 */
public class QuickSortList {

    public static ListNode sort(ListNode head){
        return sortList(head,null);
    }

    public static ListNode sortList(ListNode left, ListNode right){
        if (left!=right){
            ListNode partition = partition(left,right);
            sortList(left,partition);
            sortList(partition.next,right);
        }
        return left;
    }

    private static void swap(ListNode left, ListNode right){
        if (left!=right){
            left.val = left.val^right.val;
            right.val = left.val ^ right.val;
            left.val = left.val^right.val;
        }
    }

    public static ListNode partition(ListNode left, ListNode right){
        ListNode p = left,q = left.next;
        int temp = left.val;
        while (q!=right){
            if (q.val<temp){
                p = p.next;
                swap(p,q);
            }
            q = q.next;
        }
        swap(left,p);
        return p;
    }
}
