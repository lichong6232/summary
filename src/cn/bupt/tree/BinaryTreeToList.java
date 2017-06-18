package cn.bupt.tree;

import java.util.Stack;

public class BinaryTreeToList {
	
	public static void main(String[] args) {
		Tree tree=new Tree();
		tree.build(5);
		tree.build(10);
		tree.build(6);
		tree.build(9);
		tree.build(3);
		tree.build(2);
		tree.build(7);
		tree.build(4);
		tree.build(1);
		BinaryTreeToList binaryTreeToList=new BinaryTreeToList();
		TreeNode list=binaryTreeToList.binaryTreeToList(tree.root);
		binaryTreeToList.visite(list);
	}
	
	public void visite(TreeNode root){
		TreeNode node=root;
		while(node!=null){
			System.out.println(node.data);
			node=node.right;
		}
	}
	
	public TreeNode binaryTreeToList(TreeNode root){
		TreeNode node=root;
		Stack<TreeNode> stack=new Stack<TreeNode>();
		TreeNode head=null;
		TreeNode pre=null;
		while(node!=null){
			stack.push(node);
			node=node.left;
			while(node==null&&!stack.isEmpty()){
				TreeNode temp=stack.pop();
				if(head==null){
					head=temp;
					pre=head;
				}else{
					pre.right=temp;
					temp.left=pre;
					pre=temp;
				}
				node=temp.right;
			}
		}
		return head;
	}

}
