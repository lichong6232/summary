package cn.bupt.sort;

import cn.bupt.link.ListNode;

/**
 * @Author: lichong04
 * @Date: Created in 下午2:49 2019/5/4
 */
public class InsertSortList {

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

    public static ListNode sort(ListNode head){
        ListNode root = new ListNode(0);
        ListNode curr = head;
        while (curr!=null){
            ListNode temp = root;
            while (temp.next!=null && temp.next.val<=curr.val){
                temp = temp.next;
            }
            ListNode next = curr.next;
            curr.next = temp.next;
            temp.next = curr;
            curr = next;
        }
        return root.next;
    }
}
