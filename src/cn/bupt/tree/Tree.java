package cn.bupt.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Tree {
	
	
	 TreeNode root;
	
	//��������������
	public void build(int data){
		TreeNode node=new TreeNode(data);
		if(root==null)
			root=node;
		else{
			TreeNode parent=null;
			TreeNode current=root;
			boolean isLeft=true;
			while(current!=null){
				parent=current;
				if(data<current.data){
					current=current.left;
					isLeft=true;
				}else{
					current=current.right;
					isLeft=false;
				}
			}
			if(isLeft){
				parent.left=node;
			}else{
				parent.right=node;
			}
		}
	}
	
	//�ǵݹ��ǰ�����
	public void preVisiteNoRecursion(){
		Stack<TreeNode> stack=new Stack<TreeNode>();
		TreeNode node=this.root;
		while(node!=null){
			System.out.println(node.data);
			stack.push(node);
			node=node.left;
			while(node==null&&!stack.isEmpty()){
				node=stack.pop().right;
			}
		}
	}
	
	//�ݹ��ǰ���������
	public void preVisite(TreeNode node){
		if(node!=null){
			System.out.println(node.data);
			preVisite(node.left);
			preVisite(node.right);
		}
	}
	
	//�ǵݹ�������������
	public void minVisiteNoRecursion(){
		TreeNode node=this.root;
		Stack<TreeNode> stack=new Stack<TreeNode>();
		while(node!=null){
			stack.push(node);
			node=node.left;
			while(node==null&&!stack.isEmpty()){
				TreeNode temp=stack.pop();
				System.out.println(temp.data);
				node=temp.right;
			}
		}
	}
	
	//�ݹ�������������
	public void midVisite(TreeNode node){
		if(node!=null){
			midVisite(node.left);
			System.out.println(node.data);
			midVisite(node.right);
		}
	}
	//�ǵݹ�ĺ�������
	public void lastVisiteNoRecursion(){
		TreeNode node=this.root;
		if(node==null)
			return;
		Stack<TreeNode> stack=new Stack<TreeNode>();
		TreeNode pre=null;
		stack.push(node);
		while(!stack.isEmpty()){
			TreeNode temp=stack.peek();
			if((temp.left==null&&temp.right==null)||(pre!=null&&(temp.left==pre||temp.right==pre))){
				System.out.println(stack.pop().data);
				pre=temp;
			}else{
				if(temp.right!=null)
					stack.push(temp.right);
				if(temp.left!=null)
					stack.push(temp.left);
			}
		}
	}
	//�ݹ�ĺ�������
	public void lastVisite(TreeNode node){
		if(node!=null){
			lastVisite(node.left);
			lastVisite(node.right);
			System.out.println(node.data);
		}
	}
	
	//�����������
	public int depth(TreeNode root){
		if(root!=null){
			return Math.max(depth(root.left), depth(root.right))+1;
		}
		return 0;
	}
	
	//�Ƿ�Ϊƽ�������
	public boolean isBalance(TreeNode root){
		if(root!=null){
			return Math.abs(depth(root.left)-depth(root.right))<2&&isBalance(root.left)&&isBalance(root.right);
		}
		return true;
	}
	
	//�������Ӹ��ڵ㵽Ҷ�ӽڵ������·����Ϣ
	public void getPath(List<List<String>> paths,List<String> path,TreeNode root){
		if(root==null)
			return;
		path.add(String.valueOf(root.data));
		if(root.left==null&&root.right==null){
			paths.add(new ArrayList<String>(path));
		}
		getPath(paths, path, root.left);
		getPath(paths, path, root.right);
		path.remove(path.size()-1);
	}
	//�ҳ��Ӹ��ڵ㵽Ҷ�ӽڵ��·����Ϣ��Ϊĳ��ֵ��·��
	public void getTargetPath(List<List<String>> paths,List<String> path,TreeNode root,int target){
		if(root==null)
			return;
		target-=root.data;
		path.add(String.valueOf(root.data));
		if(target==0&&root.left==null&&root.right==null){
			paths.add(new ArrayList<String>(path));
		}
		getTargetPath(paths, path, root.left,target);
		getTargetPath(paths, path, root.right,target);
		path.remove(path.size()-1);
	}
	//�Ӹ��ڵ㵽Ҷ�ӽڵ�·����Ϣ���ܺ�
	public int getPathSum(int tempSum,TreeNode root){
		if(root==null)
			return 0;
		if(root.left==null&&root.right==null)
			return tempSum+root.data;
		return getPathSum(tempSum+root.data, root.left)+getPathSum(tempSum+root.data, root.right);
	}
	//����ǰ�������������������й���������
	public TreeNode buildTreePreAndMid(int pre[],int preLeft,int preRight,int mid[],int midLeft,int midRight){
		if(preLeft>preRight || midLeft>midRight)
			return null;
		TreeNode treeNode=new TreeNode(pre[preLeft]);
		int i=midLeft;
		for(;i<=midRight;i++){
			if(pre[preLeft]==mid[i]){
				break;
			}
		}
		treeNode.left=buildTreePreAndMid(pre, preLeft+1, preLeft+i-midLeft, mid, midLeft, i-1);
		treeNode.right=buildTreePreAndMid(pre, preLeft+i-midLeft+1, preRight, mid, i+1, midRight);
		return treeNode;
			
	}
	//���ݺ������������������й���������
	public TreeNode buildTreeLastAndMid(int last[],int lastLeft,int lastRight,int mid[],int midLeft,int midRight){
		if(lastLeft>lastRight || midLeft>midRight)
			return null;
		TreeNode treeNode=new TreeNode(last[lastRight]);
		int i=midLeft;
		for(;i<=midRight;i++){
			if(last[lastRight]==mid[i])
				break;
		}
		treeNode.left=buildTreeLastAndMid(last, lastLeft, lastLeft+i-midLeft-1, mid, midLeft, i-1);
		treeNode.right=buildTreeLastAndMid(last, lastLeft+i-midLeft, lastRight-1, mid, i+1, midRight);
		return treeNode;
	}
	//�ж�A�ǲ���B���ӽṹ
	public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean success=false;
        if(root1!=null&&root2!=null){
        	if(root1.data==root2.data)
        		success= Tree1HasTree2(root1, root2);
        	if(!success)
        		success= HasSubtree(root1.left, root2);
        	if(!success)
        		success= HasSubtree(root1.right, root2);
        }
		
		return success;
    }
	
	private boolean Tree1HasTree2(TreeNode root1,TreeNode root2){
		if(root1==null&&root2!=null)
			return false;
		if(root2==null)
			return true;
		if(root1.data!=root2.data)
			return false;
		return Tree1HasTree2(root1.left, root2.left)&&Tree1HasTree2(root1.right, root2.right);
		
	}
	
	//�������Ĳ�α���
	public void levelVisite(TreeNode root){
		
		if(root==null)
			return;
		Queue<TreeNode> queue=new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()){
			TreeNode node=queue.poll();
			System.out.println(node.data);
			if(node.left!=null)
				queue.add(node.left);
			if(node.right!=null)
				queue.add(node.right);
		}
		
	}
	
	//�������ľ���
	public void Mirror(TreeNode root){
		if(root!=null){
			TreeNode temp=root.left;
			root.left=root.right;
			root.right=temp;
			Mirror(root.left);
			Mirror(root.right);
		}
	}
	//����һ�������������������жϸ������Ƿ��Ǻ������
	public boolean isLastViste(int sequence[],int left,int right){
		if(left>=right)
			return true;
		int i=right;
		for(;i>=left;i--){
			if(sequence[i]<sequence[right]){
				break;
			}
		}
		for(int j=left;j<i;j++){
			if(sequence[j]>sequence[right]){
				return false;
			}
		}
		return isLastViste(sequence, left, i)&&isLastViste(sequence, i+1, right-1);
	}
	//����һ�������������������жϸ������Ƿ���ǰ�����
	public boolean isPreVisite(int sequence[],int left,int right){
		if(left>=right)
			return  true;
		int i=left;
		for(;i<=right;i++){
			if(sequence[i]>sequence[left])
				break;
		}
		for(int j=i+1;j<=right;j++){
			if(sequence[j]<sequence[left]){
				return false;
			}
		}
		return isPreVisite(sequence, left+1, i-1)&&isPreVisite(sequence, i, right);
	}
	/*
	 * �����������ֵ�k���Ľڵ�
	 * ˼·����������ǵݹ�����������������ʵ��ڵ�k���ڵ�ʱ�����ýڵ㷵��
	 */
	public TreeNode KthNode(TreeNode pRoot, int k){
		if(pRoot==null||k<1)
			return null;
        TreeNode node=pRoot;
        Stack<TreeNode> stack=new Stack<TreeNode>();
        int i=1;
        while(node!=null){
        	stack.add(node);
        	node=node.left;
        	while(node==null&&!stack.isEmpty()){
        		TreeNode temp=stack.pop();
        		if(i++==k){
        			return temp; 
        		}
        		node=temp.right;
        	}
        }
        return null;
    }
	
	
	public static void main(String[] args) {
		Tree tree=new Tree();
		tree.build(5);
		tree.build(3);
		tree.build(7);
		tree.build(2);
		tree.build(4);
		tree.build(6);
		tree.build(8);
		/*tree.build(5);
		tree.build(10);
		tree.build(6);
		tree.build(9);
		tree.build(3);
		tree.build(2);
		tree.build(7);
		tree.build(4);
		tree.build(1);*/
//		tree.lastVisite(tree.root);
//		tree.levelVisite(tree.root);
//		int sequence[]={1,3,4,2,8,10,9,6,5};
//		System.out.println(tree.isPreVisite(sequence, 0, sequence.length-1));
		TreeNode kThNode=tree.KthNode(tree.root, 3);
		System.out.println(kThNode.data);
	
		
		
	}

}
