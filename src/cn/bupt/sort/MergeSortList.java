package cn.bupt.sort;

import cn.bupt.link.ListNode;

/**
 * @Author: lichong04
 * @Date: Created in 下午1:40 2019/5/4
 */
public class MergeSortList {

    public static ListNode sort(ListNode root){
        if (root == null || root.next == null){
            return root;
        }
        ListNode mid = getMid(root);
        ListNode right = mid.next;
        mid.next = null;
        return merge(sort(root),sort(right));
    }

    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(6);
        ListNode listNode2 = new ListNode(9);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(2);
        ListNode listNode6 = new ListNode(5);
        ListNode listNode7 = new ListNode(10);
        ListNode listNode8 = new ListNode(1);
        ListNode listNode9 = new ListNode(7);
        ListNode listNode10 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        listNode7.next = listNode8;
        listNode8.next = listNode9;
        listNode9.next = listNode10;
        ListNode sort = sort(listNode1);
        while (sort!=null){
            System.out.println(sort.val);
            sort = sort.next;
        }
    }


    public static ListNode merge(ListNode left, ListNode right){

        ListNode temp = new ListNode(0);
        ListNode curr = temp;
        while (left!=null&&right!=null){
            if (left.val<=right.val){
                curr.next = left;
                left = left.next;
            }else {
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }
        if (left!=null){
            curr.next = left;
        }
        if (right!=null){
            curr.next = right;
        }
        return temp.next;

    }

    private static ListNode getMid(ListNode root){
        ListNode slow = root;
        ListNode fast = root;
        while (fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


}
