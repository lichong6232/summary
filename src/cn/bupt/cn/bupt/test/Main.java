package cn.bupt.cn.bupt.test;
import java.util.*;
public class Main {

    static class ListNode {

        int val;
        ListNode next;
        public ListNode(int val){
            this.val=val;
        }

    }
    public static boolean isCircle(ListNode root){
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

    public static void main(String args[]){
        Set<String> set=new TreeSet<String>();
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextLine()){
            String s=sc.nextLine();
            String colums[]=s.split(", ");
            String left=colums[0].split("\\{")[1];
            String right=colums[1].split("}")[0];
            Integer leftInt=Integer.parseInt(left.substring(2,left.length()),16);
            Integer rightInt=Integer.parseInt(right.substring(2,right.length()),16);
            set.add(left);
            set.add(right);
            AddDependency(leftInt,rightInt);
            if (!colums[1].contains(",")){
                break;
            }

        }
        int i=0;
        for(String ModuleId:set){
            Integer module=Integer.parseInt(ModuleId.substring(2,ModuleId.length()),16);
            boolean isCircle=MouldeIsCycularDependency(module);
            if (i==set.size()-1){
                System.out.println("{"+ModuleId+", "+isCircle+"}");
            }else {
                System.out.println("{"+ModuleId+", "+isCircle+"},");
            }
            i++;

        }
    }

   public static void AddDependency(int ModuleId, int DependModuleId){
        ListNode sNode=null;
        ListNode tNode=null;
        if (nodeMap.containsKey(ModuleId)){
            sNode=nodeMap.get(ModuleId);
        }else {
            sNode=new ListNode(ModuleId);
            nodeMap.put(ModuleId,sNode);
        }
        if (nodeMap.containsKey(DependModuleId)){
            tNode=nodeMap.get(DependModuleId);
        }else {
            tNode=new ListNode(DependModuleId);
            nodeMap.put(DependModuleId,tNode);
        }
        sNode.next=tNode;
    }
    public static boolean MouldeIsCycularDependency(Integer ModuleId){

        ListNode node=nodeMap.get(ModuleId);
        boolean isCircle=isCircle(node);
        return isCircle;
    }

    public static Map<Integer,ListNode> nodeMap=new HashMap<Integer,ListNode>();
}
