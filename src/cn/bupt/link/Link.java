package cn.bupt.link;


import java.util.List;

public class Link {
	
	//遍历链表
	public void printList(ListNode root){
		ListNode current=root;
		while(current!=null){
			System.out.println(current.val);
			current=current.next;
		}
	}
	
	//从头到尾打印链表
	public void printListFromTailToHead(ListNode listNode) {
        if(listNode!=null){
        	printListFromTailToHead(listNode.next);
        	System.out.println(listNode.val);
        }
    }
	
	//链表中倒数第k个节点
	public ListNode FindKthToTail(ListNode head,int k) {
		if(head==null||k<1)
			return null;
		ListNode p=head,q=head;
		int i=0;
		while(p!=null){
			if(i++>=k){
				q=q.next;
			}
			p=p.next;
		}
		return q;
	}
	
	//反转链表
	 public ListNode reverseList(ListNode head) {
		 ListNode pre=null;
		 ListNode current=head;
		 while(current!=null){
			 ListNode temp=current.next;
			 current.next=pre;
			 pre=current;
			 current=temp;
		 }
		 return pre;

	 }

	 public ListNode reverseList1(ListNode head){
	    ListNode pre =head;
	    while (head.next!=null){
            ListNode next = head.next;
            head.next = next.next;
            next.next = pre;
            pre = next;
        }
        return pre;
     }

     public ListNode reverseList2(ListNode head){
	     ListNode dummp = new ListNode(0);
	     dummp.next = head;
	     while (head.next!=null){
             ListNode next = head.next;
             head.next = next.next;
             next.next = dummp.next;
             dummp.next = next;
         }
         return dummp.next;
     }
	 
	 //链表的归并排序
	 public ListNode mergeSort(ListNode head){
		 if(head==null||head.next==null)
			 return head;
		 ListNode mid=getMide(head);
		 ListNode right=mid.next;
		 mid.next=null;
		 return merge(mergeSort(head), mergeSort(right));
	 }
	 //合并两个链表
	 public ListNode merge(ListNode list1,ListNode list2){
		 if(list1==null)
			 return list2;
		 if(list2==null)
			 return list1;
		 ListNode root=new ListNode(0);
		 ListNode left=list1,right=list2,curr=root;
		 while(left!=null&&right!=null){
			 if(left.val<right.val){
				 curr.next=left;
				 left=left.next;
			 }else{
				 curr.next=right;
				 right=right.next;
			 }
			 curr=curr.next;
		 }
		 if(left!=null){
			 curr.next=left;
		 }else{
			 curr.next=right;
		 }
		 return root.next;
	 }
	 //获得链表的中间值
	 public ListNode getMide(ListNode root){
		 ListNode slow=root,fast=root;
		 if(root==null)
			 return null;
		 if(fast.next!=null&&fast.next.next!=null){
			 fast=fast.next.next;
			 slow=slow.next;
		 }
		 return slow;
	 }
	 
	 public void swap(ListNode p,ListNode q){
		 if(p!=q){
			 int temp=p.val;
			 p.val=q.val;
			 q.val=temp;
		 }
	 }
	 //快速排序
	 public ListNode quickSort(ListNode left,ListNode right){
		 if(left!=right){
			 ListNode partition=partition(left, right);
			 quickSort(left, partition);
			 quickSort(partition.next, right);
		 }
		 return left;
	 }
	 
	 
	 
	 public ListNode partition(ListNode left,ListNode right){
		 ListNode p=left,q=left.next;
		 int key=left.val;
		 while(q!=right){
			 if(q.val<key){
				 p=p.next;
				 swap(p, q);
				 
			 }
			 q=q.next;
		 }
		 swap(left, p);
		 return p;
		 
	 }
	 
	 //链表的插入排序
	 public ListNode insertSort(ListNode head){
		 ListNode root=new ListNode(Integer.MAX_VALUE);
		 ListNode curr=head;
		 while(curr!=null){
			 ListNode temp=root;
			 ListNode next=curr.next;
			 while(temp.next!=null&&temp.next.val<curr.val){
				 temp=temp.next;
			 }
			 curr.next=temp.next;
			 temp.next=curr;
			 curr=next;
		 }
		 return root.next;
	 }
	 //判断一个链表是否有环
	 public boolean isCircle(ListNode root){
		 if(root==null)
			 return false;
		 ListNode slow=root,fast=root;
		 while(fast!=null&&fast.next!=null){//如果是在这一步终止的条件说明没有环存在
			 fast=fast.next.next;
			 slow=slow.next;
			 if(fast==slow)//如果是在这一步终止的条件，说明有环存在
				 break;
		 }
		 return (fast==null || fast.next==null)?false:true;
	 }
	 
	 //给一个链表返回环开始的地方，如果没有环则返回空
	 public ListNode detectCycle(ListNode root){
		 if(root==null)
			 return null;
		 ListNode slow=root,fast=root;
		 while(fast!=null&&fast.next!=null){
			 fast=fast.next.next;
			 slow=slow.next;
			 if(fast==slow)
				 break;
		 }
		 if(fast==null||fast.next==null)
			 return null;
		 slow=root;
		 while(slow!=fast){
			 slow=slow.next;
			 fast=fast.next;
		 }
		 return slow;
	 }

	 private static void out(ListNode head){
	     ListNode current = head;
	     while (current!=null){
             System.out.println(current.val);
             current = current.next;
         }
     }
	
	public static void main(String[] args) {
		Link link=new Link();
		ListNode root=new ListNode(0);
		ListNode node1=new ListNode(1);
		ListNode node2=new ListNode(2);
		ListNode node3=new ListNode(3);
		ListNode node4=new ListNode(4);
		ListNode node5=new ListNode(5);
		ListNode node6=new ListNode(6);
		root.next=node1;
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
		node5.next=node6;
//		node6.next=node4;
//		link.printListFromTailToHead(root);
		/*ListNode nodek=link.FindKthToTail(root, 1);
		System.out.println(nodek.val);*/
/*		ListNode reverseNode=link.ReverseList(root);
		link.printList(reverseNode);*/
		/*ListNode mergeSortNode=link.mergeSort(root);
		link.printList(mergeSortNode);*/
		/*ListNode quickSortNode=link.quickSort(root, null);
		link.printList(quickSortNode);*/
		/*ListNode insertNode=link.insertSort(root);
		link.printList(insertNode);*/
//		ListNode circleNode=link.detectCycle(root);
//		System.out.println(circleNode.val);
        ListNode listNode = link.reverseList2(root);
        out(listNode);



    }

}
