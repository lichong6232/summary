package cn.bupt.tree;

import java.util.Stack;

/**
 * @Author: lichong04
 * @Date: Created in 下午10:54 2019/5/4
 */
public class TraversalTree {

    public static void preTraversal(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node!=null){
            System.out.println(node.data);
            stack.add(node);
            node = node.left;
            while (node == null && !stack.isEmpty()){
                node = stack.pop().right;
            }
        }
    }

    public static void midTraversal(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node!=null){
            stack.add(node);
            node = node.left;
            while (node == null && !stack.isEmpty()){
                TreeNode pop = stack.pop();
                System.out.println(pop.data);
                node = pop.right;
            }
        }
    }

}
